package com.example.formulaire.Utils;

public class Apis {

    public static final String URL_001="http://127.0.0.1:8000/api/formulaires";

    public static PersonaService getPersonaService(){
        return  Cliente.getClient(URL_001).create(PersonaService.class);
    }
}
