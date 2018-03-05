
import java.util.Comparator;


/**
 * Modela un estado.
 * 
 * @author Flores González Luis.
 */
public class Estado implements Comparator<Estado>{
   
    private boolean estadoFinal;
    private boolean inicial;
    private int identificador;

    public Estado(boolean esFinal, boolean esInicial, int identificador) {
        this.estadoFinal = esFinal;
        this.inicial = esInicial;
        this.identificador = identificador;
    }

    public boolean isFinal() {
        return estadoFinal;
    }

    public void setFinal(boolean esFinal) {
        this.estadoFinal = esFinal;
    }

    public boolean isInicial() {
        return inicial;
    }

    public void setInicial(boolean esInicial) {
        this.inicial = esInicial;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public int compare(Estado e1, Estado e2) {
        int resultado = 0;
        if(e1.identificador < e2.identificador){
            resultado = 1;
        }
        if(e1.identificador > e2.identificador){
            resultado = -1;
        }        
        if(e1.identificador == e2.identificador){
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
        final Estado other = (Estado) obj;
        if (this.estadoFinal != other.estadoFinal) {
            return false;
        }
        if (this.inicial != other.inicial) {
            return false;
        }
        if (this.identificador != other.identificador) {
            return false;
        }
        return true;
    }
    
    
          
}
