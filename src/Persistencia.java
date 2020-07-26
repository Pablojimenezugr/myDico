import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

    private final ArrayList<String> lineas;

    public Persistencia() {

        lineas = new ArrayList<String>();

        FileReader in = null;
        BufferedReader bf = null;
        try {
            in = new FileReader(new File("/home/pablojj/proyectos/MyDico/MyDico/src/vocabulario.txt"));
            bf = new BufferedReader(in);
            String cadena;
            while ((cadena = bf.readLine()) != null) {
                lineas.add(cadena);
            }
        } catch (final Exception e) {
            System.err.println("No se ha encontrado el fichero");
        } finally {
            try {
                in.close();
                bf.close();
            } catch (final IOException e) {
                System.err.println("Problema cerrando ficheros");
            }
            
        }
    }

    ArrayList<String> getInicio() {
        return lineas;
    }
}