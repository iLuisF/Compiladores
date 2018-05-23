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
    
    public TypesException(String op, String t1, String t2){
        System.err.println("Los tipos "+ t1 + " y " + t2 + " no son válidos con la operación " + op);
    }
}
