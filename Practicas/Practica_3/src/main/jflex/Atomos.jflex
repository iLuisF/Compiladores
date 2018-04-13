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



NUMBER      = [0-9][0-9]*

%%

a           { parser.yylval = new ParserVal(yytext()); return parser.NODO; }

"+"         {parser.yyval = new ParserVal(yytext()); return Parser.MAS;}

"-"         {parser.yylval = new ParserVal(yytext()); return Parser.MENOS;}

"*"         {parser.yylval = new ParserVal(yytext()); return Parser.MULT;}

"/"         {parser.yylval = new ParserVal(yytext()); return Parser.DIV;}

{NUMBER}    {parser.yylval = new ParserVal(new Double(yytext())); return Parser.NUMBER;}

" "         {}

.           { System.out.println("No reconocido ->" + yytext() + "<-"); }