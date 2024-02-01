package gestionefile;

import java.util.Scanner;

/**
 * Classe principale del progetto
 * @author Alessandro Bighi
 * @version 22/01/24
 */
public class GestioneFile {

    public static void main(String[] args) {
        
        // 1) LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        
        // 2) ELABORAZIONE
        // Chiedi all'utente di inserire username e password
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci username: ");
        String username = scanner.nextLine();
        System.out.print("Inserisci password: ");
        String password = scanner.nextLine();
        
        // 3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", username, password);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
        try {
            threadScrittore.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * SPIEGAZIONE INSERIMENTO DEL METODO JOIN():
         * Essendo che sono solamente al punto #ISSUE2 e non sapendo quali richieste avranno i prossimi punti dell'ISSUE ho inserito
         * il metodo join() nel mio codice per aspettare che il thread threadScrittore completi la sua esecuzione prima di procedere oltre.
         * Perciò potrei dire che l'ho inserito per cercare di dare priorià a quel thread perchè deve essere il primo ad essere eseguito.
         */
    }
}

