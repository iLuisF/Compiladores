
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    
    public static void main (String[] args){
        System.out.println("Nombre del archivo a leer: ");
        Scanner sc = new Scanner(System.in);
        String archivo = sc.nextLine();
        System.out.println("\"\"".substring(1, "\"\"".length()-1));
        File f = new File("out/"+archivo+"_tokens");
        try {
            FileWriter fw = new FileWriter(f);
            AnalizadorLexico al = new AnalizadorLexico("src/main/resources/" + archivo, fw);
        System.out.println("Analizando:");
        al.analiza();
        System.out.println("\nFin");
        fw.flush();
        fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
}
