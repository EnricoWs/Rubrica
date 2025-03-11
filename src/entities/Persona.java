package entities;

import java.io.Serial;
import java.io.Serializable;

public class Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String nome;
    private String cognome;
    private String indirizzo;

    public Persona(String nome, String cognome, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
    }

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Persona(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {return nome;}

    public String getCognome() {return nome;}

    public String getIndirizzo() {return indirizzo;}

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void visualizza() {
        System.out.println("Nome: " + nome + " " + cognome);
        // System.out.println("Indirizzo: " + indirizzo);
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}