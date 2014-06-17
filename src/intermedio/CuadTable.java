/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intermedio;

import java.util.ArrayList;
import java.util.Stack;
import symtable.Scope;
import symtable.Simbolo;
import symtable.SymTable;

/**
 *
 * @author Armando
 */
public final class CuadTable {
	public static ArrayList<Cuadruplo> cuadruplos = new ArrayList<>();
	public static Integer sigCuad = 0;
	private static Integer tempSequence = 1;
        private static Integer etiqSequence = 1;
        SymTable Tabla;
        Cuadruplo cuad;
        Simbolo SimboloActual;
      //  CuadTable Cuadruplos1;
      //  Scope AmbitoActual;
        ArrayList<Texto> mensajes;
        Lista_Temporales temporales;
        //CuadTable tempo; // maneja la lista de los temporales
        int cont_copia_string;
        Stack<ArrayList<String>> tempActivas;
        ArrayList<String> escribe;
    
	public CuadTable(SymTable Tabla, /*CuadTable Cuadruplos,*/ ArrayList<Texto> mensajes) {
        this.Tabla = Tabla;
      //  this.Cuadruplos1 = Cuadruplos1;
        //this.AmbitoActual = SymTable.rootScope; //las clases estan static por eso no puedo depender de ellas
        this.mensajes = mensajes;
        this.temporales = new Lista_Temporales();
        this.cont_copia_string = 0;
        this.tempActivas = new Stack();
        this.escribe = new ArrayList();
    		
	}
	
	public static String newTemp(){
		return "t" + CuadTable.tempSequence++;
	}
        
        public static String newetiq(){
		return "_etiq" + CuadTable.etiqSequence++;
	}
	
	public static void init(){
		CuadTable.cuadruplos.clear();
		CuadTable.tempSequence = 1;
                CuadTable.etiqSequence = 1;
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
                        Cuadruplo nuevo = CuadTable.cuadruplos.get((int) lista.get(i)) ;
			System.out.println("patching line " + lista.get(i) + " with " + cuad);
			System.out.println("line " + lista.get(i) + ": " + nuevo.toString());
			nuevo.dest = cuad;
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
                        case "if>":
				CuadTable.cuadruplos.add(new Cuadruplo("if>", args[0], args[1], args[2]));
				break;
                        case "if<=":
				CuadTable.cuadruplos.add(new Cuadruplo("if<=", args[0], args[1], args[2]));
				break;
                        case "if>=":
				CuadTable.cuadruplos.add(new Cuadruplo("if>=", args[0], args[1], args[2]));
				break;
			case "if=":
				CuadTable.cuadruplos.add(new Cuadruplo("if=", args[0], args[1], args[2]));
				break;
			case "if":
				CuadTable.cuadruplos.add(new Cuadruplo("if", args[0], args[1]));
				break;
                        case "_etiq":
				CuadTable.cuadruplos.add(new Cuadruplo(newetiq()));
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
        
        public void FinalCode(){
        escribe.add(".data");
       // escribe.add("_true: .asciiz \"TRUE\" ");
      // escribe.add("_false: .asciiz \"FALSE\" ");
        for (Texto texto : mensajes) {
            if(texto.texto.startsWith("'")){
                texto.texto = texto.texto.replaceAll("'", "\"");
            }
            escribe.add(texto.nombre+": .asciiz "+texto.texto);
        }
        escribe.add(".text");
        escribe.add(".globl main");
        int tipo;
        int dir = 0;
        int t;
        String temp1;
        String temp2;
        String temp3;
        Scope s;
           
           for (int i = 0; i < CuadTable.cuadruplos.size(); i++){
			switch(cuad.operator){
                        
                            
                        }
		}  
    }

}
