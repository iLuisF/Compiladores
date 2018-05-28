package ast.patron.compuesto;
import ast.patron.visitante.*;

public class Compuesto extends Nodo
{

    public Compuesto(){
        hijos = new Hijos();
    }

    public Compuesto(Nodo l){
        hijos = new Hijos(l);
    }

    public Nodo getPrimerHijo(){
	return hijos.getPrimerHijo();
    }

    public Nodo getUltimoHijo(){
        return hijos.getUltimoHijo();
    }

    public void agregaHijoPrincipio(Nodo l){
	hijos.agregaHijoPrincipio(l);
    }

    public void agregaHijoFinal(Nodo r){
	hijos.agregaHijoFinal(r);
    }

    public void accept(Visitor v){
     	v.visit(this);
    }

}
