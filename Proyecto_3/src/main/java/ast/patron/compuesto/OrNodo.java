
package ast.patron.compuesto;

import ast.patron.visitante.Visitor;

/**
 *
 * @author Flores González Luis.
 */
public class OrNodo extends Compuesto{
    
    OrNodo(Nodo l){
        super(l);
    }
    
    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
}
