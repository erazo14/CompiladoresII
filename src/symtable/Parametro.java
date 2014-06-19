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
public class Parametro extends Simbolo{
	public String passMech;
        /*
        public int Tipo;
        private String id1;
        private boolean porReferencia;
    */
	
	public Parametro(String passMech, String id, Integer linea, Integer columna, Integer offset, String tipo) {
		super(id, linea, columna, offset, tipo);
		this.passMech = passMech;
	}
	
	public Parametro(String passMech, String id, Integer linea, Integer columna, Integer offset, String tipo, String lugar) {
		super(id, linea, columna, offset, tipo, lugar);
		this.passMech = passMech;
	}      
}
