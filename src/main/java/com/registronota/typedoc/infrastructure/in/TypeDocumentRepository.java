package com.registronota.typedoc.infrastructure.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.registronota.typedoc.domai.service.TypeDocumentService;
import com.registronota.typedoc.domain.entity.TypeDocument;

public class TypeDocumentRepository implements TypeDocumentService{
    
    private Connection connection;

    public TypeDocumentRepository(){

        Properties properties = new Properties();
        try{
            properties.load(getClass().getClassLoader().getResourceAsStream("propertiesDB.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            this.connection = DriverManager.getConnection(url,user,password);

        }catch(Exception e){
            e.printStackTrace();
        }
    
    }

    @Override
    public void createTypeDocument(TypeDocument typeDocument) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTypeDocument'");
    }

    @Override
    public List<TypeDocument> getAllTypeDocument() {
        List<TypeDocument> typeDocuments = new ArrayList<>();
        String query =
                """
                SELECT id,name FROM type_document
                """;
        try{        
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            TypeDocument td = new TypeDocument(
                rs.getInt("id"),
                rs.getString("name"));
             
            typeDocuments.add(td);
        }
            
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            return typeDocuments;
        }
    }

    @Override
    public Optional<TypeDocument> getTypeDocumentById(int id) {
        TypeDocument typeDocument = new TypeDocument();
        String query = """
                SELECT id,name FROM type_document 
                as td WHERE td.id = ?; 
                """;
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id );
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                typeDocument.setId(rs.getInt("id"));
                typeDocument.setName(rs.getString("name"));
                
                return Optional.of(typeDocument);
            }   
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }


}
