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
MAS_MENOS       =       \+ | \-
MULT_DIV        =       \* | \/

E1              =       ({E1} {MAS_MENOS})* {T1}
T1              =       ({T1} {MULT_DIV})* {F}

E2               =      {T2} ({MAS_MENOS} {E2})*
T2               =      {F} ({MULT_DIV} {T2})*

F               =       [\- | ""] {NUMBER}

%%
a             { parser.yylval = new ParserVal(yytext()); return parser.NODO; }
.             { }

{E1}          {return Parser.E1}
{T1}          {return Parser.T1}

{E2}          {return Parser.E2}
{T2}          {return Parser.T2}

{F}           {return Parser.F}
