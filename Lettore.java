package gestionefile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lettore extends Thread {
    String nomeFile;

    public Lettore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    /**
     * Legge il file e lo mostra in output
     */
    public void leggi() {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {
            int i;
            // legge e stampa
            while ((i = br.read()) != -1)
                System.out.print((char) i);

            System.out.print("\n\r");
        } catch (IOException ex) {
            System.err.println("Errore in lettura");
        }
    }
    
    /**
     * SPIEGAZIONE TRAMITE ESEMPIO DELL IMPLEMENTAZIONE DELLE ISTRUZIONI DI TIPO "try-with-resources":
     * Nel metodo leggi(), ho utilizzato try-with-resources per gestire automaticamente la chiusura della risorsa BufferedReader.
     * La dichiarazione try inizia con la creazione di un nuovo oggetto BufferedReader che avvolge un oggetto FileReader.
     * Al termine del blocco try, la risorsa viene automaticamente chiusa senza utilizzare "close()".
     */
    

    public void run() {
        leggi();
    }
}

