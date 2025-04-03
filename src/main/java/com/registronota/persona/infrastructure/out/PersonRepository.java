package com.registronota.persona.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import com.registronota.persona.domain.PersonService;
import com.registronota.persona.domain.entity.Person;

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
             phone_number) VALUES (?,?,?,?,?,?,?)""";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, person.getId());
            ps.setInt(2, person.getIdTypeDocument());
            ps.setString(3, person.getName());
            ps.setString(4, person.getLastName());
            ps.setDate(5, Date.valueOf(person.getBirthDate()));
            ps.setString(6, person.getEmail());
            ps.setInt(7, person.getPhoneNumber());

            ps.executeUpdate();


        } catch (SQLException e) {
            // TODO: handle exception
        }


    }

    @Override
    public void updatePerson(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePerson'");
    }

    @Override
    public Optional<Person> deletePerson(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePerson'");
    }

    @Override
    public Optional<Person> searchPersonById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchPersonById'");
    }



}
