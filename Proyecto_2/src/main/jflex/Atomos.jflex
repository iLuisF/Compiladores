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
%state INDENTA CADENA CODIGO DEINDENTA
%unicode

%{
    static Stack<Integer> pila = new Stack<Integer>();
    static Integer actual = 0;
    static String cadena = "";
    static int dedents = 0;
    static int indents = 0;

    private Parser yyparser;

    public Flexer(java.io.Reader r, Parser parser){
    	   this(r);
    	   yyparser = parser;
    }


    /** Función que maneja los niveles de indetación
    * @param int espacios - nivel de indetación actual.
    * @return void
    */
    public void indentacion(int espacios){
        if(pila.empty()){ //ponerle un cero a la pila si esta vacia
             pila.push(new Integer(0));
        }

        Integer tope = pila.peek();

        if(tope != espacios){
	    //Se debe emitir un DEINDENTA por cada nivel mayor al actual
            if(tope > espacios){
                while(pila.peek() > espacios &&  pila.peek()!=0 ){
                    pila.pop();
                    dedents += 1;
                }
                if(pila.peek() == espacios){
		    yybegin(DEINDENTA);
                }else{
		    System.out.println("Error de indentación. Línea "+(yyline+1));
		    System.exit(1);
		}
                return;
            }
   	    //El nivel actual de indentación es mayor a los anteriores.
            pila.push(espacios);
	    yybegin(CODIGO);
            indents = 1;
        }else yybegin(CODIGO);
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
OP_MAS                  =       "+"
OP_MENOS                =       "-"
OP_MULT                 =       "*"
OP_POT                  =       "**"
OP_DIV                  =       "/"
OP_CMNT                 =       \/\/
OP_MOD                  =       "%"
OP_MENQ                 =       "<"
OP_MAYQ                 =       ">"
OP_MAYIQ                =       ">="
OP_MENIQ                =       "<=" 
OP_IGUAL                =       "="
OP_DIF                  =       "!="
OP_EXIGUAL              =       "=="
OP_2PNTS                =       \:
OPERADOR  		=       ("+" | "-" | "*" | "**" | "/" | "//" | "%" |
			         "<" | ">" | "<=" | "+=" | "-=" | ">=" | "==" | "!=" | "<>" | "=" )
SEPARADOR  		=       ("(" | ")" | ":" | ";" )
SALTO          	        =       "\n"
IDENTIFICADOR       	= 	([:letter:] | "_" )([:letter:] | "_" | [0-9])*
ESC              	= 	(\\)
CHAR_LITERAL   	        = 	([:letter:] | [:digit:] | "_" | "$" | " " | "#" | {OPERADOR} | {SEPARADOR})
COMENTARIO 		=     	"#".*{SALTO}
BOOLEANO		=	("True" | "False")

%%


{COMENTARIO}      			{}
<CADENA>{
  {CHAR_LITERAL}*\"			{ yybegin(CODIGO); return Parser.CADENA;}
  {SALTO}				{ System.out.println("Cadena mal construida, linea " + (yyline+1) ); System.exit(1);}

}

<YYINITIAL>{
  " "+                        		{ System.out.println("Error de indentación. Línea " + (yyline+1) ); System.exit(1);}
  .                               	{ yypushback(1); yybegin(CODIGO);}
}

<CODIGO>{
  \"					 { yybegin(CADENA); }
  {ENTERO}				 { System.out.println("*ENTERO*"); return Parser.ENTERO; }
  {REAL}     				 { return Parser.REAL; }
  {OP_MAS}                               { return Parser.MAS; }
  {OP_MENOS}                             { return Parser.MENOS; } 
  {OP_MULT}                              { return Parser.MULT; }
  {OP_POT}                               { return Parser.POT; }
  {OP_DIV}                               { return Parser.DIV; }
  {OP_CMNT}                              { return Parser.CMNT; }
  {OP_MOD}                               { return Parser.MOD; }
  {OP_MENQ}                              { return Parser.MENQ; }
  {OP_MAYQ}                              { System.out.println("*>*");return Parser.MAYQ; }
  {OP_MAYIQ}                             { return Parser.MAYIQ; }
  {OP_MENIQ}                             { return Parser.MENIQ; }
  {OP_IGUAL}                             { System.out.println("*IGUAL*");  return Parser.IGUAL; }
  {OP_DIF}                               { return Parser.DIF; }
  {OP_EXIGUAL}                           { return Parser.EXIGUAL; }
  {OP_2PNTS}                             { System.out.println("* :  *");return Parser.PNTS; }
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
  {IDENTIFICADOR}           		 { System.out.println("*IDENTIFICADOR*"); return Parser.IDENTIFICADOR; }
  {SALTO}                 		 {  yybegin(INDENTA); actual=0; return Parser.SALTO; }
  " "                        		 {   }
}


<DEINDENTA>{
  .                                       { yypushback(1);
  					    if(dedents > 0){
						dedents--;
                                                System.out.println("****DEINDENTACION****");
						return Parser.DEINDENTA;
  					    }
					    yybegin(CODIGO);}
}

<INDENTA>{
  {SALTO}                                 { actual = 0;}
  " "				          { actual++;}
  \t					  { actual += 4;}
  .					  { yypushback(1);
					    this.indentacion(actual);
					    if(indents == 1){
					      indents = 0;
                                              System.out.println("****INDENTACION****");
					      return Parser.INDENTA;
					    }
					  }
}

<<EOF>>                                   { this.indentacion(0);
					    if(dedents > 0){
					      dedents--;
					      return Parser.DEINDENTA;
					    }else{
                                              return 0;
				            }
					  }

.					{ System.err.println("ERROR LÉXICO\n\t lÍNEA:" + (yyline+1)) ; System.exit(1); }
