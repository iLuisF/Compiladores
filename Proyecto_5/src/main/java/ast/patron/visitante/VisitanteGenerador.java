/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.visitante;

import ast.Registros;
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
import ast.patron.compuesto.IfNodo;
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

/**
 *
 * @author daniel
 */
public class VisitanteGenerador implements Visitor{
    
    
    private static final int BOOL = 0;
    private static final int ENT = 1;
    private static final int RL = 2;
    private static final int CAD = 3;
    
    Registros reg = new Registros();  
    //main: indica el comienzo de codigo(primera instrucción a ejecutar).
    //.data: declaraciones que siguen esta linea.
    String instrucciones = "main:\n.data\n";
            
    /**
     * Metodo auxiliar para resolver la sum, multiplicacion y division
     * @param n Nodo a traducir
     */
    private void visitSumResMult(NodoBinario n, String opNameEnt, String opNameFlt){
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();

        // Tipo de registro objetivo
        boolean entero =  !(n.getType() == RL);
        
        // Registro objetivo
        int objetivo = reg.getObjetivo(entero);
        String[] siguientes = reg.getNsiguientes(2,entero);

        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0],entero);
        hi.accept(this);

        // Genero el código del subárbol derecho
        reg.setObjetivo(siguientes[1], entero);
        hd.accept(this);

        String opcode =  entero? opNameEnt : opNameFlt;

        System.out.println(opcode + " " + objetivo + ", " +
                            siguientes[0] + ", " + siguientes[1]);
    }
    
    public void visit(AddNodo n) {
        visitSumResMult(n, "add", "add.s");
    }

    public void visit(AsigNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void visit(DifNodo n){
        visitSumResMult(n, "sub", "sub.s");
    }

    public void visit(Compuesto n) {
        for(Nodo nodo : n.getHijos().getAll()){
            nodo.accept(this);
        }
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
        visitSumResMult(n, "div", "div.s");
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
        visitSumResMult(n, "mul", "mul.s");
    }

    public void visit(PotenciaNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * li: load inmediate value en el registro destino.
     * syscall: se llama al sistema operativo para realizar la operación.
     * @param n 
     */
    public void visit(PrintNodoBinario n) {
        // metodo listo para que ai Luis efe haga de als suyas
        Nodo hi = n.getPrimerHijo();
        Nodo hd = n.getUltimoHijo();

        // Tipo de registro objetivo
        boolean entero =  !(n.getType() == RL);
        
        // Registro objetivo
        int objetivo = reg.getObjetivo(entero);
        String[] siguientes = reg.getNsiguientes(2,entero);

        // Genero el código del subárbol izquiero
        reg.setObjetivo(siguientes[0],entero);
        hi.accept(this);
        
        if(entero){
            this.instrucciones += "move $a0 " + objetivo;
        } else {
            this.instrucciones += "move $f12 " + objetivo + " li $v0 1" + "syscall";
        }

    }

    public void visit(WhileNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(IfNodo n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(BooleanoHoja n) {
    }

    public void visit(CadenaHoja n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(RealHoja n) {
        // Registro objetivo
        int objetivo = reg.getObjetivo(false);
        
        System.out.println("li" + " " + objetivo + ", " + n.getValor());
    }
    
    public String getInstrucciones(){
        return this.instrucciones;
    }
}
