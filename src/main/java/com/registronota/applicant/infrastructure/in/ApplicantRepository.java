package com.registronota.applicant.infrastructure.in;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.registronota.applicant.domain.entity.Applicant;
import com.registronota.applicant.domain.entity.dto.ApplicantOutDTO;
import com.registronota.applicant.domain.service.ApplicantServiceRepository;
import com.registronota.persona.domain.entity.Person;


public class ApplicantRepository implements ApplicantServiceRepository {

    private Connection connection;

    public ApplicantRepository(){
        Properties properties = new Properties();
        try{
            properties.load(getClass().getClassLoader().getResourceAsStream("propertiesDB.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            
            this.connection = DriverManager.getConnection(url,user,password);
        }catch(Exception e ){
            e.printStackTrace();
        }   
    }

    @Override
    public void createApplicant(Person person) {
        String query = """
                    INSERT INTO applicant
                    (   
                        id_person,
                        entry_date,
                        id_status_applicant
                    )   
                    VALUES (?,?,?);
                """;
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1,person.getId());
            ps.setDate(2, Date.valueOf(LocalDate.now()));
            ps.setInt(3, 1);

            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateApplicant(Applicant applicant) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateApplicant'");
    }

    @Override
    public List<ApplicantOutDTO> getAllApplicant() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ApplicantOutDTO> getAllApplicantAccept() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<ApplicantOutDTO> getApplicantByid() {
        // TODO Auto-generated method stub
        return Optional.empty();
    }


    

}
