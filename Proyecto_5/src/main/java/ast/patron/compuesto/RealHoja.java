
package ast.patron.compuesto;

import ast.patron.visitante.Visitor;

/**
 *
 * @author Flores Gonz�lez Luis.
 */
public class RealHoja extends Hoja{
    
    public RealHoja(float real){
        valor = new Variable(real);
        tipo = 2;
    }
    
    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
}
