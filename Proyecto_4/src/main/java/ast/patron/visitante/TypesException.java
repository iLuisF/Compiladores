/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.visitante;

/**
 *
 * @author ulises
 */
public class TypesException extends Exception {
    
    private final String[] typesNames = {"Booleano", "Entero", "Real", "Cadena"};
    
    public TypesException(String op, int t1, int t2){
        System.err.println("Los tipos "+ typesNames[t1] + " y " + typesNames[t2] + " no son válidos con la operación " + op);
        System.exit(0);
    }
    
    public TypesException(int t1, int t2, String nameId){
        System.err.println("Reasignación de un tipo " + typesNames[t1] + " a " + typesNames[t2] + " en variable " + nameId ) ;
        System.exit(0);
    }
}
