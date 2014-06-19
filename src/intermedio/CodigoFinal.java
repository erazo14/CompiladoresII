/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intermedio;

import java.util.ArrayList;
import java.util.Stack;
import symtable.Scope;
import symtable.Simbolo;
import symtable.SymTable;

/**
 *
 * @author usuario
 */
public class CodigoFinal {
        //public static ArrayList<Cuadruplo> cuadruplos = new ArrayList<>();
        static SymTable Tabla;
        //static Cuadruplo cuad;
        //Simbolo SimboloActual;
        static Lista_Temporales t = new Lista_Temporales();
      //  CuadTable Cuadruplos1;
        static Scope SimboloActual;
        static ArrayList<Texto> mensajes;
        static Lista_Temporales temporales;
        //CuadTable tempo; // maneja la lista de los temporales
        static int cont_copia_string;
        static Stack<ArrayList<String>> TempActivas;
        static ArrayList<String> escribe;
        
        public CodigoFinal(SymTable Tabla, /*CuadTable Cuadruplos,*/ ArrayList<Texto> mensajes) {
        this.Tabla = Tabla;
      //  this.Cuadruplos1 = Cuadruplos1;
        //this.AmbitoActual = SymTable.rootScope; //las clases estan static por eso no puedo depender de ellas
        this.mensajes = mensajes;
        this.temporales = new Lista_Temporales();
        this.cont_copia_string = 0;
        this.TempActivas = new Stack();
        this.escribe = new ArrayList();
    		
	}
        
           public static ArrayList<String> FinalCode(){
              
               escribe = new ArrayList();
               mensajes = new ArrayList();
        escribe.add(".data");
       escribe.add("_true: .asciiz \"True\" ");
       escribe.add("_false: .asciiz \"False\" ");
        for (Texto texto : mensajes) {
            if(texto.texto.startsWith("'")){
                texto.texto = texto.texto.replaceAll("'", "\"");
            }
            escribe.add(texto.nombre+": .asciiz "+texto.texto);
        }
        escribe.add(".text");
        escribe.add(".globl main");
        int tipo = 0;
        int dir = 0;
        int t;
        String temp1;
        String temp2;
        String temp3;
        Scope s;
        
         for (int i = 0; i < CuadTable.cuadruplos.size(); i++){
             System.out.println(i+"...."+CuadTable.cuadruplos.get(i).operator);
			switch(CuadTable.cuadruplos.get(i).operator){
                        case "+":
                            //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                escribe.add("add" + CuadTable.cuadruplos.get(i).dest + "," + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2 );
                                tipo = Tipo.Int;
                                //}
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);
                                //temporales.TemporalenUso(CuadTable.cuadruplos.get(i).dest, tipo);
                                break;
			case "-":
                            //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                escribe.add("sub" + CuadTable.cuadruplos.get(i).dest + "," + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2);
                                tipo = Tipo.Int;
                                //}
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);
                                //temporales.TemporalenUso(CuadTable.cuadruplos.get(i).dest, tipo);
                                
                                break;
			case "*":
                            //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                escribe.add("mul" + CuadTable.cuadruplos.get(i).dest + "," + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2);
                                tipo = Tipo.Int;
//                                }
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);
                                //temporales.TemporalenUso(CuadTable.cuadruplos.get(i).dest, tipo);
                                break;
			case "/":
                            //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                escribe.add("div" + CuadTable.cuadruplos.get(i).dest + "," + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2);
				tipo = Tipo.Int;
  //                              }
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);
                                //temporales.TemporalenUso(CuadTable.cuadruplos.get(i).dest, tipo);
                                break;
                        case "Not":
                            //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                escribe.add("Neg" + CuadTable.cuadruplos.get(i).dest + "," + CuadTable.cuadruplos.get(i).operand1); 
                                tipo = Tipo.Int;
  //                              }
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalenUso(CuadTable.cuadruplos.get(i).dest, tipo);
                                break;
                        case "=":
                                // creo que es medio fumado, ya que tiene que ver que es lo que iguala, nose si estoy equivada
                                break;
                        case "goto": 
                            String hola =CuadTable.cuadruplos.get(i).dest;
                            int juan =Integer.parseInt(hola);
                            System.out.println(juan);
                            System.out.println("rrrrrrrrrrrrrrrrrr"+CuadTable.cuadruplos.get().operator);
//                                 escribe.add("b "+ CuadTable.cuadruplos.get(Integer.parseInt(CuadTable.cuadruplos.get(i).dest)).operator);
                                 break;
                        case "if<":
                                //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                    escribe.add("blt" + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2 + "," + CuadTable.cuadruplos.get(i).dest);
  //                              }
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);
                                break;
                        case "if>":
                                 //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                    escribe.add("bgt" + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2 + "," + CuadTable.cuadruplos.get(i).dest);
  //                              }
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);
                                break;
                        case "if<=":
                                //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                    escribe.add("ble" + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2 + "," + CuadTable.cuadruplos.get(i).dest);
  //                              }
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);
                                break;
                        case "if>=":
                                //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                    escribe.add("bge" + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2 + "," + CuadTable.cuadruplos.get(i).dest);
  //                              }
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);
                                break;
                        case "if=":
                            //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                escribe.add("beq" + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2);
  //                              }else{
  //                                  if(CuadTable.cuadruplos.get(i).operand2.equalsIgnoreCase("true")){
  //                                      escribe.add("beq" + CuadTable.cuadruplos.get(i).operand1 + ", 1 ," + CuadTable.cuadruplos.get(i).dest);
  //                                              }else{
  //                                                  escribe.add("beq" + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2 + "," + CuadTable.cuadruplos.get(i).dest);
  //                                  }
  //                          }
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);                  
                                break;
                        case "if": //nose cual usar aqui
                            //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                escribe.add("b" + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).dest);
 //                               }
                                    //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                    //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).dest);
                                break;
                        case "if<>":
                                //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                    escribe.add("bne" + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2 + "," + CuadTable.cuadruplos.get(i).dest);
  //                              }
                                    //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                    //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);
                                break;
                        case "_etiq": //dentro del default
                                
                                break;
                        case "Call":         /*                  
                          //      s = SimboloActual.findVar(cuad.dest); // esta cosa me esta cayendo mal
                                escribe.add("jal nombredelafuncion" + s.nombre);
                                 if(!TempActivas.empty()){
                                     ArrayList<String> temps = this.TempActivas.pop();
                                     for (String temporales : temps) {
                                        if(this.istempf(temporales)){
                                         escribe.add("l.s "+temporales+" , ($sp)" );
                                 }else{
                                     escribe.add("lw "+temporales+" , ($sp)" );
                                 }
                                    escribe.add("add $sp , $sp , 4");
                                    }
                                }    */                                                                                 
                    break;
                        }
		}
         return escribe;
    }
	
    public boolean istemp(String s){
        if(s.startsWith("$t")){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean istempf(String s){ 
        if(s.startsWith("$f")){
            return true;
        }else{
            return false;
        }
    }
    
     public static boolean istemps(String s){
        if(s.startsWith("$s")){
            return true;
        }else{
            return false;
        }        
    }
    public static boolean isint(String s){
        try{
            Integer.parseInt(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    
    public static boolean iscadena(String s){
        if(s.startsWith("_msg")){
            return true;
        }
        return false;
    }
    public static boolean isid(String s){
        if(SimboloActual.findVar(s)!=null){
            return true;
        }else{
            
            return false;
        }
    }
    
    
}