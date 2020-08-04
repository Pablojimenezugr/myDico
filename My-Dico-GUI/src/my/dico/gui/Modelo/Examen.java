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

        if(nPreguntas > dico.size()) nPreguntas = dico.size();
        int ale = rdn.nextInt(dico.size());
        this.preguntas = new ArrayList<>();

        this.aniadirPreguntas(nPreguntas, dico);
    }

    private void aniadirPreguntas(int n, Dico dico) {
        for (int i = 0; i < n; i++) {

            Pregunta p = this.generarPregunta(dico);
            while (preguntas.contains(p)) {
                p = this.generarPregunta(dico);
            }
            preguntas.add(p);

        }
        System.out.println("Hemos añadido " + preguntas.size());
    }

    public Pregunta siuientePregunta() {
        Pregunta p = preguntas.get(i);
        i++;
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
}
