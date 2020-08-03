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
import javax.swing.JOptionPane;

public class Persistencia {

    private final ArrayList<String> lineas;
    private File f;
    private String ruta;

    /**
     * Se encarga de cargar la ubicación del fichero inicial. Llama a
     * {intentarCargarFichero}
     *
     * @throws IOException
     */
    public Persistencia() {
        lineas = new ArrayList<String>();
        try {
            f = new File("path.dat");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            ruta = br.readLine();

            br.close();
            fr.close();

            this.intentarCargarFichero();
        } catch (IOException e) {
            System.err.println("No se h apodido cargar el fichero");
        }
    }

    /**
     * Persiste el diccionario cuando se hacen modificacion en RAM
     */
    public void persistir(Dico d) {
        try {
            var bw = new BufferedWriter(new FileWriter(f));
            bw.write(d.toString());
            bw.close();
        } catch (IOException e) {
            System.err.println("Error escribiendo en fichero");
        }
    }

    /**
     * Devuelve las lineas del fichero de persistencia
     *
     * @return String[] vocabulario
     */
    ArrayList<String> getInicio() {
        return lineas;
    }

    /**
     * Intenta rellenar el array de palabras de vocabulario.
     */
    private void intentarCargarFichero() {
        System.out.println("la ruta = " + ruta);
        FileReader fr;
        try {
            fr = new FileReader(new File(this.ruta));
            BufferedReader br = new BufferedReader(fr);
            ruta = br.readLine();
            String cadena;
            while ((cadena = br.readLine()) != null) {
                lineas.add(cadena);
            }
        } catch (Exception ex) {
            System.err.println("No he podido leer el dico");
            this.errorCargandoFichero();
        }

    }

    /**
     * En caso de que no se pueda cargar el archivo con la ruta correcta donde
     * se encuentra el archivo de persistencia; Se lanza una ventana para que el
     * usuario introduzca donde localizar este fichero y se vcuelve a
     * <intentarCargarFichero()>
     */
    private void errorCargandoFichero() {
        ruta = JOptionPane.showInputDialog("Dinos donde se encuentra tu fichero de datos", "C:\\Documents\\fich.txt");

        f = new File("path.dat");
        FileWriter fw = null;
        BufferedWriter br = null;
        try {

            fw = new FileWriter(f);
            br = new BufferedWriter(fw);

            br.write(ruta);

        } catch (IOException ex) {
            System.err.println("Problema escribiendo caragdore de ficheros");
        } finally {
            try {
                br.close();
                fw.close();
            } catch (IOException ex) {
                System.err.println("Problema cerrando caragdore de ficheros");
            }
        }
        this.intentarCargarFichero();
    }
}
