
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Modela un automata finito determinista.
 * 
 * @author Flores González Luis.
 * @version 1.0
 */
public class Automata {
    
    private HashMap<Tupla, Estado> funcion;
    private Set<Estado> estados;
    
    /**
     * Construye un automata finito determinista.
     */
    Automata(){
        estados = new HashSet<>();
        funcion = new HashMap<>();
    }        
    
    public void agregarEstado(Estado nuevo){
        estados.add(nuevo);        
    }
    
    public Set getConjuntoEstados(){
        return estados;
    }

    public HashMap<Tupla, Estado> getFuncion() {
        return funcion;
    }
    
    public void agregarFuncion(Tupla tupla, Estado estado){
        funcion.put(tupla, estado);
    }

    public void setFuncion(HashMap<Tupla, Estado> funcion) {
        this.funcion = funcion;
    }

    public Set<Estado> getEstados() {
        return estados;
    }

    public void setEstados(Set<Estado> estados) {
        this.estados = estados;
    }
    
    public Estado encontrarEstado(Estado estado){
        if(estados.contains(estado)){
            for(Estado estadoConjunto : estados){
                if(estadoConjunto.equals(estado)){
                    return estadoConjunto;
                }
            }
        }
        return null;
    }
      
}
