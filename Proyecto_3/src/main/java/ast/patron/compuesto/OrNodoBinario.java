
package ast.patron.compuesto;

import ast.patron.visitante.Visitor;

/**
 *
 * @author Flores González Luis.
 */
public class OrNodoBinario extends NodoBinario{
    
    OrNodoBinario(Nodo l, Nodo r){
        super(l, r);
    }
    
    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
}
