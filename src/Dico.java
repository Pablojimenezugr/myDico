import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dico {
    private Map<String, String> datos;
    private Persistencia p;

    public Dico() {
        p = new Persistencia();
        datos = new HashMap<>();
        ArrayList<String> l = p.getInicio();

        l.forEach((linea) -> {
            var p = linea.indexOf(':');
            String i = linea.substring(0, p);
            linea = linea.substring(p + 1);
            String f = linea;
            datos.put(i, f);
        });
    }

    @Override
    public String toString() {
        String salida = "";

        for(Map.Entry<String, String> i : datos.entrySet()) {
            salida += i.getKey() + " : " + i.getValue() + "\n";
        }

        return salida;
    }
}