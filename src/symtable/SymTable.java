/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package symtable;

import java.util.ArrayList;

/**
 *
 * @author Armando
 */
public  class SymTable {
	public static Scope rootScope;
	public static Scope curScope;
	public static TypeStruct curTypeStruct;
	public static Metodo curMethod;
	public static Boolean existeMain;
	public static Integer blockCounter;
	public static Property curProp;
	private static ArrayList<Scope> scopes = new ArrayList<>();
	
	private SymTable(){
	}
	
	public static void init(){
		SymTable.scopes = new ArrayList<>();
		SymTable.rootScope = SymTable.createScope(null, "root", 0, 0, 0);
		SymTable.curScope = rootScope;
		SymTable.curTypeStruct = null;
		SymTable.curMethod = null;
		SymTable.curProp = null;
		SymTable.existeMain = false;
		SymTable.blockCounter = 1;
	}
	
	public static Scope getCurScope(){
		return SymTable.curScope;
	}
	
	public static Scope createScope(Scope padre, String nombre, Integer linea, Integer columna, Integer offset){
		Scope s = new Scope(padre, nombre, linea, columna, offset);
		SymTable.scopes.add(s);
		return s;
	}
	
	public static ArrayList<Scope> allScopes(){
		return SymTable.scopes;
	}
	
	public static Scope createSubScope(String nombre, Integer linea, Integer columna, Integer offset){
		Scope s = SymTable.createScope(SymTable.curScope, nombre, linea, columna, offset);
		SymTable.curScope = s;
		return s;
	}
	
	public static void endScope(){
		SymTable.curScope = SymTable.curScope.padre;
	}
	
	public static String blockName(){
		return "Block " + SymTable.blockCounter++;
	}
	
	public static boolean isPrimitive(String tipo){
		return tipo.equalsIgnoreCase("integer") || tipo.equalsIgnoreCase("string") || tipo.equalsIgnoreCase("char") || tipo.equalsIgnoreCase("boolean");
	}
	
	public static void print(){
	}
}
