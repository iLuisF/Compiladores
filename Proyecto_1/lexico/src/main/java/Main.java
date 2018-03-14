
import java.util.Scanner;


public class Main {
    
    public static void main (String[] args){
        System.out.println("Nombre del archivo a leer: ");
        //Scanner sc = new Scanner(System.in);
        //String archivo = sc.nextLine();
        //AnalizadorLexico al = new AnalizadorLexico("src/main/resources/" + archivo);
        AnalizadorLexico al = new AnalizadorLexico("src/main/resources/fizzbuzz.p");
        System.out.println("analizando:\n");
        al.analiza();
        System.out.println("\nfin");
    }
    
}
