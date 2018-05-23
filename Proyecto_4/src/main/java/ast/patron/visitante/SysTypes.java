/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.visitante;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa la definición del sistema de tipos para los operadores
 * de p
 * @author ulises
 */
public class SysTypes {
    
    private static String BOOL = "Booleano";
    private static String ENT = "Entero";
    private static String RL = "Real";
    private static String CAD = "Cadena";
    /**
     * Calcula si los tipos dados  son válidos en el sistema definido
     * @param type1 tipo de entrada 1
     * @param type2 tipo de entrada 2
     * @return el tipo correspondiente o un error
     */
    public String checkSuma(String type1, String type2) throws TypesException{
        if (type1.equals(BOOL) || type2.equals(BOOL)){ // No hay + de bools
            throw new TypesException("SUMA", type1, type2);
        }else if (type1.equals(CAD) && type2.equals(CAD)){  // Solo se pueden concatenar cadenas con cadenas
            return CAD;
        }else if( type1.equals(RL) || type2.equals(RL)){  // Si al menos uno es Real, entonces el resultado es real
            return RL;
        }else{  // solo quedan enteros
            return ENT;
        }
    }
    
    
    public String chechMult(String t1, String t2) throws TypesException{
        return null;
    }
}
