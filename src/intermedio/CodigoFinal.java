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
        public static ArrayList<Cuadruplo> cuadruplos = new ArrayList<>();
        SymTable Tabla;
        Cuadruplo cuad;
        //Simbolo SimboloActual;
        Lista_Temporales t = new Lista_Temporales();
      //  CuadTable Cuadruplos1;
        Scope SimboloActual;
        ArrayList<Texto> mensajes;
        Lista_Temporales temporales;
        //CuadTable tempo; // maneja la lista de los temporales
        int cont_copia_string;
        Stack<ArrayList<String>> tempActivas;
        ArrayList<String> escribe;
        
        public CodigoFinal(SymTable Tabla, /*CuadTable Cuadruplos,*/ ArrayList<Texto> mensajes) {
        this.Tabla = Tabla;
      //  this.Cuadruplos1 = Cuadruplos1;
        //this.AmbitoActual = SymTable.rootScope; //las clases estan static por eso no puedo depender de ellas
        this.mensajes = mensajes;
        this.temporales = new Lista_Temporales();
        this.cont_copia_string = 0;
        this.tempActivas = new Stack();
        this.escribe = new ArrayList();
    		
	}
        
           public void FinalCode(){
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
			switch(cuad.operator){
                        case "+":
                            if(istempf(cuad.operand1)){
                                escribe.add("add" + cuad.dest + "," + cuad.operand1 + "," + cuad.operand2 );
                                tipo = Tipo.Int;
                                }
                                temporales.TemporalLibre(cuad.operand1);
                                temporales.TemporalLibre(cuad.operand2);
                                temporales.TemporalenUso(cuad.dest, tipo);
                                break;
			case "-":
                            if(istempf(cuad.operand1)){
                                escribe.add("sub" + cuad.dest + "," + cuad.operand1 + "," + cuad.operand2);
                                tipo = Tipo.Int;
                                }
                                temporales.TemporalLibre(cuad.operand1);
                                temporales.TemporalLibre(cuad.operand2);
                                temporales.TemporalenUso(cuad.dest, tipo);
                                
                                break;
			case "*":
                            if(istempf(cuad.operand1)){
                                escribe.add("mul" + cuad.dest + "," + cuad.operand1 + "," + cuad.operand2);
                                tipo = Tipo.Int;
                                }
                                temporales.TemporalLibre(cuad.operand1);
                                temporales.TemporalLibre(cuad.operand2);
                                temporales.TemporalenUso(cuad.dest, tipo);
                                break;
			case "/":
                            if(istempf(cuad.operand1)){
                                escribe.add("div" + cuad.dest + "," + cuad.operand1 + "," + cuad.operand2);
				tipo = Tipo.Int;
                                }
                                temporales.TemporalLibre(cuad.operand1);
                                temporales.TemporalLibre(cuad.operand2);
                                temporales.TemporalenUso(cuad.dest, tipo);
                                break;
                        case "Not":
                            if(istempf(cuad.operand1)){
                                escribe.add("Neg" + cuad.dest + "," + cuad.operand1); 
                                tipo = Tipo.Int;
                                }
                                temporales.TemporalLibre(cuad.operand1);
                                temporales.TemporalenUso(cuad.dest, tipo);
                                break;
                        case "=":
                                // creo que es medio fumado, ya que tiene que ver que es lo que iguala, nose si estoy equivada
                                break;
                        case "goto": 
                                 escribe.add("b "+ CuadTable.cuadruplos.get(Integer.parseInt(cuad.dest)).operator);
                                 break;
                        case "if =":
                            if(istempf(cuad.operand1)){
                                escribe.add("s.eq.c" + cuad.operand1 + "," + cuad.operand2);
                                }else{
                                    if(cuad.operand2.equalsIgnoreCase("true")){
                                        escribe.add("beq" + cuad.operand1 + ", 1 ," + cuad.dest);
                                                }else{
                                                    escribe.add("beq" + cuad.operand1 + "," + cuad.operand2 + "," + cuad.dest);
                                    }
                            }
                                temporales.TemporalLibre(cuad.operand1);
                                temporales.TemporalLibre(cuad.operand2);                  
                                break;
                        }
		}  
    }
	
    public boolean istemp(String s){
        if(s.startsWith("$t")){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean istempf(String s){
        if(s.startsWith("$f")){
            return true;
        }else{
            return false;
        }
    }
    
     public boolean istemps(String s){
        if(s.startsWith("%s")){
            return true;
        }else{
            return false;
        }        
    }
    public boolean isint(String s){
        try{
            Integer.parseInt(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    
    public boolean iscadena(String s){
        if(s.startsWith("_msg")){
            return true;
        }
        return false;
    }
    public boolean isid(String s){
        if(SimboloActual.findVar(s)!=null){
            return true;
        }else{
            
            return false;
        }
    }
        
 
           
}
