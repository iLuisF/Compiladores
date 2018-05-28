
package ast.patron.compuesto;

import ast.patron.visitante.Visitor;

/**
 *
 * @author Flores González Luis.
 */
public class WhileNodoBinario extends NodoBinario{
    
    public WhileNodoBinario(Nodo l, Nodo r){
	super(l,r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }
    
}
