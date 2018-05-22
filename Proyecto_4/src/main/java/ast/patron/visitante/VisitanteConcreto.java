/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.visitante;

import ast.patron.compuesto.AddNodo;
import ast.patron.compuesto.AndNodoBinario;
import ast.patron.compuesto.AsigNodo;
import ast.patron.compuesto.BooleanoHoja;
import ast.patron.compuesto.CadenaHoja;
import ast.patron.compuesto.Compuesto;
import ast.patron.compuesto.DifNodo;
import ast.patron.compuesto.DiffNodoBinario;
import ast.patron.compuesto.DivEnteraNodoBinario;
import ast.patron.compuesto.DivNodoBinario;
import ast.patron.compuesto.EqualsNodoBinario;
import ast.patron.compuesto.GrNodoBinario;
import ast.patron.compuesto.GrqNodoBinario;
import ast.patron.compuesto.Hoja;
import ast.patron.compuesto.IdentifierHoja;
import ast.patron.compuesto.IntHoja;
import ast.patron.compuesto.LeNodoBinario;
import ast.patron.compuesto.LeqNodoBinario;
import ast.patron.compuesto.ModuloNodoBinario;
import ast.patron.compuesto.Nodo;
import ast.patron.compuesto.NodoBinario;
import ast.patron.compuesto.NodoStmts;
import ast.patron.compuesto.NotNodo;
import ast.patron.compuesto.OrNodoBinario;
import ast.patron.compuesto.PorNodoBinario;
import ast.patron.compuesto.PotenciaNodoBinario;
import ast.patron.compuesto.PrintNodoBinario;
import ast.patron.compuesto.RealHoja;
import ast.patron.compuesto.WhileNodoBinario;


import java.util.Hashtable;
/**
 *
 * @author ulises
 */
public class VisitanteConcreto implements Visitor {
    
    /**
     * Se pretende acceder con el nombre con el que se llama la variable en el código
     * fuente y almacenar el tipo que posee.
     */
    Hashtable<String, String> tablaSim;
    

    public void visit(AddNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(AsigNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(Compuesto n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(DifNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(Hoja n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(IdentifierHoja n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(IntHoja n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(Nodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(NodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(NodoStmts n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(AndNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(DiffNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(DivEnteraNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(DivNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(EqualsNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(GrNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(GrqNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(LeNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(LeqNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(ModuloNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(NotNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(OrNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(PorNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(PotenciaNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(PrintNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(WhileNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(BooleanoHoja n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(CadenaHoja n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(RealHoja n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
