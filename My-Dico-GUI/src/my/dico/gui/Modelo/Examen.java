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
    private static Dico dico;

    static {
        i = 0;
        rdn = new Random();
    }

    public Examen(Dico dico) {
        int ale = rdn.nextInt(dico.size());
        this.preguntas = new HashMap<>();
        this.dico = dico;
    }
    

    private void aniadirPreguntas(int n, Dico dico) {
        for (int i = 0; i < n; i++) {

            Pregunta p = this.generarPregunta(dico);
            preguntas.put(p, false);
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
                        (String) dico.getSpanish().toArray()[ale + rdn.nextInt(dico.size() - ale)],
                        (String) dico.getSpanish().toArray()[ale + 3],
                        (String) dico.getSpanish().toArray()[ale]
                ));
    }

    @Override
    public String toString() {
        return "Examen{" + "preguntas=" + preguntas + '}';
    }

    /**
     * Se califica la pregunta como correcta (en principio asumimos que todas
     * son erroneas).
     * @param actual Pregunta actual
     */
    public void calificarPregunta(Pregunta actual) {
        System.out.println("califuicando " +  actual);
        preguntas.put(actual, true);
        System.err.println(preguntas);
    }

    public int getCorrectas() {
        int c = 0;
        c = preguntas.values().stream().filter(i -> (i)).map(_item -> 1).reduce(c, Integer::sum);
        //System.err.println(preguntas);
        System.out.println("correctas = " + c);
        return c;
    }

    public List getErroneas() {
        ArrayList<String> salida = new ArrayList<>();
        preguntas.entrySet().stream().filter(i -> (!i.getValue())).forEachOrdered(i -> {
            salida.add(i.getKey().getPregunta());
        });
        return salida;
    }

    public Map<Pregunta, Boolean> getPreguntas() {
        return preguntas;
    }
    
    

    public int getPregunta() {
        return i;
    }

    public void setNPreguntas(int nPreguntas) {
        if (nPreguntas > dico.size()) {
            nPreguntas = dico.size();
        }
        this.aniadirPreguntas(nPreguntas, dico);
    }

}
