package testmaven;
%%
%class AlexicoC
%public
%standalone
%unicode
PUNTO   = \.
ENTERO  = {ENTERO_POS} | {ENTERO_NEG}
ENTERO_POS  = [0-9][0-9]*
ENTERO_NEG  = [-][1-9][0-9]*
FLOTANTE = {ENTERO} {PUNTO} {ENTERO_POS} f

NO_ID_C = auto | break
    |case
    |char
    |consts
    |continue
    |default
    |do
    |double
    |else
    |enum
    |extern
    |float
    |for
    |goto
    |if
    |int
    |long
    |register
    |return
    |short
    |signed
    |sizeof
    |static
    |struct
    |switch
    |typedef
    |union
    |unsigned
    |void
    |volatile
    |while

ID_C = [:letter:] {ID_C_AUX} | _* ([:letter:] | [:digit:]) {ID_C_AUX}
ID_C_AUX = ([:letter:] | [:digit:] | _)*

    

COMENTARIO = \/\/ .* | \/\* ( . | \n )*  \*\/


%%
{NO_ID_C}       {System.out.print("-"); }
{ENTERO}      { System.out.print("ENTERO("+yytext() + ")"); }
{ID_C}     { System.out.print("ID_C("+yytext() + ")"); }
{COMENTARIO}     { System.out.print("COMENTARIO("+yytext() + ")"); }
{FLOTANTE}     { System.out.print("FLOTANTE("+yytext() + ")"); }
.             { System.out.print("--"); }
