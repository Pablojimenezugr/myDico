package my.dico.gui.Modelo;

import java.util.Objects;


/**
 *
 * @author Pablo Jj
 */
public class Pregunta {
    private final String pregunta;
    private final Respuestas respuestas;

    public Pregunta(String pregunta, Respuestas respuestas) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }

    public String getPregunta() {
        return pregunta;
    }

    public Respuestas getRespuestas() {
        return respuestas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.pregunta);
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
        final Pregunta other = (Pregunta) obj;
        if (!Objects.equals(this.pregunta, other.pregunta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "pregunta=" + pregunta + ", respuestas=" + respuestas + '}';
    }

    

}
