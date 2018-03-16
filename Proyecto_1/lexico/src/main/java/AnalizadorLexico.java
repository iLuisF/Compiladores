
import com.kaab.compiladores.lexico.Flexer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;


public class AnalizadorLexico {
    Flexer lexer;
    
    public AnalizadorLexico(String archivo, FileWriter f) throws IOException{
        try {
            Reader lector = new FileReader(archivo);
            lexer = new Flexer(lector);
            lexer.fw = f;
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage() + " No se encontró el archivo;");
        }
    }

    public void analiza(){
        try{
            lexer.pila.push(0);
            lexer.yylex();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}