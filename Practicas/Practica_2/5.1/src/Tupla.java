
import java.util.Comparator;
import java.util.Objects;

/**
 * Construye una tupla (Estado, simbolo).
 */
public class Tupla implements Comparator<Tupla> {

    private Estado estado;
    private char simbolo;

    public Tupla(Estado estado, char simbolo) {
        this.estado = estado;
        this.simbolo = simbolo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public int compare(Tupla t1, Tupla t2) {
        int resultado = 0;
        if (t1.estado.getIdentificador() < t2.estado.getIdentificador()) {
            resultado = 1;
        }
        if (t1.estado.getIdentificador() < t2.estado.getIdentificador()) {
            resultado = -1;
        }
        if (t1.estado.getIdentificador() == t2.estado.getIdentificador()
                && t1.simbolo == t2.simbolo) {
            resultado = 0;
        }
        return resultado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Tupla other = (Tupla) obj;
        if (this.simbolo != other.simbolo) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }


}
