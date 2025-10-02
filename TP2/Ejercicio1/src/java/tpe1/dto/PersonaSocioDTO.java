package tpe1.dto;

import tpe1.dao.Persona;

public class PersonaSocioDTO {
    private Persona persona;
    private boolean esSocio;

    public PersonaSocioDTO(Persona persona, boolean esSocio) {
        this.persona = persona;
        this.esSocio = esSocio;
    }

    public Persona getPersona() {
        return persona;
    }

    public boolean isEsSocio() {
        return esSocio;
    }
}