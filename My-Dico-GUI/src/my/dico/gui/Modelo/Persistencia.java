package my.dico.gui.Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

    private final ArrayList<String> lineas;
    private File f;
    private String ruta;

    public Persistencia() {

        lineas = new ArrayList<String>();
        ruta = "/home/pablojj/Escritorio/vocabulario.txt";
        BufferedReader bf = null;
        try {
            f = new File(ruta);
            bf = new BufferedReader(new FileReader(f));
            String cadena;
            while ((cadena = bf.readLine()) != null) {
                lineas.add(cadena);
            }
        } catch (final Exception e) {
            System.err.println("No se ha encontrado el fichero");
           // ruta = JOptionPane.showInputDialog("Dime la ruta donde se encuentra tu fichero con el vocabulario", "C:\\desktop\\vocabulario.txt");
        } finally {
            try {
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
}