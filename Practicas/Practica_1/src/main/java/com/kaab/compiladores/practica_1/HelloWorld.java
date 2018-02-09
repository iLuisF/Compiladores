package com.kaab.compiladores.practica_1;

import java.io.*;

public class HelloWorld {

    public static void main(String args[]){
        try {
            Reader reader = new FileReader("src/main/resources/test.txt");
            Yylex y = new Yylex(reader);
            y.yylex();
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage() + " No se encontró el archivo;");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
