package com.registronota.scoreadmissiontest.infrastructure.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.registronota.scoreadmissiontest.domain.entity.ScoreAdmissionTest;
import com.registronota.scoreadmissiontest.domain.entity.DTOs.ScoreAdmissionEntranceDTO;
import com.registronota.scoreadmissiontest.domain.service.ScoreAdmissionServiceRespo;


public class ScoreAdmissionRepository implements ScoreAdmissionServiceRespo{

    private Connection connection;

    public ScoreAdmissionRepository(){
        Properties properties = new Properties();

        try{
            properties.load(getClass().getClassLoader().getResourceAsStream("propertiesDB.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            this.connection = DriverManager.getConnection(url,user,password);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void createScore(ScoreAdmissionEntranceDTO score) {
        String query ="""
                INSERT INTO score_admission_test
                (score, id_applicant,date_register)
                VALUES (?,?,?);
                """;

        try{
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setFloat(1, score.getScore());
            pStatement.setInt(2, score.getIdApplicant());
            pStatement.setObject(3, LocalDateTime.now());

            pStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<ScoreAdmissionTest> getAllScoreAdmission(long idPerson) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllScoreAdmission'");
    }

    @Override
    public Optional<ScoreAdmissionTest> getScoreMoreRecently(long idPerson) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getScoreMoreRecently'");
    }
}
