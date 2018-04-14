%{
//IMPORTS
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
%}

/*
GRAMATICA 1
*/

%token <sval> MAS MENOS MULT DIV
%token <dval> NUM
%type <dval> E E2MA E2ME T T2MU T2DI F
%type <dval> eval
%type <sval> A

%%

eval : E {$$ = $1; System.out.println("[OK] Resultado: "+ $$ );}
    |       { System.out.println("[OK] ENTRADA VACÃ?A ");}
;

E   :   T        {$$ = $1; dump_stacks(stateptr);}    
    |   E2MA T   { $$ = $1 + $2; dump_stacks(stateptr);}
    |   E2ME T   { $$ = $1 - $2; dump_stacks(stateptr);}
;

E2MA  :   E MAS         { $$ = $1; dump_stacks(stateptr);}
;

E2ME  :   E MENOS        { $$ = $1; dump_stacks(stateptr); }    
;

T   :   F               {$$ = $1; dump_stacks(stateptr);}    
    |   T2MU F          {$$ = $1 * $2; dump_stacks(stateptr);}
    |   T2DI F          {$$ = $1 / $2; dump_stacks(stateptr);}
;

T2MU  :   T MULT          {$$ = $1; dump_stacks(stateptr);}    
;
T2DI  :   T DIV           { $$ = $1; dump_stacks(stateptr);}
;

F   : NUM            {$$ = $1; dump_stacks(stateptr);}
    | MENOS NUM      {$$ = -1 * $2; dump_stacks(stateptr);}    
;

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

    System.out.println("Gramatica 1: ");

    Parser parser = new Parser(new FileReader(args[0]));
    parser.yyparse();    
}
