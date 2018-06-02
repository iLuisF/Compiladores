//import Parser;
package ast;
import java.io.*;
import ast.patron.compuesto.*;
import ast.patron.visitante.*;


public class Compilador{

    Parser parser;
    Nodo raiz;
    VisitorPrint v_print;
    VisitanteConcreto v_conc;
    VisitanteGenerador generador;

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
    }

    public static void main(String[] args){
            String archivo = "src/main/resources/test.p";
        try{
            Reader a = new FileReader(archivo);
            Compilador c  = new Compilador(a);
            c.ConstruyeAST(true);
            c.imprimeAST();            
        }catch(FileNotFoundException e){
            System.err.println("El archivo " + archivo +" no fue encontrado. ");
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Uso: java Compilador [archivo.p]: ");
        }
    }
}
