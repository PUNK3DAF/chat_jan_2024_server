/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konfiguracija;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vldmrk
 */
public class Konfiguracija {

    private static Konfiguracija instance;
    private Properties konfiguracija;
    String putanja = "C:\\Users\\vldmrk\\OneDrive - Fakultet organizacionih nauka\\Documents\\NetBeansProjects\\CHATJAN2024_SERVER\\config\\app.config";

    private Konfiguracija() {
        konfiguracija = new Properties();
        File configFile = new File(putanja);
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            konfiguracija.setProperty("max_broj_klijenata", 5 + "");
        } else {
            try {
                FileInputStream fis = new FileInputStream(configFile);
                konfiguracija.load(fis);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Konfiguracija getInstance() {
        if (instance == null) {
            instance = new Konfiguracija();
        }
        return instance;
    }

}
