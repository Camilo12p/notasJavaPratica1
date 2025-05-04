package com.registronota.persona.infrastructure.in.repositorymysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.registronota.persona.domain.entity.Person;
import com.registronota.persona.domain.entity.dto.PersonEntranceLoginDTO;
import com.registronota.persona.domain.entity.dto.PersonOutDTO;
import com.registronota.persona.domain.service.PersonServiceRepository;
import com.registronota.rolPerson.domain.entity.RolPerson;
import com.registronota.typedoc.domain.entity.TypeDocument;

public class PersonRepository implements PersonServiceRepository {
    
    private Connection connection;

    public PersonRepository (){
        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("propertiesDB.properties"));
            String url = properties.getProperty("url");
            String user= properties.getProperty("user");
            String password=properties.getProperty("password");
            this.connection = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void createPerson(Person person) {

        try {
            String query = """
            INSERT INTO person
             (id,
             id_type_doc,
             name,
             last_name,
             birthday,
             email,
             phone_number,
             password,
             id_rol_person
             ) 
             VALUES (?,?,?,?,?,?,?,?,?);""";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, person.getId());
            ps.setInt(2, person.getTypeDocument().getId());
            ps.setString(3, person.getName());
            ps.setString(4, person.getLastName());
            ps.setDate(5, Date.valueOf(person.getBirthDate()));
            ps.setString(6, person.getEmail());
            ps.setLong(7, person.getPhoneNumber());
            ps.setString(8, person.getPassword());
            ps.setInt(9, person.getRolPerson().getId());

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }


    }

    @Override
    public void updateRolPerson(int idRolPerson , Long idPerson ) {
        String query = """
                UPDATE person 
                SET id_rol_person = ?
                WHERE id = ?;
                 
                """;
    }

    @Override
    public void deletePersonById(Long id) {
        try{
            // query
            String query = """
                    DELETE FROM person WHERE id = ?
                    """;
            
            // connection to databases    
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            int affectedrows = ps.executeUpdate();

            if(affectedrows>0){
                System.out.println(MessageFormat.format("el id = {0} se elimino correctamente", id));
            }else{
                System.out.println(MessageFormat.format("No se elimino el id = {0}",id));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<PersonOutDTO> searchPersonById(Long id) {
        
        String query = """
                SELECT 
                    id,
                    id_typedoc,
                    name,
                    lastname,
                    birthday,
                    email,
                    phone_number,
                    id_rol_person,
                    
                    rp.id,
                    rp.name,
                    td.id AS type_id,
                    td.name AS type_name

                    FROM persona as p
                    JOIN type_document as td ON p.id_typedoc = td.id
                    JOIN rol_person as rp ON p.id_rol_person = rp.id
                    WHERE p.id = ?;
                """;
        try{

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TypeDocument typeDocument = new TypeDocument();
                    typeDocument.setId(rs.getInt("type_id"));
                    typeDocument.setName(rs.getString("type_name"));
                
                RolPerson rolPerson = new RolPerson();
                    rolPerson.setId(rs.getInt("rp.id"));
                    rolPerson.setName(rs.getString("rp.name"));

                PersonOutDTO personOutDTO = new PersonOutDTO();

                    personOutDTO.setId(rs.getLong("id"));
                    personOutDTO.setTypeDocument(typeDocument);
                    personOutDTO.setName(rs.getString("name"));
                    personOutDTO.setLastName(rs.getString("last_name"));
                    personOutDTO.setBirthDate(rs.getDate("birthday").toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
                    personOutDTO.setPhoneNumber(rs.getLong("phone_number"));
                    personOutDTO.setRolPerson(rolPerson);

                return Optional.of(personOutDTO);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public List<PersonOutDTO> getAllPerson() {
        List<PersonOutDTO> persons = new ArrayList<>();
        String query = 
        """
        SELECT 
            id,
            id_typedoc,
            name,
            lastname,
            birthday,
            email,
            phone_number,
            id_rol_id,

            td.id AS type_id,
            td.name AS type_name,

            rp.id,
            rp.name

            FROM person p
            JOIN type_document td ON p.id_typedoc = td.id
            JOIN rol_person rp ON p.id_rol_person = rp.id;
        """;
        try{

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                TypeDocument typeDocument = new TypeDocument();
                    typeDocument.setId(rs.getInt("type_id"));
                    typeDocument.setName(rs.getString("type_name"));

                RolPerson rolPerson = new RolPerson();
                    rolPerson.setId(rs.getInt("rp.id"));
                    rolPerson.setName(rs.getString("rp.name"));
                
                PersonOutDTO personOutDTO = new PersonOutDTO();

                    personOutDTO.setId(rs.getLong("id"));
                    personOutDTO.setTypeDocument(typeDocument);
                    personOutDTO.setName(rs.getString("name"));
                    personOutDTO.setLastName(rs.getString("last_name"));
                    personOutDTO.setBirthDate(rs.getDate("birthdate").toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
                    personOutDTO.setPhoneNumber(rs.getLong("phone_number"));
                    personOutDTO.setRolPerson(rolPerson);

                persons.add(personOutDTO);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        
        return persons;
        
    }

    @Override
    public boolean verifyEmail(String email) {
        String query = """
                SELECT email FROM person AS p
                WHERE p.email = ?;
                """;
            
        try{

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,email);
            ResultSet rs =  ps.executeQuery();

            while (rs.next()) {
                return false;
            }

        }catch (SQLException e ){
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public Optional<PersonEntranceLoginDTO> searchPersonByEmail(String email) {
        String query ="""
                SELECT email,password FROM person p
                WHERE p.email = ?;
                """;
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                PersonEntranceLoginDTO personEntranceLoginDTO = new PersonEntranceLoginDTO();
                    personEntranceLoginDTO.setEmail(rs.getString("email"));
                    personEntranceLoginDTO.setPassword(rs.getString("password"));
                
                return Optional.of(personEntranceLoginDTO);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }


    
    

}
