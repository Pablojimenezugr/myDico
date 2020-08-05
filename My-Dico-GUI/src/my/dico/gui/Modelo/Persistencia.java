package my.dico.gui.Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persistencia {

    private final ArrayList<String> lineas;
    private File f;
    private String ruta = "/home/pablojj/Escritorio/no.txt";

    public Persistencia() {

        lineas = new ArrayList<String>();
        try {
            this.intentarCargarFichero();
        } catch (IOException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader bf = null;
        try {
            ruta = "/home/pablojj/Escritorio/no.txt";
            System.out.println(ruta);
            f = new File(ruta);
            System.out.println(f);
            bf = new BufferedReader(new FileReader(f));
            String cadena;
            while ((cadena = bf.readLine()) != null) {
                lineas.add(cadena);
            }
        } catch (final Exception e) {
            System.err.println("No se ha encontrado el fichero");
            try {
                this.intentarCargarFichero();
            } catch (IOException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } finally {
            try {
                if(bf == null)
                    bf.close();
            } catch (final IOException e) {
                System.err.println("Problema cerrando ficheros");
            }
            
        }
    }

    public void persistir(Dico d) {
        try {
            var bw = new BufferedWriter(new FileWriter(f));
            bw.write(d.toString());
            bw.close();
        } catch (IOException e) {
            System.err.println("Error escribiendo en fichero");
        }
    }

    ArrayList<String> getInicio() {
        return lineas;
    }

    private void intentarCargarFichero() throws FileNotFoundException, IOException, FileNotFoundException, IOException, FileNotFoundException {
        File f = new File("path.dat");
        if(f.exists()) {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            ruta = br.readLine();
            br.close();
            fr.close();
        } 
        
    }
}