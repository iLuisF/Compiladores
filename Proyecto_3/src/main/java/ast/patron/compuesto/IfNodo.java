
package ast.patron.compuesto;

import ast.patron.visitante.Visitor;

/**
 *
 * @author Flores Gonzalez Luis.
 */
public class IfNodo extends Compuesto {
    
    public IfNodo(Nodo t, Nodo l, Nodo r){
        super(t);
        this.getHijos().agregaHijoFinal(l);
        this.getHijos().agregaHijoFinal(r);
    }
    
    public IfNodo(Nodo t, Nodo l){
        super(t);
        this.getHijos().agregaHijoFinal(l);
    }    
    
    @Override
    public void accept(Visitor v){
        v.visit(this);
    }    
}
