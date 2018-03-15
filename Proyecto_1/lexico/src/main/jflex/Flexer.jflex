package com.kaab.compiladores.lexico;
import java.util.Stack;
import java.util.Arrays;

%%

%{
public int tabLen;
public Stack<Integer> pila = new Stack<Integer>();

/**
 * Regresa por cada linea el nivel de identación y deindentación.
 */

public String errorIndent(int sizeError){
    return "Error de indentacion, linea " + yyline + "\n"+
            "Los bloques son de longitud 4, longitud encontrada :" + sizeError );
}

public String generaIndent(int size){
    return "INDENTA(" + size  + ")";
}

public String generaDeindent(int size){
    return "DEINDENTA(" + size  + ")";
}

public String getIndentaDeindenta(){
    
    if(pila.empty()){  // Verifica si la pila esta vacia para detectar el primer bloque a poner

        if( tablen == 4 ){  // El primer tab en la pila debe ser de tama;o 4
            push(tablen);
            // return generaIndent(tablen);
        }else{
            return errorIndent(tablen);
        }
        else{ // Si la pila ya tiene al menos un elemento
            // Caso 1:
            // Verifica si la nueva identacion es mayor al ultimo elemento insertado
            if(pila.peek() < tabLen){
                if( tablen % 4 == 0){
                    // Es una longitud correcta del nuevo bloque
                    pila.push(tabLen);
                    // return genera
                }else{
                    return errorIndent(tablen % 4);
                }
            }

            // Caso 2:
            // Verifica si la nueva identacion es menor al ultimo elemento insertado
            else if( pila.peek() > tabLen){
                if( tablen % 4 == 0){ //  Revisa la longitud del bloque
                    String tokens = "";
                    // Se va restando 4 y sacando un bloque
                    while(pila.peek() != tabLen){
                        tokens += generaDeindent(pila.push());
                        tabLen -= 4;
                    }
                    return tokens;
                }else{
                    return errorIndent(tablen % 4);
                }
            }

            // Caso 3:
            // Verifica si la nueva identacion es migual al ultimo elemento insertado
            else if( pila.peek() == tabLen){
                //Se trata del mismo bloque, no hay que producir nada
                return "";
            }
        }
        return tabLen;
    }
}

/*
//Debe haber un pretab

public String getTabulador(){       
    //Primer entrada
    if(pila.empty()){
        pila.push(tabLen);
        return "INDENTA(" + this.pila.peek() + ")";
    } else {
        //La identación va aumentando.
        if(pila.peek() <= tabulador){
            pila.push(tabulador);
            return "INDENTA(" + this.pila.peek() + ")";
        } else {
            pila.push(tabulador);
            return "DEINDENTA(" + this.pila.peek() + ")";
        }
    }    
}
*/

%}

%class Flexer
%public
%standalone
%unicode
%line

TAB             =       [ ]

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

[\n]                { System.out.println("SALTO"); this.tabulador = 0;}
{P_RESERVADA}       { System.out.print("RESERVADA(" + yytext() + ")"); }
{IDENTIFICADOR}     { System.out.print("IDENTIFICADOR(" + yytext() + ")"); }
{BOOLEANO}          { System.out.print("BOOLEANO(" + yytext() + ")"); }
{ENTERO}            { System.out.print("ENTERO(" + yytext() + ")"); }
{REAL}              { System.out.print("REAL(" + yytext() + ")"); }
{CADENA}            { System.out.print("CADENA(" + yytext() + ")"); }
{OPERADOR}          { System.out.print("OPERADOR(" + yytext() + ")"); }
{SEPARADOR}         { System.out.print("SEPARADOR(" + yytext() + ")"); }

{TAB}               { this.tab++; System.out.print(getIndentaDeindenta()); }
