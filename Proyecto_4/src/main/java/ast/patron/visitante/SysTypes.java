/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast.patron.visitante;


/**
 * Clase que representa la definición del sistema de tipos para los operadores
 * de p
 * @author ulises
 */
public class SysTypes {
    
    private static final int BOOL = 0;
    private static final int ENT = 1;
    private static final int RL = 2;
    private static final int CAD = 3;
    /**
     * Calcula si los tipos dados  son válidos en el sistema definido
     * @param type1 tipo de entrada 1
     * @param type2 tipo de entrada 2
     * @return el tipo correspondiente o un error
     * @throws ast.patron.visitante.TypesException
     */
    public static int checkSuma(int type1, int type2) throws TypesException{
        if (type1 == BOOL || type2 == BOOL){ // No hay + de bools
            throw new TypesException("SUMA", type1, type2);
        }else if (type1 == CAD && type2 == CAD){  // Solo se pueden concatenar cadenas con cadenas
            return CAD;
        }else if( type1 == RL || type2 == RL){  // Si al menos uno es Real, entonces el resultado es real
            return RL;
        }else{  // solo quedan enteros
            return ENT;
        }
    }
    
    
    public static int checkMult(int t1, int t2) throws TypesException{
        if (t1 == BOOL || t2 == BOOL){ // No hay * de bools
            throw new TypesException("MULTIPLICACION", t1, t2);
        }else if ( t1 == CAD || t2 == CAD){  // No hay * de CADs
            throw new TypesException("MULTIPLICACION", t1, t2);
        }else if (t1 == RL || t2 == RL){  // Basta un Real para que el tipo sea real
            return RL;
        }else{
            return ENT;
        }
    }
    
    /*
    * Diseñado para >, <, >=, <=
    */
    public static int checkCompNumOp(String opName, int t1, int t2) throws TypesException{
        if (t1 == BOOL || t2 == BOOL){
            throw new TypesException(opName, t1, t2);
        }else if (t1 == CAD || t2 == CAD){
            throw new TypesException(opName, t1, t2);
        }else{
            // Se puede hacer comparaciones entre reales y enteros indistintamente
            return BOOL;
        }
    }
    
    public static int checkOpLogica(String op, int t1, int t2)throws TypesException{
        if (t1 != BOOL || t2 != BOOL){
            throw new TypesException(op, t1, t2);
        }else{  // Ambos tipos son BOOLEANOS
            return BOOL;
        }
    }
    
    public static int checkModulo(int t1, int t2) throws TypesException{
        if (t1 == BOOL || t2 == BOOL || t1 == CAD || t2 == CAD || t1 == RL || t2 == RL){  // NO hay % de bools
            throw new TypesException("MÓDULO", t1, t2);
        }else{
            return ENT;
        }
    }
}