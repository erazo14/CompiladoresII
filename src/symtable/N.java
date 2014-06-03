/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package symtable;

import intermedio.CuadTable;
import java.util.ArrayList;

/**
 *
 * @author Armando
 */
public class N {
	public ArrayList<Integer> lista;
	
	public N(Integer sigCuad){
		this.lista = CuadTable.makeList(sigCuad);
	}
}
