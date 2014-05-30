/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intermedio;

import java.util.ArrayList;

/**
 *
 * @author Armando
 */
public final class CuadTable {
	public static ArrayList<Cuadruplo> cuadruplos = new ArrayList<>();
	private static Integer tempSequence = 0;
	
	public CuadTable(){
		//algo
	}
	
	public static String newTemp(){
		return "temp" + CuadTable.tempSequence++;
	}
	
	public static void init(){
		CuadTable.cuadruplos.clear();
		CuadTable.tempSequence = 0;
	}
        
        public static void CreaLista(Integer posicion){
            
        }
        
        public static void FucionaLista(String[] lista1, String[] lista2){
            
        }
        
        public static void Completa(String[] lista, Integer Posicion){
            
        }
	
	public static void gen(String operador, String...args){
		operador = operador.toLowerCase();
		
		switch(operador){
			case "+": 
			case "-":
			case "*":
			case "/":
				CuadTable.cuadruplos.add(new Cuadruplo(operador, args[0], args[1], args[2]));
				break;
			case "=":
				CuadTable.cuadruplos.add(new Cuadruplo(operador, args[0], args[1]));
				break;
			case "goto":
				CuadTable.cuadruplos.add(new Cuadruplo("goto", args[0]));
				break;
			default:				
				break;
		}
	}
}
