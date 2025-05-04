package com.registronota.rolPerson.infrastrucute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

import com.registronota.rolPerson.domain.entity.RolPerson;
import com.registronota.rolPerson.domain.service.RolPersonServiceRepo;

public class RolPersonRepository implements RolPersonServiceRepo {

    private Connection connection;

    public RolPersonRepository() {
        
        try{
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader()
                        .getResourceAsStream("propertiesDB.properties"));
            
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            this.connection = DriverManager.getConnection(url,user,password);
    
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<RolPerson> getRolPersonById(int id) {
        String query = """
                SELECT id,name FROM rol_person
                WHERE id=?;
                """;

        try{
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id);
            ResultSet rSet = pStatement.executeQuery();

            while(rSet.next()){
                RolPerson rolPerson = new RolPerson();
                    rolPerson.setId(rSet.getInt("id"));
                    rolPerson.setName(rSet.getString("name"));

                return Optional.of(rolPerson);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        

        return Optional.empty();

    }


    

}
