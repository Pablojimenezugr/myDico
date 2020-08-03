/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.dico.gui.Modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Dico {
    private Map<String, String> datos;
    private Persistencia p;

    public Dico() {
        p = new Persistencia();
        datos = new TreeMap<>();
        ArrayList<String> l = p.getInicio();

        l.forEach((linea) -> {
            var p = linea.indexOf(':');
            String i = linea.substring(0, p);
            linea = linea.substring(p + 1);
            String f = linea;
            datos.put(i, f);
        });
    }

    public void insertar(String en, String es) {
        datos.put(en, es);
        p.persistir(this);
    }

    public boolean estaIngles(String p) {
        return datos.containsKey(p);
    }

    @Override
    public String toString() {
        String salida = "";
        
        for(Map.Entry<String, String> i : datos.entrySet()) {
            salida += i.getKey() + ":" + i.getValue() + "\n";
        }
        //salida += "datos = " + datos.size() + "\n";
        return salida;
    }
    
    public Set getEnglish() {
        return datos.keySet();
    }

    public Collection getSpanish() {
        return datos.values();
    }
    
    public int size() {
        return datos.size();
    }

    public String significado(String text) {
        return datos.get(text);
    }
}
