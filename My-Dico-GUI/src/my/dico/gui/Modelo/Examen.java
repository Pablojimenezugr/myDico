package my.dico.gui.Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Pablo Jj
 */
public class Examen {

    private Map<Pregunta, Boolean> preguntas;
    private static Random rdn;
    private static int i;

    static {
        i = 0;
        rdn = new Random();
    }

    public Examen(int nPreguntas, Dico dico) {

        if (nPreguntas > dico.size()) {
            nPreguntas = dico.size();
        }
        int ale = rdn.nextInt(dico.size());
        this.preguntas = new HashMap<>();

        this.aniadirPreguntas(nPreguntas, dico);
    }

    private void aniadirPreguntas(int n, Dico dico) {
        for (int i = 0; i < n; i++) {

            Pregunta p = this.generarPregunta(dico);
            preguntas.put(p, null);
        }
        System.out.println("Hemos añadido " + preguntas.size());
    }

    public Pregunta siuientePregunta() {
        Pregunta p = null;
        try {
            p = (Pregunta) preguntas.keySet().toArray()[i];
        } catch(java.lang.ArrayIndexOutOfBoundsException e) {
            p = null;
        }
        i++;
        if (i > preguntas.size()) i = 0;
        
        return p;
    }

    private Pregunta generarPregunta(Dico dico) {
        int ale = rdn.nextInt(dico.size());
        return new Pregunta(
                (String) dico.getEnglish().toArray()[ale],
                new Respuestas(
                        (String) dico.getSpanish().toArray()[rdn.nextInt(dico.size())],
                        (String) dico.getSpanish().toArray()[rdn.nextInt(dico.size())],
                        (String) dico.getSpanish().toArray()[ale]
                ));
    }

    @Override
    public String toString() {
        return "Examen{" + "preguntas=" + preguntas + '}';
    }

}
