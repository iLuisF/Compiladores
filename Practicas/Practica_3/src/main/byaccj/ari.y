%{
//IMPORTS
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
%}

/*
GRAMATICA 1
*/

%token NUMBER
%token NODO
%token MAS MENOS
%token MULT DIV
%type <dval> E EMA EME T F
%type <dval> eval

%%

eval : E {$$ = $1; System.out.println("[OK] "+ $$  );}
    |       { System.out.println("[Ok Lista Vacia] ");}
;

E   :   T       
    |   E MAS T     
    |   E MAS E2 T
    |   E MENOS T
    |   E MENOS E2 T
;

E2  :   E MAS E2
    |   E MAS    
;


T   :   F
    |   T MULT F
    |   T MULT T2 F

T2  :   T MULT T2
    |   T MULT

F   : NUMBER


%%

/* Referencia a analizador lexico */
private Nodos lexer;

/* */

private int yylex () {
    int yyl_return = -1;
    try {
      yyl_return = lexer.yylex();
    }
    catch (IOException e) {
      System.err.println("IO error :"+e);
    }
    return yyl_return;
}

/* Funcion para reportar error */
public void yyerror (String error) {
    System.err.println ("[ERROR] " + error);
    System.exit(1);
}

/* Constructor */
public Parser(Reader r) {
    lexer = new Nodos(r, this);
}

/* Creacion del parser e inicializacion del reconocimiento */
public static void main(String args[]) throws IOException {
    Parser parser = new Parser(new FileReader(args[0]));
    parser.yyparse();
}
