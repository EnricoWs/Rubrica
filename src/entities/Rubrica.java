package entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class Rubrica implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Vector<Contatto> rubrica = new Vector<Contatto>();


    public Rubrica(Vector<Contatto> rubrica) {
        this.rubrica = rubrica;
    }

    public Rubrica() {
    }

    public int rubricaSize(){
        return rubrica.size();
    }

    public void aggiungiContatto(Contatto h){
        rubrica.add(h);
        Collections.sort(rubrica); // inserisco e ordino
    }

    public void rimuoviContatto(int pos){
        rubrica.remove(pos-1);
    }

    public void cercaContatto(String nome) {
        for(int i = 1; i <= rubrica.size(); i++){
            Contatto contatto = rubrica.get(i-1);
            if (contatto.toString().contains(nome)) {
                System.out.println(i + ") " + contatto);
            }
        }
    }

    public void visualizzaRubrica() {
        if (rubrica.isEmpty()) System.out.println("Rubrica vuota.");
        else {
            for (int i = 1; i <= rubrica.size(); i++) {
                System.out.println(i + ") " + rubrica.get(i - 1));
            }
        }
    }
}
