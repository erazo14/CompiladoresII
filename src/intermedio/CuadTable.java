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
	public static Integer sigCuad = 0;
	private static Integer tempSequence = 1;
	
	public CuadTable(){
		//algo
	}
	
	public static String newTemp(){
		return "t" + CuadTable.tempSequence++;
	}
	
	public static void init(){
		CuadTable.cuadruplos.clear();
		CuadTable.tempSequence = 1;
		CuadTable.sigCuad = 0;
	}
	
	public static ArrayList<Integer> makeList(Integer i){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(new Integer(i.intValue()));
		return list;
	}
	
	public static ArrayList<Integer> merge(ArrayList list1, ArrayList list2){
		return null;
	}
	
	public static void backpatch(ArrayList lista, Object cuad){
		CuadTable.backpatch(lista, cuad.toString());
	}
	
	public static void backpatch(ArrayList lista, String cuad){
		for (int i = 0; i < lista.size(); i++){
			System.out.println("patching line " + lista.get(i) + " with " + cuad);
			System.out.println("line " + lista.get(i) + ": " + CuadTable.cuadruplos.get(i).toString());
			CuadTable.cuadruplos.get(i).dest = cuad;
		}
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
			case "if<":
				CuadTable.cuadruplos.add(new Cuadruplo("if<", args[0], args[1], args[2]));
				break;
			case "if=":
				CuadTable.cuadruplos.add(new Cuadruplo("if=", args[0], args[1], args[2]));
				break;
			case "if":
				CuadTable.cuadruplos.add(new Cuadruplo("if", args[0], args[1]));
				break;
			default:	
				break;
		}
		
		CuadTable.sigCuad++;
	}
	
	
	public static String getCodigo(){
		String buffer = "";
		
		for (int i = 0; i < CuadTable.cuadruplos.size(); i++){
			buffer += String.format("%04d", i) + ":\t" + CuadTable.cuadruplos.get(i).toString() + "\n";
		}
		
		return buffer;
	}
}
