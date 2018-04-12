package asintactico;
%%
%{
    private Parser parser;

    public Nodos (java.io.Reader r, Parser p){
    	   this(r);
    	   parser = p;
    }
%}
%class Nodos
%standalone
%public
%unicode
%line

ENTERO          =       [1-9][0-9]* | 0+
NUMBER          =       \.[0-9]+ | {ENTERO}\.[0-9]+ | {ENTERO}\.

%%
a             { parser.yylval = new ParserVal(yytext()); return parser.NODO; }
.             { }

"("           {return Parser.PARENTESIS_ABIERTO;}
")"           {return Parser.PARENTESIS_CERRADO;}
"+"|"-"       {parser.yylval = new ParserVal(new Character(yytext().charAt(0)));
               return Parser.MAS_MENOS;}
"*"|"/"       {parser.yylval = new ParserVal(new Character(yytext().charAt(0)));
               return Parser.MULTIPLICACION_DIVISION;}
{NUMBER}      {parser.yylval = new ParserVal(new Double(yytext()));
               return Parser.NUMBER;}
