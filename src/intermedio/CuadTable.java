/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intermedio;

import java.util.ArrayList;

/**
 *
 * @author Armando
 */
public  final class CuadTable {
	public static ArrayList<Cuadruplo> cuadruplos = new ArrayList<>();
        public static ArrayList<Integer> list;
        public CuadTable tabla;
	private static Integer tempSequence = 0;
        
        public CuadTable(CuadTable tabla){
            this.list = new ArrayList();
            this.tabla = tabla;
        }
        
        public CuadTable(Integer tempSequence, CuadTable tabla){
            this.list = new ArrayList();
            list.add(tempSequence);
            this.tabla = tabla;
        }
        
        public CuadTable(){
            this.list = new ArrayList();
            this.tabla = null;
        }
        
        public void Add_Cuad(Cuadruplo cuad){
            cuadruplos.add(cuad);
        }
        
        
        public ArrayList<Cuadruplo> get_cuadruplos(){
        return cuadruplos;
        }
        
        public Cuadruplo get_cuadruplo(int index){
        return cuadruplos.get(index);
         }
        
        public void set_resultado(int index, String etiqueta){
        this.cuadruplos.get(index).dest = etiqueta;
        }
	public static String newTemp(){
		return "temp" + CuadTable.tempSequence++;
	}
	
	public static void init(){
		CuadTable.cuadruplos.clear();
		CuadTable.tempSequence = 0;
	}
        
        public static void CreaLista(Integer posicion){
            
        }
        
        public static CuadTable FucionaLista(CuadTable lista1, CuadTable lista2){
            CuadTable nuevalista = new CuadTable(lista1.tabla);
            nuevalista.list.addAll(lista1.list);
            nuevalista.list.addAll(lista2.list);
            return nuevalista;
        }
        
        public static void Completa(CuadTable lista1, String etiqueta){
            if(lista1.list != null ){
            for (Integer index : lista1.list) {
                lista1.tabla.set_resultado(index.intValue(),etiqueta);
                }
             }
         }
              
        public void imprimir_Tabla(){
        for (Cuadruplo quad : cuadruplos) {
            System.out.print(quad.operator + "\t");
            if(quad.operand1!=null){
                System.out.print(quad.operand1);
            }
            System.out.print("\t");
            if(quad.operand2!=null)     
                System.out.print(quad.operand2);
            System.out.print("\t");
            System.out.println(quad.dest);
        }
    }
        
	public static void gen(String operador, String...args){
		operador = operador.toLowerCase();
		
		switch(operador){
			case "+":
                                
			case "-":
                                
			case "*":
                                
			case "/":
				CuadTable.cuadruplos.add(new Cuadruplo(operador, args[0], args[1], args[2]));
				break;
			case "=":
				CuadTable.cuadruplos.add(new Cuadruplo(operador, args[0], args[1]));
				break;
			case "goto":
				CuadTable.cuadruplos.add(new Cuadruplo("goto", args[0]));
				break;
			default:				
				break;
		}
	}
        
        
}
