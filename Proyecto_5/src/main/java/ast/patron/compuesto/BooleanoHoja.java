
package ast.patron.compuesto;

import ast.patron.visitante.Visitor;

/**
 *
 * @author Flores Gonz�lez Luis.
 */
public class BooleanoHoja extends Hoja{

    public BooleanoHoja(String booleano) {
        if(booleano.equals("True")){
            valor = new Variable(true);
        } else {
            valor = new Variable(false);
        }
        tipo = 0;
    }
    
    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
    
}
