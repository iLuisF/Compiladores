%{
  import java.lang.Math;
  import java.io.*;
%}

%token<sval> NODO
%type<sval> Lista input
%token PARENTESIS_ABIERTO
%token PARENTESIS_CERRADO
%left MAS_MENOS                 //Asociatividad(evitar ambiguedad).
%left MULTIPLICACION_DIVISION   //Asociatividad(evitar ambiguedad).
%token NUMBER

/* Gramática con recursión izquierda */
%%
input : Lista {$$ = $1; System.out.println("[OK] "+ $$  );}
      |       { System.out.println("[Ok Lista Vacía] ");}
;

Lista: Lista NODO {$$ = $1 + $2;}
     | NODO {$$ = $1;}
%%
/* Referencia a analizador léxico */
private Nodos lexer;

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

/* Función para reportar error */
public void yyerror (String error) {
    System.err.println ("[ERROR]  " + error);
    System.exit(1);
}

/* Constructor */
public Parser(Reader r) {
    lexer = new Nodos(r, this);
}

/* Creación del parser e inicialización del reconocimiento */
public static void main(String args[]) throws IOException {
    Parser parser = new Parser(new FileReader(args[0]));
    parser.yyparse();
}
