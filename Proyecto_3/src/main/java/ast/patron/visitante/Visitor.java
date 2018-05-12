package ast.patron.visitante;
import ast.patron.compuesto.*;

public interface Visitor
{
    public void visit(AddNodo n);  //
    public void visit(AsigNodo n);
    public void visit(Compuesto n);
    public void visit(DifNodo n);  //
    public void visit(Hoja n);
    public void visit(IdentifierHoja n);
    public void visit(IntHoja n);
    public void visit(Nodo n);
    public void visit(NodoBinario n);
    public void visit(NodoStmts n);
    public void visit(AndNodoBinario n);
    public void visit(DiffNodoBinario n);
    public void visit(DivEnteraNodoBinario n);
    public void visit(DivNodoBinario n);
    public void visit(EqualsNodoBinario n);
    public void visit(GrNodoBinario n);
    public void visit(GrqNodoBinario n);
    public void visit(LeNodoBinario n);
    public void visit(LeqNodoBinario n);
    public void visit(ModuloNodoBinario n);
    public void visit(NotNodo n);
    public void visit(OrNodoBinario n);
    public void visit(PorNodoBinario n);
    public void visit(PotenciaNodoBinario n);
    public void visit(PrintNodoBinario n);    
    public void visit(WhileNodoBinario n);
    public void visit(BooleanoHoja n);
    public void visit(CadenaHoja n);
    public void visit(RealHoja n);
}
