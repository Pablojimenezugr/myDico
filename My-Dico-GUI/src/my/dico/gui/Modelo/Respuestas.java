package my.dico.gui.Modelo;

import java.util.Arrays;

/**
 *
 * @author Pablo Jj
 */
public class Respuestas {

    private String[] respuestas;

    public Respuestas(String resp1, String resp2, String resp3) {
        respuestas = new String[3];
        this.respuestas[0] = resp1;
        this.respuestas[1] = resp2;
        this.respuestas[2] = resp3;
    }

    public String[] getRespuestas() {
        return respuestas;
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
    
    
    
}
