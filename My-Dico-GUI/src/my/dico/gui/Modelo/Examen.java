package my.dico.gui.Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Pablo Jj
 */
public class Examen {

    private ArrayList<Pregunta> preguntas;
    private static Random rdn;
    private static int i;

    static {
        i = 0;
        rdn = new Random();
    }

    public Examen(int nPreguntas, Dico dico) {
        
        int ale = rdn.nextInt(dico.size());

        Respuestas r = new Respuestas(
                (String) dico.getSpanish().toString()[rdn.nextInt(dico.size())],
                dico.getSpanish().toString()[rdn.nextInt(dico.size())],
                dico.getSpanish().toString()[ale]
        );
        Pregunta p = new Pregunta(dico.getEnglish().toString()[ale], r);

        preguntas.add(p);
        System.out.println("CARGADO");
        this.aniadirPreguntas(nPreguntas, dico);
    }

    private void aniadirPreguntas(int n, Dico dico) {
        Pregunta p = null;
        for (int i = 0; i < n - 1; i++) {
            do {
                int ale = rdn.nextInt(dico.size());
                p = new Pregunta(
                        dico.getEnglish()[ale],
                        new Respuestas(
                                dico.getSpanish()[rdn.nextInt(dico.size())],
                                dico.getSpanish()[rdn.nextInt(dico.size())],
                                dico.getSpanish()[ale]
                        ));

            } while (!preguntas.contains(p));
        }
    }

    public Pregunta siuientePregunta() {
        Pregunta p = preguntas.get(i);
        i++;
        return p;
    }

}
