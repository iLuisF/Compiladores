%{
  import java.lang.Math;
  import java.io.*;
%}

%token IDENTIFICADOR ENTERO REAL BOOLEANO ENDMARKER CADENA P_RESERVADA PI PD MAS
%token ESPACIO MENOS MULT DIV POT CMNT MOD MENQ MAYQ MAYIQ MENIQ IGUAL DIF EXIGUAL
%token AND OR NOT FOR WHILE IF ELSE ELIF PRINT PNTS
/* GramÃ¡tica con recursiÃ³n izquierda */
%%

//file_input: (SALTO | stmt)* ENDMARKER
file_input: SALTO
        | stmt
        | ENDMARKER
        | file_input SALTO ENDMARKER
        | file_input stmt ENDMARKER
;

stmt: simple_stmt | compound_stmt
;
simple_stmt: small_stmt SALTO
;
small_stmt: expr_stmt | print_stmt
;
expr_stmt: test IGUAL test
;
print_stmt: PRINT test
;

compound_stmt: if_stmt
             | while_stmt
;

//if_stmt: 'IF' test ':' suite ['ELSE' ':' suite]
if_stmt: IF test PNTS suite
        | IF test PNTS suite ELSE PNTS suite
;

while_stmt: WHILE test PNTS suite
;
//suite: simple_stmt | SALTO INDENTA stmt+ DEINDENTA
suite: simple_stmt 
    | SALTO INDENTA suit2 DEINDENTA
;

suit2: stmt
    | suit2 stmt
;

test: or_test
;

//or_test: and_test ('or' and_test)*
or_test: and_test
        | and_test or_test2
;

or_test2: OR or_test

;

//and_test: not_test ('and' not_test)*
and_test: not_test
       |  not_test and_test2
;

and_test2: AND and_test

;

not_test: NOT not_test | comparison
;

//comparison: expr (comp_op expr)*
comparison: expr
        |   expr comparison2

;

comparison2: comp_op comparison

;

comp_op: MENQ | MAYQ | EXIGUAL | MAYIQ | MENIQ | DIF
;

//expr: term (('+'|'-') term)*
expr : term
    |  term expr2
;
expr2 : MAS expr
    |   MENOS expr
;

//term: factor ((MULT|DIV|MOD|CMNT) factor)*
term: factor | factor term2
;
term2: MULT term|DIV term|MOD term|CMNT term
;
    
//factor: ('+'|'-') factor | power
factor: MAS factor
    |   MENOS factor
    |   power
;

//power: atom ['**' factor]
power: atom
    |  atom POT factor
;

atom: IDENTIFICADOR | ENTERO | CADENA
    | REAL | BOOLEANO | PI test PD
;

%%
/* Referencia a analizador lÃ©xico */
private Flexer lexer;

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

/* FunciÃ³n para reportar error */
public void yyerror (String error) {
    System.err.println ("[ERROR]  " + error);
    System.exit(1);
}

/* Constructor */
public Parser(Reader r) {
    lexer = new Flexer(r, this);
}

/* CreaciÃ³n del parser e inicializaciÃ³n del reconocimiento */
public static void main(String args[]) throws IOException {
    Parser parser = new Parser(new FileReader("src/main/resources/test.txt"));
    parser.yydebug = true;
    parser.yyparse();
}
