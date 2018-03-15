package com.kaab.compiladores.lexico;

%%

%class Flexer
%public
%standalone
%unicode

BOOLEANO        =       True | False

ENTERO          =       [1-9][0-9]* | 0+

REAL            =       \.[0-9]+ | {ENTERO}\.[0-9]+ | {ENTERO}\.

CADENA          =       "\"" [^\\"\""]* "\""

P_RESERVADA     =       and | or | not | for | while | if | else | elif | print

IDENTIFICADOR   =       ([:letter:] | _ ) ([:letter:] | [:digit:] | _ )*

OPERADOR        =       \+ | \- | \* | \*\* | \/ | \/\/ | \% | \< | \> | \>\= 
                        | \<\= | \= | \! | \=\=

SEPARADOR       =       \:

%%

[/n]                { System.out.println("SALTO"); }
{P_RESERVADA}       { System.out.print("RESERVADA(" + yytext() + ")"); }
{IDENTIFICADOR}     { System.out.print("IDENTIFICADOR(" + yytext() + ")"); }
{BOOLEANO}          { System.out.print("BOOLEANO(" + yytext() + ")"); }
{ENTERO}            { System.out.print("ENTERO(" + yytext() + ")"); }
{REAL}              { System.out.print("REAL(" + yytext() + ")"); }
{CADENA}            { System.out.print("CADENA(" + yytext() + ")"); }
{OPERADOR}          { System.out.print("OPERADOR(" + yytext() + ")"); }
{SEPARADOR}         { System.out.print("SEPARADOR(" + yytext() + ")"); }
