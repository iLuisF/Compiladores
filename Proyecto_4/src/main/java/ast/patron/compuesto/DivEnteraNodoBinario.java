/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.compuesto;

import ast.patron.visitante.Visitor;

/**
 *  Division entera.
 * 
 * @author Flores Gonz�lez Luis.
 */
public class DivEnteraNodoBinario extends NodoBinario{

    public DivEnteraNodoBinario(Nodo l, Nodo r) {
        super(l, r);
    }
    
    @Override
    public void accept(Visitor v){
        v.visit(this);
    }
    
}
