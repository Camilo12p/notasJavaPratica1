package com.registronota.serverconfig;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.validation.ValidationFeature;

import com.fasterxml.jackson.core.util.JacksonFeature;


public class ConfigServer {

    public static void startServer(){
        
        // config del resourceConfi for api rest
        
        ResourceConfig resourceConfig = new ResourceConfig()
                .packages("com.registronota")  // register all packages
                .register(JacksonFeature.class) // register Jackson
                .register(CorsFilter.class) // register filter for cors
                .register(ValidationFeature.class); // registra las validaciones
        
        
        

        URI uri = URI.create("http://localhost:8080/appeductativa");

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri,resourceConfig);

        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));

        try{
            server.start();
            System.out.println("Server started");
            System.in.read();
            
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            server.shutdownNow();
        }
    }

}
