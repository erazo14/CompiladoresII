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
public class Funcion extends Metodo{
	public Funcion(String id, Integer linea, Integer columna, Integer offset, String tipo) {
		super(id, linea, columna, offset, tipo);
	}
	
	public Funcion(String id, Integer linea, Integer columna, Integer offset, String tipo, String lugar) {
		super(id, linea, columna, offset, tipo, lugar);
	}
}
