
package ast.patron.compuesto;

import ast.patron.visitante.Visitor;

/**
 *
 * @author Flores González Luis.
 */
public class CadenaHoja extends Hoja{

    public CadenaHoja(String cadena) {
        valor = new Variable(cadena);
        tipo = 1;
    }
        
    @Override
    public void accept(Visitor v){
       v.visit(this);
    }
}
