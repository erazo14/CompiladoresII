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
public class Scope {
	public Scope padre;
	public String nombre;
	public Integer linea;
	public Integer columna;
	public Integer offset;
	public ArrayList<Variable> variables;
	public ArrayList<Funcion> funciones;
	public ArrayList<Sub> subs;
	public ArrayList<TypeStruct> typeStructs;
	private final ArrayList<String> primitiveTypes;
	
	public Scope(Scope padre, String nombre, Integer linea, Integer columna, Integer offset){
		this.padre = padre;
		this.nombre = nombre;
		this.linea = linea;
		this.columna = columna;
		this.offset = offset;
		this.variables = new ArrayList<>();
		this.funciones = new ArrayList<>();
		this.subs = new ArrayList<>();
		this.typeStructs = new ArrayList<>();
		this.primitiveTypes = new ArrayList<>();
		this.primitiveTypes.add("integer");
		this.primitiveTypes.add("string");
		this.primitiveTypes.add("char");
		this.primitiveTypes.add("boolean");
	}
	
	public boolean hasVar(String id){
		for (Variable v:this.variables){
			if (v.id.equalsIgnoreCase(id)){
				return true;
			}
		}
		
		if (this.padre == null){
			return false;
		}else{
			return this.padre.hasVar(id);
		}
	}
	// buscar
        
	public Variable findVar(String id){
		for (Variable v:this.variables){
			if (v.id.equalsIgnoreCase(id)){
				return v;
			}
		}
		
		if (this.padre == null){
			return null;
		}else{
			return this.padre.findVar(id);
		}
	}
	
	public boolean hasLocalVar(String id){
		for (Variable v:this.variables){
			if (v.id.equalsIgnoreCase(id)){
				return true;
			}
		}
		
		return false;
	}
	
	public Variable findLocalVar(String id){
		for (Variable v:this.variables){
			if (v.id.equalsIgnoreCase(id)){
				return v;
			}
		}
		
		return null;
	}
	
	public void addVar(Variable var){
		this.variables.add(var);
	}
	
	public boolean hasFunc(String id){
		for (Funcion f:this.funciones){
			if (f.id.equalsIgnoreCase(id)){
				return true;
			}
		}
		
		if (this.padre == null){
			return false;
		}else{
			return this.padre.hasFunc(id);
		}
	}
	
	public Funcion findFunc(String id){
		for (Funcion f:this.funciones){
			if (f.id.equalsIgnoreCase(id)){
				return f;
			}
		}
		
		if (this.padre == null){
			return null;
		}else{
			return this.padre.findFunc(id);
		}
	}
        
	
	public void addFunc(Funcion func){
		this.funciones.add(func);
	}
	
	public boolean hasSub(String id){
		for (Sub s:this.subs){
			if (s.id.equalsIgnoreCase(id)){
				return true;
			}
		}
		
		if (this.padre == null){
			return false;
		}else{
			return this.padre.hasSub(id);
		}
	}
	
	public void addSub(Sub sub){
		this.subs.add(sub);
	}
	
	public boolean hasTypeStruct(String id){
		for (TypeStruct t:this.typeStructs){
			if (t.id.equalsIgnoreCase(id)){
				return true;
			}
		}
		
		if (this.padre == null){
			return false;
		}else{
			return this.padre.hasTypeStruct(id);
		}
	}
	
	public TypeStruct findTypeStruct(String id){
		for (TypeStruct t:this.typeStructs){
			if (t.id.equalsIgnoreCase(id)){
				return t;
			}
		}
		
		if (this.padre == null){
			return null;
		}else{
			return this.padre.findTypeStruct(id);
		}
	}
	
	public void addTypeStruct(TypeStruct t){
		this.typeStructs.add(t);
	}
	
	public boolean hasType(String id){
		for(String t:this.primitiveTypes){
			if (t.equalsIgnoreCase(id)){
				return true;
			}
		}
		
		for (TypeStruct t:this.typeStructs){
			if (t.id.equalsIgnoreCase(id)){
				return true;
			}
		}
		
		if (this.padre == null){
			return false;
		}else{
			return this.padre.hasTypeStruct(id);
		}
	}
	
	public String ubicacion(){
		return "lin " + this.linea + ", col " + this.columna + ", offset " + this.offset;
	}
        
        
	@Override
	public String toString(){
		String out = "";
		
		out += "***** Ambito \"" + this.nombre + "\" *****\n";
		out += "* Comienzo: " + this.ubicacion() + "\n";
		out += "* Ambito padre: " + (this.padre != null ? this.padre.nombre + "(" + this.padre.ubicacion() + ")" : " null (no tiene padre) ") + "\n";
		out += "* Variables:\n";
		
		for (Variable v:this.variables){
			out += "*\t\"" + v.id + "\", " + v.tipo;
			if (v.linea != null){
				out += ", lin " + v.linea;
			}
			
			if (v.columna != null){
				out += ", col " + v.columna;
			}
			
			if (v.offset != null){
				out += ", offset " + v.offset;
			}
			out += "\n";
		}
		
		out += "* Subrutinas:\n";
		
		for (Sub s:this.subs){
			out += "*\t\"" + s.id + "\", " + s.tipo;
			if (s.linea != null){
				out += ", lin " + s.linea;
			}
			
			if (s.columna != null){
				out += ", col " + s.columna;
			}
			
			if (s.offset != null){
				out += ", offset " + s.offset;
			}
			out += "\n";
			
			out += "*\tParametros:\n";
			
			for (Parametro p:s.parametros){
				out += "*\t\t\"" + p.id + "\", " + p.passMech + ", " + p.tipo + "\n";
			}
		}
		
		out += "* Funciones:\n";
		
		for (Funcion f:this.funciones){
			out += "*\t\"" + f.id + "\", " + f.tipo;
			if (f.linea != null){
				out += ", lin " + f.linea;
			}
			
			if (f.columna != null){
				out += ", col " + f.columna;
			}
			
			if (f.offset != null){
				out += ", offset " + f.offset;
			}
			out += "\n";
			
			out += "*\tParametros:\n";
			
			for (Parametro p:f.parametros){
				out += "*\t\t\"" + p.id + "\", " + p.passMech + ", " + p.tipo + "\n";
			}
		}
		
		out += "* Types:\n";
		
		for (TypeStruct t:this.typeStructs){
			out += "*\t\"" + t.id + "\", " + t.tipo;
			if (t.linea != null){
				out += ", lin " + t.linea;
			}
			
			if (t.columna != null){
				out += ", col " + t.columna;
			}
			
			if (t.offset != null){
				out += ", offset " + t.offset;
			}
			out += "\n";
			
			out += "*\tVariables (Propiedades):\n";
			
			for (Variable v:t.variables){
				out += "*\t\t\"" + v.id + "\", " + v.tipo + "\n";
			}
		}
		
		out += "\n";
		
		return out;
	}
}
