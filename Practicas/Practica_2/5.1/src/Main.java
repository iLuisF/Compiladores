
import java.util.Scanner;


/**
 * Se contruye un automata que reconozca el lenguaje regular {ab, (ab)*c}
 * y se le pasa una cadena por consola para ser validado.
 * 
 * @author Flores González Luis.
 */
public class Main {

    public static void main(String[] args){
        
        Automata automata = new Automata();
        
        Estado q0 = new Estado(false, true, 0);
        Estado q1 = new Estado(false, false, 1);
        Estado q2 = new Estado(true, false, 2);
        Estado q3 = new Estado(true, false, 3);
        Estado q4 = new Estado(true, false, 4);
                
        automata.agregarEstado(q0);
        automata.agregarEstado(q1);
        automata.agregarEstado(q2);
        automata.agregarEstado(q3);
        automata.agregarEstado(q4);
        
        automata.agregarFuncion(new Tupla(q0, 'c'), q2);
        automata.agregarFuncion(new Tupla(q0, 'a'), q1);
        automata.agregarFuncion(new Tupla(q1, 'b'), q4);
        automata.agregarFuncion(new Tupla(q3, 'a'), q1);
        automata.agregarFuncion(new Tupla(q4, 'a'), q1);
        automata.agregarFuncion(new Tupla(q4, 'c'), q3);

        System.out.println("Ingresa una cadena para ser validada; \n");
        String cadena = getCadenaConsola();
        Token token = new Token(automata, cadena);
        token.tokenizar();
    }
    
    private static String getCadenaConsola(){
        Scanner leer = new Scanner(System.in);
        String cadena = leer.nextLine();
        return cadena;
    }
}
