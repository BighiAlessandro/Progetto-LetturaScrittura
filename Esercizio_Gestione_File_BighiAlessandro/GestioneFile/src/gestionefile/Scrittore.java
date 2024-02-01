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

     // Copia il contenuto del file "output.csv" in "copia.csv"
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
     
     //Scrive la riga di testo nel file "user.csv" utilizzando DataOutputStream. 
        public void scriviCsv() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("user.csv"))) {
        } 
        //scrivo all'interno del file csv le informazioni di user.json ma sotto formato di file csv
            dos.writeUTF("id;name;surname;role;");
            dos.writeUTF("1;name;surname;role:");
            System.out.println("Riga di testo scritta su user.csv");
        } catch (IOException ex) {
            System.err.println("Errore in scrittura su user.csv");
        }
    }
    
    @Override
    public void run() {
        scrivi();     // Avvia la scrittura dei dati nel file
        copiaFile();  // Avvia la copia del file
        scriviCsv();   // Aggiunta: scrive la riga di testo nel file CSV
    }
}
