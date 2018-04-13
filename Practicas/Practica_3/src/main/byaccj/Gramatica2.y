%{
\\IMPORTS

%}

/*
token: terminales
type noterminales
*/

%token NUMBER
%token PARENTESIS_ABIERTO
%token PARENTESIS_CERRADO
%token MAS_MENOS
%token MULTIPLICACION_DIVISION
%type E
%type T
%type F


%%

public Parser(Reader r) {
    lexer = new Flexer(r, this);
}

/* Creacion del parser e inicializacion del reconocimiento */
public static void main(String args[]) throws IOException {
    Parser parser = new Parser(new FileReader(args[0]));
    parser.yyparse();
}
