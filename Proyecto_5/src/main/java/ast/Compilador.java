//import Parser;
package ast;
import ast.patron.compuesto.*;
import ast.patron.visitante.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Compilador{

    Parser parser;
    Nodo raiz;
    VisitorPrint v_print;
    VisitanteConcreto v_conc;
    VisitanteGenerador generador;
    
    static String nombreArchivo;

    Compilador(Reader fuente){
        parser = new Parser(fuente);
        v_print = new VisitorPrint();
        v_conc = new VisitanteConcreto();
        generador = new VisitanteGenerador();
    }

    public void ConstruyeAST(boolean debug){
        parser.yydebug = debug;
        parser.yyparse(); // análisis léxico, sintáctio y constucción del AST
        raiz = parser.raiz;
    }

    public void imprimeAST(){
        // TODO
        parser.raiz.accept(v_conc);
        parser.raiz.accept(generador);  
        String instr = generador.getInstrucciones();
        
        System.out.println("---------INSTRUCCIONES---------\n\n" + instr);
        FileWriter fw;
        try {
            fw = new FileWriter(nombreArchivo.substring(0, nombreArchivo.length()-2) + ".asm");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(instr);
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args){
        nombreArchivo = args[0];
        try{
            Reader a = new FileReader(nombreArchivo);
            Compilador c  = new Compilador(a);
            c.ConstruyeAST(true);
            c.imprimeAST();            
        }catch(FileNotFoundException e){
            System.err.println("El archivo " + nombreArchivo +" no fue encontrado. ");
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Uso: java Compilador [archivo.p]: ");
        }
    }
}
