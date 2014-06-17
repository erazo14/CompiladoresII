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
public class Simbolo {
	public String id;
	public Integer linea;
	public Integer columna;
	public Integer offset;
	public String tipo;
	public String lugar;
	public ArrayList<Integer> lstVerd;
	public ArrayList<Integer> lstFals;
	public ArrayList<Integer> lstSig;
	
	public Simbolo(String id, Integer linea, Integer columna, Integer offset, String tipo) {
		this.id = id;
		this.linea = linea;
		this.columna = columna;
		this.offset = offset;
		this.tipo = tipo;
		this.lugar = null;
		this.lstVerd = new ArrayList<>();
		this.lstFals = new ArrayList<>();
		this.lstSig = new ArrayList<>();
	}
	
	public Simbolo(String id, Integer linea, Integer columna, Integer offset, String tipo, String lugar) {
		this.id = id;
		this.linea = linea;
		this.columna = columna;
		this.offset = offset;
		this.tipo = tipo;
		this.lugar = lugar;
		this.lstVerd = new ArrayList<>();
		this.lstFals = new ArrayList<>();
		this.lstSig = new ArrayList<>();
	}
}   
