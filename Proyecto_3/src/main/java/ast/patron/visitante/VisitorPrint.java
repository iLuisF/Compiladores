package ast.patron.visitante;
import ast.patron.compuesto.*;
import java.util.LinkedList;
import java.util.Iterator;

public class VisitorPrint implements Visitor
{

    public void visit(AddNodo n){
        System.out.println("[+]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }
    public void visit(AsigNodo n){
        System.out.println("[=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");

    }
    public void visit(Compuesto n){
        for (Iterator i = n.getHijos().iterator(); i.hasNext(); ) {
            Nodo hijo = (Nodo) i.next();
            System.out.print("[");
            hijo.accept(this);
            System.out.println("]");
        }

    }
    public void visit(DifNodo n){
        System.out.println("[-]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        n.getUltimoHijo().accept(this);
    }
    public void visit(Hoja n){
        System.out.print("[Hoja]: "+ n.toString());
    }
    public void visit(IdentifierHoja n){
	System.out.print("[Hoja Identificador] id: "+ n.getNombre());
    }
    public void visit(IntHoja n){
	System.out.print("[Hoja Entera] valor: " + n.getValor().ival);
    }
    public void visit(Nodo n){

    }
    public void visit(NodoBinario n){

    }
    public void visit(NodoStmts n){
    }

    public void visit(AndNodoBinario n) {
        System.out.println("[^]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(DiffNodoBinario n) {
        System.out.println("[!=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(DivEnteraNodoBinario n) {
        System.out.println("[//]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(DivNodoBinario n) {
        System.out.println("[/]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(EqualsNodoBinario n) {
        System.out.println("[==]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(GrNodoBinario n) {
        System.out.println("[>]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(GrqNodoBinario n) {
        System.out.println("[>=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(LeNodoBinario n) {
        System.out.println("[<]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(LeqNodoBinario n) {
        System.out.println("[<=]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(ModuloNodoBinario n) {
        System.out.println("[%]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(NotNodo n) {
        System.out.println("[!]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(OrNodoBinario n) {
        System.out.println("[v]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(PorNodoBinario n) {
        System.out.println("[*]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(PotenciaNodoBinario n) {
        System.out.println("[**]");
        System.out.print("[");
        n.getPrimerHijo().accept(this);
        System.out.print("]");
        System.out.print("[");
        n.getUltimoHijo().accept(this);
        System.out.println("]");
    }

    public void visit(PrintNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void visit(WhileNodoBinario n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
