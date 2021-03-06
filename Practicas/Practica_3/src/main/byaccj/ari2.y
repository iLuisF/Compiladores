%{
//IMPORTS
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
%}

/*
GRAMATICA 2
*/

%token <sval> MAS MENOS MULT DIV
%token <dval> NUM
%type <dval> E E2MA E2ME T T2MU T2DI F EAUX
%type <dval> eval
%type <sval> A

%%

eval : E {$$ = $1; System.out.println("[OK] Resultado: "+ $$ );}
    |       { System.out.println("[OK] ENTRADA VAC�?A ");}
;

E   :   T        {$$ = $1; dump_stacks(stateptr);}    
    |   T E2MA   { $$ = $1 + $2; dump_stacks(stateptr);}
    |   T E2ME   { $$ = $1 - $2; dump_stacks(stateptr);}
;

E2MA  :   MAS E         { $$ = $2; dump_stacks(stateptr);}       
;

E2ME  :   MENOS EAUX       { $$ = $2; dump_stacks(stateptr);}
;

EAUX   :   T        {$$ = -1 * $1; dump_stacks(stateptr);}    
    |   T E2MA   { $$ = $1 - $2; dump_stacks(stateptr);}
    |   T E2ME   { $$ = $1 + $2; dump_stacks(stateptr);}

T   :   F               {$$ = $1; dump_stacks(stateptr);}    
    |   F T2MU          {$$ = $1 * $2; dump_stacks(stateptr);}
    |   F T2DI          {$$ = $1 / $2; dump_stacks(stateptr);}
;

T2MU  :   MULT T           {$$ = $2; dump_stacks(stateptr);}    
;
T2DI  :   DIV T           { $$ = $2; dump_stacks(stateptr);}
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

    System.out.println("Gramatica 2: ");

    Parser parser = new Parser(new FileReader(args[0]));
    parser.yyparse();
}
