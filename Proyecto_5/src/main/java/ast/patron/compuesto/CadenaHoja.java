
package ast.patron.compuesto;

import ast.patron.visitante.Visitor;

/**
 *
 * @author Flores Gonz�lez Luis.
 */
public class CadenaHoja extends Hoja{

    public CadenaHoja(String cadena) {
        valor = new Variable(cadena);
        tipo = 3;
    }
        
    @Override
    public void accept(Visitor v){
       v.visit(this);
    }
}
