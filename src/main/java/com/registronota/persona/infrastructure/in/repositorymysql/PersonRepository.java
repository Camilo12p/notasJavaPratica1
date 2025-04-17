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
import com.registronota.persona.domain.service.PersonService;
import com.registronota.typedoc.domain.entity.TypeDocument;

public class PersonRepository implements PersonService {
    
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
             password) 
             VALUES (?,?,?,?,?,?,?,?);""";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, person.getId());
            ps.setInt(2, person.getTypeDocument().getId());
            ps.setString(3, person.getName());
            ps.setString(4, person.getLastName());
            ps.setDate(5, Date.valueOf(person.getBirthDate()));
            ps.setString(6, person.getEmail());
            ps.setLong(7, person.getPhoneNumber());
            ps.setString(8, person.getPassword());


            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }


    }

    @Override
    public void updatePerson(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePerson'");
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
    public Optional<Person> searchPersonById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchPersonById'");
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> persons = new ArrayList<>();
        String query = 
        """
        SELECT 
            id,
            id_typedoc,
            name,
            lastname,
            birthday,
            email,
            phone_number
            password
            td.id AS type_id
            td.name AS type_name

            FROM person p
            JOIN type_document td ON p.id_typedoc = td.id;
        """;
        try{

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                TypeDocument typeDocument = new TypeDocument();
                typeDocument.setId(rs.getInt("type_id"));
                typeDocument.setName(rs.getString("type_name"));
                
                Person person = new Person(
                    rs.getLong("id"),
                    typeDocument,
                    rs.getString("name"),
                    rs.getString("last_name"),
                    rs.getDate("birthdate").toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate(),
                    rs.getInt("phone_number"),
                    rs.getString("password")
                );

                persons.add(person);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        
        return persons;
        
    }



}
