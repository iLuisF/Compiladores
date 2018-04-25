/********************************************************************************
**  @author Diana Montes con modificaciones de KAAB                            **
*********************************************************************************/

package asintactico;
import java.util.Stack;
%%
%public
%class Flexer
%debug
%byaccj
%line
%standalone
%state INDENTA CADENA CODIGO
%unicode

%{
    private Parser yyparser;

    public Flexer(java.io.Reader r, Parser parser){
    	   this(r);
    	   yyparser = parser;
    }

    /* Acumula todos los átomos de DEINDENTA que deben ser devueltos  */
    static String dedents = "";
    /* Estructura auxiliar para almacenar los bloques de indentación */
    static Stack<Integer> pila = new Stack<Integer>();
    /* Guarda el nivel actual de indentación */
    static Integer actual = 0;
    /** Función que maneja los niveles de indetación e imprime
    * átomos INDENTA y DEINDENTA.
    * @param int espacios - nivel de indetación actual.
    * @return boolean - true en caso que no haya errores léxicos,
    * 	      	      	 false en otro caso.
    */
    public static boolean indentacion(int espacios){
        if(pila.empty()){ //ponerle un cero a la pila si esta vacia
             pila.push(new Integer(0));
        }

        Integer tope = pila.peek();

        if(tope != espacios){
	    //Se debe emitir un DEDENT por cada nivel mayor al actual
            if(tope > espacios){
                while(pila.peek() > espacios &&  pila.peek()!=0 ){
                    dedents += "DEINDENTA("+pila.pop()+")\n";
                }
                if(pila.peek() == espacios){
                    System.out.print(dedents);
                    dedents = "";
                    return true;
                }
                return false;
            }
   	    //El nivel actual de indentación es mayor a los anteriores.
            pila.push(espacios);
            System.out.println("INDENTA("+actual+")");
            return true;
        }
	//El nivel actual es igual al anterior.
        return true;
    }
%}
PUNTO			=	\.
DIGIT           	=       [0-9]
CERO             	=        0+
ENTERO			= 	{CERO} | {DIGIT}+
REAL			= 	{ENTERO}? {PUNTO} {ENTERO} | {ENTERO} {PUNTO} {ENTERO}?
P_AND                   =       and
P_NOT                   =       not
P_WH                    =       while
P_FOR                   =       for
P_ELI                   =       elif
P_OR                    =       or
P_ELS                   =       else
P_IF                    =       if
P_PNT                   =       print
OP_MAS                  =       \+
OP_MENOS                =       \-
OP_MULT                 =       \*
OP_POT                  =       \*\*
OP_DIV                  =       \/
OP_CMNT                 =       \/\/
OP_MOD                  =       \%
OP_MENQ                 =       \<
OP_MAYQ                 =       \>
OP_MAYIQ                =       \>\=
OP_MENIQ                =       \<\=
OP_IGUAL                =       \=
OP_DIF                  =       \!=
OP_EXIGUAL              =       \=\=
OP_2PNTS                =       \:
OPERADOR  		=       ("+" | "-" | "*" | "**" | "/" | "//" | "%" |
			         "<" | ">" | "<=" | "+=" | "-=" | ">=" | "==" | "!=" | "<>" | "=" )
SEPARADOR  		=       ("(" | ")" | ":" | ";" )
SALTO          	        =        "\n"
IDENTIFICADOR       	= 	([:letter:] | "_" )([:letter:] | "_" | [0-9])*
ESC              	= 	(\\)
CHAR_LITERAL   	        = 	([:letter:] | [:digit:] | "_" | "$" | " " | "#" | {OPERADOR} | {SEPARADOR}) | "\\"
COMENTARIO 		=     	"#".*{SALTO}
BOOLEANO		=	("True" | "False")

%%


{COMENTARIO}      			{}
<CADENA>{
  {CHAR_LITERAL}*\"			{ yybegin(CODIGO);  return Parser.CADENA;}
  {SALTO}				{ System.out.println("Cadena mal construida, linea " + (yyline+1) ); System.exit(1);}
}
<YYINITIAL>{
  " "+                        		{ System.out.println("Error de indentación. Línea " + (yyline+1) ); System.exit(1);}
  .                               	{ yypushback(1); yybegin(CODIGO);}
}
<CODIGO>{
  \"					 { yybegin(CADENA); }
  {ENTERO}				 { return Parser.ENTERO; }
  {REAL}     				 { return Parser.REAL; }
  {OP_MAS}                               { return Parser.MAS; }
  {OP_MENOS}                             { return Parser.MENOS; } 
  {OP_MULT}                              { return Parser.MULT; }
  {OP_POT}                               { return Parser.POT; }
  {OP_DIV}                               { return Parser.DIV; }
  {OP_CMNT}                              { return Parser.CMNT; }
  {OP_MOD}                               { return Parser.MOD; }
  {OP_MENQ}                              { return Parser.MENQ; }
  {OP_MAYQ}                              { return Parser.MAYQ; }
  {OP_MAYIQ}                             { return Parser.MAYIQ; }
  {OP_MENIQ}                             { return Parser.MENIQ; }
  {OP_IGUAL}                             { return Parser.IGUAL; }
  {OP_DIF}                               { return Parser.DIF; }
  {OP_EXIGUAL}                           { return Parser.EXIGUAL; }
  {OP_2PNTS}                             { return Parser.PNTS; }
  "("                                    { return Parser.PI;}
  ")"                                    { return Parser.PD;}
  {P_AND}                                { return Parser.AND; }
  {P_OR}                                 { return Parser.OR; }
  {P_NOT}                                { return Parser.NOT; }
  {P_FOR}                                { return Parser.FOR; }
  {P_WH}                                 { return Parser.WHILE; }
  {P_IF}                                 { return Parser.IF; }
  {P_ELS}                                { return Parser.ELSE; }
  {P_ELI}                                { return Parser.ELIF; }
  {P_PNT}                                { return Parser.PRINT; }
  {BOOLEANO}                 	 	 { return Parser.BOOLEANO; }
  {IDENTIFICADOR}           		 { return Parser.IDENTIFICADOR; }
  {SALTO}                 		 { yybegin(INDENTA); actual=0; System.out.print("SALTO"+yytext()); }
  " "                        		 {   }
}

<INDENTA>{
  {SALTO}				{ actual = 0;}
  " "                            	{ actual++;}
  \t                             	{ actual += 4;}
  .                               	{ yypushback(1);
                                          if(!indentacion(actual)){
                                                System.out.println("Error de indentacion, linea "+(yyline+1));
                                                System.exit(1);
                                          }
					  yybegin(CODIGO);
					}
}
<<EOF>>                                 {indentacion(0); System.exit(0);}
[^]					{ System.out.println("Error de sintáxis: caractér inválido: " + yytext() + "\nLínea "+(yyline+1));
					  System.exit(1); }