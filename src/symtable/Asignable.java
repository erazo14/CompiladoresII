/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package symtable;

/**
 *
 * @author Armando
 */
public class Asignable extends Simbolo{
	public String varOrProp;
	
	public Asignable(String id, Integer linea, Integer columna, Integer offset, String tipo, String varOrProp) {
		super(id, linea, columna, offset, tipo);
		this.varOrProp = varOrProp;
	}
	
	public Asignable(String id, Integer linea, Integer columna, Integer offset, String tipo, String varOrProp, String lugar) {
		super(id, linea, columna, offset, tipo, lugar);
		this.varOrProp = varOrProp;
	}
}
