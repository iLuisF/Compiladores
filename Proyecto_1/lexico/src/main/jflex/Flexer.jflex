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
    
    if(pila.peek() == 0){  // Verifica si la pila esta vacia para detectar el primer bloque a poner
        push(tabLen);
        return generaIndent(tablen);
    else{ // Si la pila ya tiene al menos un elemento
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
                if( tabLen < pila.peek() ){
                    //throw error
                    break;
                }
                tokens += generaDeindent(pila.push());
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
}

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
