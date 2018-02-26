package testmaven;  

public class Test {

    public static void main (String[] args){
        AnalizadorLexico al = new AnalizadorLexico("src/main/resources/prog.c");
        System.out.println("analizando:");
        al.analiza();
        System.out.println("fin");
    }
}