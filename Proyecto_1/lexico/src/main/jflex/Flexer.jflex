package com.kaab.compiladores.lexico;
import java.util.Stack;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

%%

%{
    public FileWriter fw;
    public int tabLen;
    public Stack<Integer> pila = new Stack<Integer>();
    public int espacios = 0;
    public String cadenaActual;

    /**
     * Regresa por cada linea el nivel de identación y deindentación.
     */

    public String generaIndent(int size) {
        String v = "INDENTA(" + size  + ")";
        try{
            fw.write(v);
        }catch(IOException e){
            System.out.println("ERROR CON EL ARCHIVO");
            e.printStackTrace();
        }
        return v;
    }

    public String generaDeindent(int size) {
        String v = "DEINDENTA(" + size  + ")";
        try{
            fw.write(v);
        }catch(IOException e){
            System.out.println("ERROR CON EL ARCHIVO");
            e.printStackTrace();
        }
        return v;
    }

    public String getIndentaDeindenta() throws IOException{

        if(tabLen == 0 && pila.empty()){  // Verifica si la pila esta vacia para detectar el primer bloque a poner
            pila.push(tabLen);

        }else{ // Si la pila ya tiene al menos un elemento
            // Caso 1:
            // Verifica si la nueva identacion es mayor al ultimo elemento insertado
            if(pila.peek() < tabLen){
                // Es una longitud correcta del nuevo bloque
                pila.push(tabLen);
            }    
            // Caso 2:
            // Verifica si la nueva identacion es menor al ultimo elemento insertado
            else if( pila.peek() > tabLen){
                String tokens = "";
                // Se va sacando un bloque y generando un token hasta que empaten
                while( pila.peek() != tabLen ){
                    if( tabLen > pila.peek() ){
                        //throw error
                        System.out.println("\nError identacion, linea "+ yyline);
                        fw.write("\nError identacion, linea "+ yyline);
                        fw.flush();
                        fw.close();
                        System.exit(0);
                        break;
                        
                    }
                    tokens += generaDeindent(pila.pop());
                }
                return tokens;
            }
            // Caso 3:
            // Verifica si la nueva identacion es migual al ultimo elemento insertado
            else if( pila.peek() == tabLen ){
                //Se trata del mismo bloque, no hay que producir nada
                return "";
            }
        }
        return generaIndent(tabLen);
    }
%}

%class Flexer
%public
%standalone
%unicode
%line
%x CONTEXTO

%eof{
    while( pila.peek() != 0 ){
        System.out.println(generaDeindent(pila.pop()));
    }
%eof}

BOOLEANO        =       True | False

ENTERO          =       [1-9][0-9]* | 0+

REAL            =       \.[0-9]+ | {ENTERO}\.[0-9]+ | {ENTERO}\.

CADENA          =       "\"" [^\\"\""]* "\""

P_RESERVADA     =       and | or | not | for | while | if | else | elif | print

IDENTIFICADOR   =       ([:letter:] | _ ) ([:jletter:] | [:digit:] | _ )*

OPERADOR        =       \+ | \- | \* | \*\* | \/ | \/\/ | \% | \< | \> | \>\= 
                        | \<\= | \= | \! | \=\=

SEPARADOR       =       \:

TABULADOR       =       "\t"

ESPACIO         =       " "

%%
"("                 {}
")"                 {}
{ESPACIO}           {}
[\n]                { System.out.println("SALTO"); yybegin(CONTEXTO); this.espacios = 0;
                      fw.write("SALTO");
}
{P_RESERVADA}       { System.out.print("RESERVADA(" + yytext() + ")"); fw.write("RESERVADA(" + yytext() + ")");}
{IDENTIFICADOR}     { System.out.print("IDENTIFICADOR(" + yytext() + ")"); fw.write("IDENTIFICADOR(" + yytext() + ")"); }
{BOOLEANO}          { System.out.print("BOOLEANO(" + yytext() + ")"); fw.write("BOOLEANO(" + yytext() + ")");}
{ENTERO}            { System.out.print("ENTERO(" + yytext() + ")"); fw.write("ENTERO(" + yytext() + ")");}
{REAL}              { System.out.print("REAL(" + yytext() + ")"); fw.write("REAL(" + yytext() + ")");}
{CADENA}            { cadenaActual = yytext();
                      if(cadenaActual.contains("\\") || cadenaActual.substring(1, cadenaActual.length()-1).contains("\"")){
                       System.out.print("\nError de cadena: "+ cadenaActual +", linea:" + yyline);
                       fw.write("\nError de cadena: "+ cadenaActual +", linea:" + yyline);
                        fw.flush();
                        fw.close();
                       System.exit(0);
                       }else{ 
                            System.out.print("CADENA(" + yytext() + ")");  
                            fw.write("CADENA(" + yytext() + ")");
                       }
                    }
{OPERADOR}          { System.out.print("OPERADOR(" + yytext() + ")"); fw.write("OPERADOR(" + yytext() + ")");}
{SEPARADOR}         { System.out.print("SEPARADOR(" + yytext() + ")"); fw.write("SEPARADOR(" + yytext() + ")");}
.                   { System.out.print("\nError, lexema no identificado, linea:" + yyline); 
                      fw.write("\nError, lexema no identificado, linea:" + yyline);
                        fw.flush();
                        fw.close();
                    System.exit(0);}

<CONTEXTO>{
    {ESPACIO}      {this.espacios++; }
    {TABULADOR}    {this.espacios+=4;}
    . {yypushback(1); tabLen = this.espacios; System.out.println( getIndentaDeindenta()); yybegin(YYINITIAL);}
    
}

. { }