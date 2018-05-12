
package ast.patron.compuesto;

import ast.patron.visitante.Visitor;

/**
 * Multiplicaicon.
 * 
 * @author Flores Gonz�lez Luis.
 */
public class PorNodoBinario extends NodoBinario{

    public PorNodoBinario(Nodo l, Nodo r) {
        super(l, r);
    }
    
    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
    
}
