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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Por simplicidad, los tipos estarán definidos de la siguiente manera:
 *  0 - Booleano
 *  1 - Entero
 *  2 - Real
 *  3 - Cadenas
 * @author ulises
 */
public class VisitanteConcreto implements Visitor {
    
    
    private static final int BOOL = 0;
    private static final int ENT = 1;
    private static final int RL = 2;
    private static final int CAD = 3;
    
    /**
     * Se pretende acceder con el nombre con el que se llama la variable en el código
     * fuente y almacenar el tipo que posee en un entero.
     */
    private Hashtable<String, Integer> tablaSim;
        
    public VisitanteConcreto(){
        tablaSim = new Hashtable<String, Integer>();
    }
    
    /*
     * La suma puede ser real o entera
     */
    public void visit(AddNodo n) {
        try {
            n.getPrimerHijo().accept(this);
            n.getUltimoHijo().accept(this);
            n.setTipo(SysTypes.checkSuma(n.getPrimerHijo().getType(), n.getUltimoHijo().getType()));
        } catch (TypesException ex) {
            Logger.getLogger(VisitanteConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // En la Asignación es donde se puede registrar un identificador en la tabla de símbolos
    public void visit(AsigNodo n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
        String name = n.getPrimerHijo().getNombre();
        // Verifica en la TS si existe
        if (tablaSim.contains(name)){
            // Verifica si el tipo que tenía es igual al nuevo
            if(tablaSim.get(name) != n.getUltimoHijo().getType()){
                try {
                    throw new TypesException(tablaSim.get(name), n.getUltimoHijo().getType(), name);
                } catch (TypesException ex) {
                    Logger.getLogger(VisitanteConcreto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                n.setTipo(tablaSim.get(name));
            }
        }else{  // Si no lo contiene, registra
            tablaSim.put(name, n.getUltimoHijo().getType());
        }
    }

    // Sup que sólo tiene que visitar a todos y no tiene tipo
    public void visit(Compuesto n) {
        for(Nodo nodo : n.getHijos().getAll()){
            nodo.accept(this);
        }
    }

    public void visit(DifNodo n) {
        try {
            n.getPrimerHijo().accept(this);
            n.getUltimoHijo().accept(this);
            n.setTipo(SysTypes.checkDif(n.getPrimerHijo().getType(), n.getUltimoHijo().getType()));
        } catch (TypesException ex) {
            Logger.getLogger(VisitanteConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void visit(Hoja n) {
        //nada
    }

    /*
    * Si se llega a esta hoja puede ser por los siguientes dos casos:
    * 1- Por la asignación, que, si no existe el identificador, lo agrega
    * 2- Por la referencia a la variable
    *
    * Si se llaga a esta hoja y no existe en la tabla de Símbolos, se marca un error,
    * pues significa que se intenta utilizar y nunca se declaró.
    */
    public void visit(IdentifierHoja n) {
        if( !tablaSim.contains(n.getNombre())){
            System.err.println("La variable " + n.getNombre() + " No tiene un valor definido");
        }
    }

    public void visit(IntHoja n) {
        n.setTipo(ENT);
    }

    public void visit(Nodo n) {
        
    }

    public void visit(NodoBinario n) {
        
    }

    public void visit(NodoStmts n) {
        
    }

    public void visit(AndNodoBinario n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
        try {
            n.setTipo(SysTypes.checkOpLogica("AND_LÓGICO", n.getPrimerHijo().getType(), n.getUltimoHijo().getType()));
        } catch (TypesException ex) {
            Logger.getLogger(VisitanteConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // !=
    public void visit(DiffNodoBinario n) {
        visitCompOp("DIFERENTE (!=)", n);
    }

    public void visit(DivEnteraNodoBinario n) {
        try {
            n.getPrimerHijo().accept(this);
            n.getUltimoHijo().accept(this);
            n.setTipo(SysTypes.checkDivEntera(n.getPrimerHijo().getType(), n.getUltimoHijo().getType()));
        } catch (TypesException ex) {
            Logger.getLogger(VisitanteConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void visit(DivNodoBinario n) {
        try {
            n.getPrimerHijo().accept(this);
            n.getUltimoHijo().accept(this);
            n.setTipo(SysTypes.checkDiv(n.getPrimerHijo().getType(), n.getUltimoHijo().getType()));
        } catch (TypesException ex) {
            Logger.getLogger(VisitanteConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Debe ser válido en numeros y cadenas
    public void visit(EqualsNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // >
    public void visit(GrNodoBinario n) {
        visitCompOp("MAYOR QUE (>)", n);
    }

    // >=
    public void visit(GrqNodoBinario n) {
        visitCompOp("MAYOR O IGUAL QUE (>=)", n);
    }

    public void visit(LeNodoBinario n) {
        visitCompOp("MENOR QUE (<)", n);
    }

    public void visit(LeqNodoBinario n) {
        visitCompOp("MENOR O IGUAL QUE (<=)", n);
    }

    public void visit(ModuloNodoBinario n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
        try {
            n.setTipo(SysTypes.checkModulo(n.getPrimerHijo().getType(), n.getUltimoHijo().getType()));
        } catch (TypesException ex) {
            Logger.getLogger(VisitanteConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void visit(NotNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(OrNodoBinario n) {
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
        try {
            n.setTipo(SysTypes.checkOpLogica("OR_LÓGICO", n.getPrimerHijo().getType(), n.getUltimoHijo().getType()));
        } catch (TypesException ex) {
            Logger.getLogger(VisitanteConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void visit(PorNodoBinario n) {
        try {
            n.getPrimerHijo().accept(this);
            n.getUltimoHijo().accept(this);
            n.setTipo(SysTypes.checkMult(n.getPrimerHijo().getType(), n.getUltimoHijo().getType()));
        } catch (TypesException ex) {
            Logger.getLogger(VisitanteConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void visit(PotenciaNodoBinario n) {
        try {
            n.getPrimerHijo().accept(this);
            n.getUltimoHijo().accept(this);
            n.setTipo(SysTypes.checkPotencia(n.getPrimerHijo().getType(), n.getUltimoHijo().getType()));
        } catch (TypesException ex) {
            Logger.getLogger(VisitanteConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void visit(PrintNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(WhileNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(BooleanoHoja n) {
        n.setTipo(BOOL);
    }

    public void visit(CadenaHoja n) {
        n.setTipo(CAD);
    }

    public void visit(RealHoja n) {
        n.setTipo(RL);
    }
    
    // Para las operaciones de comparacion
    private void visitCompOp(String nameOp, NodoBinario n){
        n.getPrimerHijo().accept(this);
        n.getUltimoHijo().accept(this);
        try {
            n.setTipo(SysTypes.checkCompNumOp(nameOp, n.getPrimerHijo().getType(), n.getUltimoHijo().getType()));
        } catch (TypesException ex) {
            Logger.getLogger(VisitanteConcreto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
