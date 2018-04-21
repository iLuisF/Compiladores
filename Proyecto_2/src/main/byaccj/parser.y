%{
  import java.lang.Math;
  import java.io.*;
%}

%token IDENTIFICADOR ENTERO REAL BOOLEANO

/* Gramática con recursión izquierda */
%%
atom: IDENTIFICADOR
    | ENTERO
    | REAL
    | BOOLEANO
;

//file_input: (SALTO | stmt)* ENDMARKER
file_input: SALTO
        | stmt
        | file_input SALTO
        | file_input stmt

stmt: simple_stmt | compound_stmt
simple_stmt: small_stmt SALTO
small_stmt: expr_stmt | print_stmt
expr_stmt: test '=' test
print_stmt: 'print' test

compound_stmt: if_stmt
             | while_stmt

//if_stmt: 'if' test ':' suite ['else' ':' suite]
if_stmt: 'if' test ':' suite
        | 'if' test ':' suite 'else' ':' suite

while_stmt: 'while' test ':' suite
suite: simple_stmt | SALTO INDENTA stmt+ DEINDENTA

test: or_test

//or_test: and_test ('or' and_test)*
or_test: and_test
       | and_test 'or' and_test
       | or_test 'or' and_test 'or' and_test

//and_test: not_test ('and' not_test)*
and_test: not_test
       |  not_test 'and' not_test
       |  and_test 'and' not_test 'and' not_test

not_test: 'not' not_test | comparison

//comparison: expr (comp_op expr)*
comparison: expr
       |    expr comp_op expr
       |    comparison comp_op expr comp_op expr

comp_op: '<'|'>'|'=='|'>='|'<='|'!='

//expr: term (('+'|'-') term)*
expr: term
    | term '+' term
    | term '-' term
    | expr '+' term '+' term
    | expr '-' term '-' term
    | expr '-' term '+' term
    | expr '+' term '-' term

//term: factor (('*'|'/'|'%'|'//') factor)*
term: factor
    | factor '*' factor
    | factor '/' factor
    | factor '%' factor
    | factor '//' factor
    | term '*' factor '*' factor
    | term '*' factor '/' factor
    | term '*' factor '%' factor
    | term '*' factor '//' factor
    | term '/' factor '*' factor
    | term '/' factor '/' factor
    | term '/' factor '%' factor
    | term '/' factor '//' factor
    | term '%' factor '*' factor
    | term '%' factor '/' factor
    | term '%' factor '%' factor
    | term '%' factor '//' factor
    | term '//' factor '*' factor
    | term '//' factor '/' factor
    | term '//' factor '%' factor
    | term '//' factor '//' factor
    
//factor: ('+'|'-') factor | power
factor: '+' factor
    |   '-' factor
    |   power

//power: atom ['**' factor]
power: atom
    |  atom '**' factor

atom: IDENTIFICADOR | ENTERO | CADENA
    | REAL | BOOLEANO | '(' test ')'

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
