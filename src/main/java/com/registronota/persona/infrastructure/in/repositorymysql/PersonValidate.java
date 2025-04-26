package com.registronota.persona.infrastructure.in.repositorymysql;

import java.lang.reflect.Field;

import com.registronota.persona.domain.entity.dto.PersonEntraceDTO;
import com.registronota.persona.domain.service.PersonServicesValidate;

public class PersonValidate implements PersonServicesValidate {



    @Override
    public boolean validatePassword(String password){
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isDigit = false;

        for(char c : password.toCharArray()){
            if(Character.isUpperCase(c)){
                isUpperCase = true;
            } else if ( Character.isLowerCase(c)){
                isLowerCase =  true;
            }else if (Character.isDigit(c)){
                isDigit = true;
            }
        }
    
        if(isUpperCase && isLowerCase && isDigit) return true;
        
        return false;
    }

    @Override
    public boolean validateEmail(String email) {
        if(email == null) return false;

        int indexAtsing = email.indexOf("@");
        int indexPoint = email.lastIndexOf(".");

        if(indexAtsing>0 && indexAtsing<indexPoint){
            return true;
        }

        return false;
    }

    @Override
    public boolean validateAllFields(PersonEntraceDTO personEntradaDTO) {
        
        try{
            
            if(personEntradaDTO.getId() == 0){
                return false;
            }

            // recorre todo los atributos 
            for(Field field : personEntradaDTO.getClass().getDeclaredFields()){ 
                // da acceso a los atributos privados
                field.setAccessible(true);

                if(field.get(personEntradaDTO) == null ||
                    field.get(personEntradaDTO).equals("")
                    )
                    {
                    
                    return false;
                }
            }   
        }catch (IllegalAccessException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
