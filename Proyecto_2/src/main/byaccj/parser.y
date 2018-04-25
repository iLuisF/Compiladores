%{
  import java.lang.Math;
  import java.io.*;
%}

%token IDENTIFICADOR ENTERO REAL BOOLEANO ENDMARKER CADENA P_RESERVADA PI PD MAS
%token ESPACIO MENOS MULT DIV POT CMNT MOD MENQ MAYQ MAYIQ MENIQ IGUAL DIF EXIGUAL
%token AND OR NOT FOR WHILE IF ELSE ELIF PRINT PNTS
/* Gramática con recursión izquierda */
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
       | and_test OR and_test
       | or_test OR and_test OR and_test
;

//and_test: not_test ('and' not_test)*
and_test: not_test
       |  not_test AND not_test
       |  and_test AND not_test AND not_test
;

not_test: NOT not_test | comparison
;

//comparison: expr (comp_op expr)*
comparison: expr
       |    expr comp_op expr
       |    comparison comp_op expr comp_op expr
;

comp_op: MENQ | MAYQ | EXIGUAL | MAYIQ | MENIQ | DIF
;

//expr: term (('+'|'-') term)*
expr: term
    | term MAS term
    | term MENOS term
    | expr MAS term MAS term
    | expr MENOS term MENOS term
    | expr MENOS term MAS term
    | expr MAS term MENOS term
;

//term: factor ((MULT|DIV|MOD|CMNT) factor)*
term: factor
    | factor MULT factor
    | factor DIV factor
    | factor MOD factor
    | factor CMNT factor
    | term MULT factor MULT factor
    | term MULT factor DIV factor
    | term MULT factor MOD factor
    | term MULT factor CMNT factor
    | term DIV factor MULT factor
    | term DIV factor DIV factor
    | term DIV factor MOD factor
    | term DIV factor CMNT factor
    | term MOD factor MULT factor
    | term MOD factor DIV factor
    | term MOD factor MOD factor
    | term MOD factor CMNT factor
    | term CMNT factor MULT factor
    | term CMNT factor DIV factor
    | term CMNT factor MOD factor
    | term CMNT factor CMNT factor
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
/* Referencia a analizador léxico */
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

/* Función para reportar error */
public void yyerror (String error) {
    System.err.println ("[ERROR]  " + error);
    System.exit(1);
}

/* Constructor */
public Parser(Reader r) {
    lexer = new Flexer(r, this);
}

/* Creación del parser e inicialización del reconocimiento */
public static void main(String args[]) throws IOException {
    Parser parser = new Parser(new FileReader("src/main/resources/test.txt"));
    parser.yydebug = true;
    parser.yyparse();
}
