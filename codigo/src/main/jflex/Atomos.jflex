package testmaven;
%%
%class Aléxico
%public
%standalone
%unicode
PUNTO   = \.
ENTERO  = ENTERO_POS | ENTERO_NEG
ENTERO_POS  = [0-9][0-9]*
ENTERO_NEG  = [-][1-9][0-9]*
FLOTANTE = {ENTERO} {PUNTO} {ENTERO_POS} f

NO_ID_C = auto | break
    |case
    |char
    |const
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

ID_C = ID_C_AUX | [_] ID_C_AUX
ID_C_AUX = [:letter:] [:letterdigit:]*

    

COMENTARIO = \/\/ .* | \/\* ( . | \n )*  \*\/


%%
{ENTERO}      { System.out.print("ENTERO("+yytext() + ")"); }
{ID_C}     { System.out.print("ID_C("+yytext() + ")"); }
{COMENTARIO}     { System.out.print("FLOTANTE("+yytext() + ")"); }
{FLOTANTE}     { System.out.print("COMENTARIO("+yytext() + ")"); }
.             { }