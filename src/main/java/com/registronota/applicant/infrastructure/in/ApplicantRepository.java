package com.registronota.applicant.infrastructure.in;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.registronota.applicant.domain.entity.dto.ApplicantOutDTO;
import com.registronota.applicant.domain.service.ApplicantServiceRepository;
import com.registronota.persona.domain.entity.Person;
import com.registronota.persona.domain.entity.dto.PersonOutDTO;
import com.registronota.statusapplicant.domain.entity.StatusApplicant;
import com.registronota.typedoc.domain.entity.TypeDocument;


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
    public void updateStatusApplicant(int idStatus, int idApplicant) {

        String query = """
                UPDATE applicant 
                SET id_status_applicant = ?
                WHERE id = ?;
                """;
        try{
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, idStatus);
            pStatement.setInt(2, idApplicant);
            pStatement.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }
        
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
    public Optional<ApplicantOutDTO> getApplicantByid(int idApplicant) {
        
        String query = """
                SELECT 
                    ap.id,
                    ap.id_status_applicant,
                    s.id,
                    s.name,
                    ap.id_person,
                    p.id,
                    p.id_type_doc,
                    tp.id,
                    tp.name,
                    p.name,
                    p.last_name,
                    p.birthday,
                    p.email,
                    p.phone_number,
                    ap.entry_date

                    FROM applicant ap
                    INNER JOIN status_applicant s ON ap.id_status_applicant = s.id
                    INNER JOIN person p ON ap.id_person = p.id
                    INNER JOIN type_document tp ON p.id_type_doc = tp.id
                    WHERE ap.id = ?;
                """;

        try{
            PreparedStatement pStatement = connection.prepareStatement(query);
            pStatement.setInt(1,idApplicant);

            ResultSet rSet = pStatement.executeQuery();

            while (rSet.next()) {

                
                PersonOutDTO personOutDTO = new PersonOutDTO();
                TypeDocument typeDocument = new TypeDocument();

                StatusApplicant statusApplicant = new StatusApplicant();

                ApplicantOutDTO applicantOutDTO = new ApplicantOutDTO();

                typeDocument.setId(rSet.getInt("tp.id"));
                typeDocument.setName(rSet.getString("tp.name"));


                // personOutDto

                
                personOutDTO.setId(rSet.getLong("p.id"));

                personOutDTO.setName(rSet.getString("p.name"));

                personOutDTO.setLastName(rSet.getString("p.last_name"));
            
                personOutDTO.setBirthDate(rSet.getDate("p.birthday")
                                            .toLocalDate());
                personOutDTO.setEmail(rSet.getString("p.email"));
                personOutDTO.setPhoneNumber(rSet.getLong("p.phone_number"));
                personOutDTO.setTypeDocument(typeDocument);

                


                // status

                statusApplicant.setId(rSet.getInt("s.id"));
                statusApplicant.setName(rSet.getString("s.name"));


                // applicant 

                applicantOutDTO.setId(rSet.getInt("ap.id"));
                applicantOutDTO.setStatusApplicant(statusApplicant);
                applicantOutDTO.setPerson(personOutDTO);
                applicantOutDTO.setDateEntry(rSet.getDate("ap.entry_date")
                                                .toLocalDate());

                      
                return Optional.of(applicantOutDTO);
            }

        }catch(SQLException e){
            e.printStackTrace();

        }
    
    
        return Optional.empty();
        


    }


    

}
