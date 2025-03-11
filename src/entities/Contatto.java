package entities;

import java.io.Serial;
import java.io.Serializable;

public class Contatto implements Serializable, Comparable<Contatto> {

    @Serial
    private static final long serialVersionUID = 1L;
    private Persona persona;
    private String numero;

    public Contatto(Persona persona, String numero) {
        this.persona = persona;
        this.numero = numero;
    }

    public Contatto(String numero) {
        this.persona = new Persona("sconosciuto");
        this.numero = numero;
    }

    public Contatto() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return persona + ": " + numero;
    }

    @Override
    public int compareTo(Contatto o) {
        return this.persona.toString().compareTo(o.persona.toString());
        // per come ho definito il toString() di Persona
        // ordino per nome e se sono uguali passa al cognome
    }
}
