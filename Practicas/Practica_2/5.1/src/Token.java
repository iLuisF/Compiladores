
import java.util.Iterator;
import java.util.Stack;

/**
 *  Permite saber si una cadena pertenece a un lenguaje.
 * 
 * @author Flores González Luis.
 */
public class Token {

    private Automata automata;
    private String cadena;
    
    /**
     * 
     * @param automata automata que verificara si la cadena pertenece al lenguajaje.
     * @param cadena cadena para ser verificada.
     */
    public Token(Automata automata, String cadena){
        this.automata = automata;
        this.cadena = cadena;
    }
    
    /**
     * Verifica si una cadena pertenece a un lenguaje mediante un automata.
     * 
     */
    public void tokenizar(){               
        Iterator<Estado> iterator = automata.getConjuntoEstados().iterator();             
        char[] simbolos = cadena.toCharArray();                
        Stack<Tupla> pila = new Stack<>();
        int i = 0;
        Tupla tuplaActual;
        while (true) {
            tuplaActual = new Tupla(new Estado(false, true, 0), simbolos[i]);    
            //z representara el fondo de la pila.
            pila.push(new Tupla(new Estado(true, true, -1), 'z'));
            //Escaner para tokens.        
            while (i < simbolos.length) {
                if(!estaDefinido(tuplaActual)){
                    break;
                }
                if(tuplaActual.getEstado().isFinal()){
                    pila.clear();
                }                
                if(estaDefinido(tuplaActual) || tuplaActual.getEstado().isFinal()){                    
                    pila.push(tuplaActual);
                }                
                //Creo que aqui esta el error.
                i++;
                Estado estadoActual = automata.getFuncion().get(tuplaActual);                
                if(i < simbolos.length){
                    tuplaActual = new Tupla(estadoActual, simbolos[i]);                   
                }                
            }
            
            //backtrack
            while(!tuplaActual.getEstado().isFinal()){
                tuplaActual = pila.pop();               
                if(tuplaActual.getSimbolo() == 'z'){                    
                    System.out.println("Failure: toenization not possible");
                    break;
                }
            }
            //System.out.println(simbolos[i - 1]);            
            if(i >= simbolos.length){               
                System.out.println("Exito.");
                break;
            }
            i--;
            //pila.clear();
            break;
        }        
    }

    /*
    * Si la tupla esta definida en el automata.    
    */
    private boolean estaDefinido(Tupla tupla){
        return automata.getFuncion().containsKey(tupla);
    }
       
}
