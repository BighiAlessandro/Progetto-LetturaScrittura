package gestionefile;

import java.util.Scanner;

/**
 * Classe principale del progetto
 * @author AB
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
    }
}

