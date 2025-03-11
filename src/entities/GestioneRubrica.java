package entities;

import java.io.*;
import java.util.Scanner;

public class GestioneRubrica {

    private Rubrica rubrica = new Rubrica();
    private Scanner scan = new Scanner(System.in);


    public void menu() {
        int scelta;
        String input;

        try {
            ObjectInputStream in =
                    new ObjectInputStream(new BufferedInputStream(
                            new FileInputStream("src/data/rubrica.dat")));

            rubrica = (Rubrica) in.readObject();
            in.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Rubrica vuota.");
            System.out.println(e.getMessage());

        } catch(IOException e) {
            System.out.print("Errore di I/O: ");
            System.out.println(e.getMessage());
        }

        do {
            System.out.println("----------------------------------");
            System.out.println("1) Visualizza rubrica");
            System.out.println("2) Inserisci nuovo contatto");
            System.out.println("3) Rimuovi contatto");
            System.out.println("4) Cerca contatto");
            System.out.println("0) Termina programma\n");

            System.out.print("Scelta: ");
            scelta = scanInt(0, 4);

            System.out.println("----------------------------------");
            switch (scelta) {
                case 1: rubrica.visualizzaRubrica(); break;
                case 2:
                    System.out.print("Inserisci il nome del contatto: ");
                    input = scan.nextLine();
                    Contatto new_contatto = new Contatto(new Persona(input), "");

                    System.out.print("Inserisci il cognome del contatto: ");
                    input = scan.nextLine();
                    new_contatto.getPersona().setCognome(input);

                    System.out.print("Inserisci il numero di telefono: ");
                    input = scan.nextLine();
                    new_contatto.setNumero(input);
                    rubrica.aggiungiContatto(new_contatto);
                    break;
                case 3:
                    if (rubrica.rubricaSize() == 0){
                        System.out.println("Errore: rubrica vuota.");
                    } else {
                        rubrica.visualizzaRubrica();
                        System.out.print("Quale contatto vuoi eliminare [1/" + (rubrica.rubricaSize()) + "]? ");
                        scelta = scanInt(1, rubrica.rubricaSize());
                        rubrica.rimuoviContatto(scelta);
                    } break;
                case 4:
                    System.out.print("Inserisci il nome o il numero di telefono: ");
                    input = scan.nextLine();
                    System.out.println();
                    rubrica.cercaContatto(input);
                    break;

                case 0:
                    System.out.println("Programma terminato.");
                    break;
            }
        } while (scelta != 0);

        try{
            ObjectOutputStream out = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream("src/data/rubrica.dat")));
            out.writeObject(rubrica);
            out.close();
            System.out.println("Modifiche salvate correttamente.");
            System.out.println("----------------------------------");
        } catch (IOException e){
            System.out.print("Errore di I/O: ");
            System.out.println(e.getMessage());
        }
    }

    private int scanInt(int min, int max){
        int scelta;
        do {
            try {
                scelta = Integer.parseInt(scan.nextLine());
                if (scelta < min || scelta > max) throw new RuntimeException();
                break;
            } catch (RuntimeException error) {
                System.out.println("\nErrore: Sono ammessi solo valori interi tra " + min +" e " + max + "!\n");
                System.out.print("Riprova: ");
            }
        } while (true);
        return scelta;
    }
}
