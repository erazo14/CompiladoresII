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
public class Parametro {
	public String passMech;
	public String id;
	public String tipo;
	
	public Parametro(String passMech, String id, String tipo){
		this.passMech = passMech;
		this.id = id;
		this.tipo = tipo;
	}
}
