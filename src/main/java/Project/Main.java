package Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       /* ### GESTIONE DI UNO STUDIO COMMERCIALISTICO ###
Chiedere all'utente quale operazione vuole eseguire
- (A)ggiunta di un cliente
- nome, cognome, professione
- (R)imozione di un cliente
- quale cliente vuole rimuovere? Inserisce nome cliente da rimuovere
- (Q)uit*/

        String sceltaUtente = "";
        int id = 1;

        Scanner scanner = new Scanner(System.in);

        //creazione delle liste per salvare i dati inseriti dell'utente
        List<String> nomiLista = new ArrayList<>();
        List<String> cognomiLista = new ArrayList<>();
        List<String> professioniLista = new ArrayList<>();
        List<Integer> idLista = new ArrayList<>();

        while (!sceltaUtente.equals("Q")) {

            // Richiesta di scelta dell'operazione da parte dell'utente
            stampaMenu();
            sceltaUtente = scanner.nextLine().toUpperCase();

            //controllo la scelta dell'utente
            if (sceltaUtente.equals("A")) { //scelta di inserimento dati

                id = aggiungiCliente(nomiLista, cognomiLista, professioniLista, idLista, id);

            } else if (sceltaUtente.equals("R")) { //scelta di rimozione dati

                deleteCliente(nomiLista, cognomiLista, professioniLista, idLista);

            } else if (sceltaUtente.equals("S")) { //scelta di stampa/visualizzazione

                stampaListe(nomiLista, cognomiLista, professioniLista, idLista);

            } else if (sceltaUtente.equals("Q")) { //scelta dell'uscita dal programma
                System.out.println("Uscita dal programma avvenuta con successo.");

            } else { //gestioni di eventuali scelte non consentite
                System.out.println("\033[0;91mERRORE! Operazione NON valida.\033[0m");
            }
        }
    }

    //Method for printing a menu
    public static void stampaMenu() {
        System.out.println("\n** BENVENUTO NEL PROGRAMMA DI GESTIONE DEI CLIENTI **");
        System.out.println("\t* A * per aggiungere un cliente.");
        System.out.println("\t* R * per rimuovere un cliente.");
        System.out.println("\t* S * per visualizzare tutti i dati esistenti.");
        System.out.println("\t* Q * per uscire.");
        System.out.println("Quale operazione tra le precedenti vuoi eseguire?");
    }

    //METHOD FOR ADDING A CUSTOMER INTO THE LISTS
    public static int aggiungiCliente(List<String> nomiLista, List<String> cognomiLista,
                                      List<String> professioniLista, List<Integer> idLista, int id) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il NOME del cliente: ");
        String nome = scanner.nextLine().toUpperCase();
        nomiLista.add(nome);

        System.out.print("Inserisci il COGNOME del cliente: ");
        String cognome = scanner.nextLine().toUpperCase();
        cognomiLista.add(cognome);

        System.out.print("Inserisci la PROFESSIONE del cliente: ");
        String professione = scanner.nextLine().toUpperCase();
        professioniLista.add(professione);

        idLista.add(id);
        id++;

        System.out.println("I dati del cliente sono stati aggiunti con successo!");

        return id;
    }

    // METHOD FOR PRINTING LISTS
    public static void stampaListe(List<String> nomiLista, List<String> cognomiLista,
                                   List<String> professioniLista, List<Integer> idLista) {

        System.out.printf("\033[0;92m%-3s \t%-20s \t%-20s \t%-30s \n\n\033[0m", "ID", "NOME", "COGNOME", "PROFESSIONE");

        for (int i = 0; i < nomiLista.size(); i++) {
            System.out.printf("\033[0;93m%-3d\033[0m \033[0;96m\t%-20s \t%-20s \t%-30s\n\033[0m",
                    idLista.get(i), nomiLista.get(i), cognomiLista.get(i), professioniLista.get(i));
        }
    }

    //METHOD FOR DELETING CUSTOMER
    public static void deleteCliente(List<String> nomiLista, List<String> cognomiLista,
                                     List<String> professioniLista, List<Integer> idLista) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci l'ID del cliente da rimuovere");
        int idDaRimuovere = scanner.nextInt();
        String garbage = scanner.nextLine();  //pulizia dello scanner

        int posizioneRemove = 0;
        boolean clienteTrovato = false;

        for (int i = 0; i < idLista.size(); i++) {
            if (idLista.get(i) == idDaRimuovere) {
                posizioneRemove = i;
                clienteTrovato = true;
            }
        }

        if (clienteTrovato) {
            nomiLista.remove(posizioneRemove);
            cognomiLista.remove(posizioneRemove);
            professioniLista.remove(posizioneRemove);
            idLista.remove(posizioneRemove);
            System.out.println("Rimozione eseguita con successo.");
        }
    }

}