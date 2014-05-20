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
public class Metodo extends Simbolo{
	public ArrayList<Parametro> parametros;
	
	public Metodo(String id, Integer linea, Integer columna, Integer offset, String tipo) {
		super(id, linea, columna, offset, tipo);
		this.parametros = new ArrayList<>();
	}
	
	public boolean hasParam(String id){
		for (Parametro p:this.parametros){
			if (p.id.equalsIgnoreCase(id)){
				return true;
			}
		}
		
		return false;
	}
	
	public Parametro findParam(String id){
		for (Parametro p:this.parametros){
			if (p.id.equalsIgnoreCase(id)){
				return p;
			}
		}
		
		return null;
	}
	
	public void addParam(Parametro var){
		this.parametros.add(var);
	}
}
