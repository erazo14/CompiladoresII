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
public class TypeStruct extends Simbolo{
	public ArrayList<Variable> variables;
	
	public TypeStruct(String id, Integer linea, Integer columna, Integer offset) {
		super(id, linea, columna, offset, "void");
		this.variables = new ArrayList<>();
	}
	
	public TypeStruct(String id, Integer linea, Integer columna, Integer offset, ArrayList<Variable> variables) {
		super(id, linea, columna, offset, "void");
		this.variables = variables;
	}
	
	public boolean hasVar(String id){
		for (Variable v:this.variables){
			if (v.id.equals(id)){
				return true;
			}
		}
		
		return false;
	}
	
	public Variable findVar(String id){
		for (Variable v:this.variables){
			if (v.id.equals(id)){
				return v;
			}
		}
		
		return null;
	}
	
	public void addVar(Variable var){
		this.variables.add(var);
	}
}
