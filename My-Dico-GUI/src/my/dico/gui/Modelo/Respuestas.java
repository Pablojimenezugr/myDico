package my.dico.gui.Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Pablo Jj
 */
public class Respuestas {

    private String[] respuestas;
    private String correcta;

    public Respuestas(String resp1, String resp2, String correcta) {
        respuestas = new String[3];
        this.respuestas[0] = resp1;
        this.respuestas[1] = resp2;
        this.respuestas[2] = correcta;
        this.correcta = correcta;
        this.barajarRespuestas();
    }

    public String[] getRespuestas() {
        return respuestas;
    }
    
    public String getCorrecta() {
        return correcta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Arrays.deepHashCode(this.respuestas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Respuestas other = (Respuestas) obj;
        if (!Arrays.deepEquals(this.respuestas, other.respuestas)) {
            return false;
        }
        return true;
    }

    private void barajarRespuestas() {
        ArrayList<String> tmp = new ArrayList<>(Arrays.asList(
                this.respuestas[0],
                this.respuestas[1],
                this.respuestas[2]
        ));
        Collections.shuffle(tmp);
        for(int i=0; i<3; i++)
            this.respuestas[i] = tmp.get(i);
    }

    @Override
    public String toString() {
        return "Respuestas{" + "respuestas=" + respuestas + '}';
    }

    
}
