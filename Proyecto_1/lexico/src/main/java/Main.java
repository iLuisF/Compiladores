
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        analizarErrorInicio("src/main/resources/", archivo);
        al.analiza();
        System.out.println("\nFin");
        fw.flush();
        fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    /**
     * Solo marca error en caso de haberlo, si no lo hay, no marca mensaje de
     * exito.
     *
     * @param archivo
     */
    public static void analizarErrorInicio(String ruta, String archivo) throws FileNotFoundException {
        Scanner leer = new Scanner(new File(ruta + archivo));
        String primerLinea = "";
        int numLinea = 1;
        while (leer.hasNextLine()) {
            System.out.println(primerLinea);
            primerLinea = leer.nextLine();
            if (!primerLinea.isEmpty()) {
                break;
            }
            numLinea++;
        }
        String primerCaracter = primerLinea.substring(0, 1);
        if (primerCaracter.equals(" ")) {
            File f = new File("out/" + archivo + "_tokens");
            FileWriter w = null;
            try {
                w = new FileWriter(f);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("Error de indentación. Línea " + numLinea + ".");
            wr.close();
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Error de indentación. Línea " + numLinea + ".");
            System.exit(0);
        }
    }
}
