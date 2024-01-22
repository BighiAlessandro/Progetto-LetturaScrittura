package gestionefile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Scrittore implements Runnable {
    private String nomeFile;
    private String username;
    private String password;

    public Scrittore(String nomeFile, String username, String password) {
        this.nomeFile = nomeFile;
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        scrivi();
        copiaFile();
    }

    /**
     * Scrive i dati sul file "output.csv"
     */
    public void scrivi() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeFile, true))) {
            pw.println(username + ";" + password);
            System.out.println("Dati scritti su " + nomeFile);
        } catch (IOException ex) {
            System.err.println("Errore in scrittura");
        }
    }

    /**
     * Copia il contenuto del file "output.csv" in "copia.csv"
     */
    public void copiaFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile));
             PrintWriter pw = new PrintWriter(new FileWriter("copia.csv"))) {
            String line;
            // Leggi ogni riga dal file e la scrive nel file copia
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }
            System.out.println("File copiato in copia.csv");
        } catch (IOException ex) {
            System.err.println("Errore durante la copia del file");
        }
    }
}
