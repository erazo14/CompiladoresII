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
public class Funcion extends Simbolo{
	public ArrayList<Parametro> parametros;
	
	public Funcion(String id, Integer linea, Integer columna, Integer offset, String tipo, ArrayList<Parametro> parametros) {
		super(id, linea, columna, offset, tipo);
		this.parametros = parametros;
	}
}
