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



NUMBER      = [0-9][0-9]* | [0-9][0-9]* \. [0-9]+

%%

"+"         {parser.yyval = new ParserVal(yytext()); return Parser.MAS;}

"-"         {parser.yylval = new ParserVal(yytext()); return Parser.MENOS;}

"*"         {parser.yylval = new ParserVal(yytext()); return Parser.MULT;}

"/"         {parser.yylval = new ParserVal(yytext()); return Parser.DIV;}

{NUMBER}    {
            double d = Double.parseDouble(yytext());
            parser.yylval = new ParserVal(d);
            return Parser.NUM; }

" "         {}

.           { System.err.println("[ERROR] Error de sintaxis");
                System.exit(0); }