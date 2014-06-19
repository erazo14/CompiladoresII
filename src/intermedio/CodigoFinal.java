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
        String convertir = String.valueOf(Tipo.Char);
        Scope s = null;
        
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
                                //temporales.TemporalenUso(CuadTable.cuadruplos.get(i).dest, tipo, false);
                                break;
			case "-":
                            //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                escribe.add("sub" + CuadTable.cuadruplos.get(i).dest + "," + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2);
                                tipo = Tipo.Int;
                                //}
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);
                                //temporales.TemporalenUso(CuadTable.cuadruplos.get(i).dest, tipo, false);
                                
                                break;
			case "*":
                            //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                escribe.add("mul" + CuadTable.cuadruplos.get(i).dest + "," + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2);
                                tipo = Tipo.Int;
//                                }
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);
                                //temporales.TemporalenUso(CuadTable.cuadruplos.get(i).dest, tipo false);
                                break;
			case "/":
                            //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                escribe.add("div" + CuadTable.cuadruplos.get(i).dest + "," + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2);
				tipo = Tipo.Int;
  //                              }
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand2);
                                //temporales.TemporalenUso(CuadTable.cuadruplos.get(i).dest, tipo, false);
                                break;
                        case "Not":
                            //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                                escribe.add("Neg"  + CuadTable.cuadruplos.get(i).dest + "," + CuadTable.cuadruplos.get(i).operand1); 
                                tipo = Tipo.Int;
  //                              }
                                //temporales.TemporalLibre(CuadTable.cuadruplos.get(i).operand1);
                                //temporales.TemporalenUso(CuadTable.cuadruplos.get(i).dest, tipo, false);
                                break;
                        case "=": /*
                            if(!(istempf(CuadTable.cuadruplos.get(i).dest))){
                                // creo que es medio fumado, ya que tiene que ver que es lo que iguala, nose si estoy equivada
                               if(istemp(CuadTable.cuadruplos.get(i).dest)){
                                   if(isint(CuadTable.cuadruplos.get(i).operand1)){
                                       tipo = Tipo.Int;
                                       escribe.add("li"  + CuadTable.cuadruplos.get(i).dest + "," + CuadTable.cuadruplos.get(i).operand1);
                                       temporales.TemporalenUso(CuadTable.cuadruplos.get(i).dest, tipo, false);
                                   }else{
                                       if(isid(CuadTable.cuadruplos.get(i).operand1)){
                                          // s = SimboloActual.findLocalVar(CuadTable.cuadruplos.get(i).operand1);
                                           tipo = s.getTipo();
                                           switch(tipo){/*
                                               case Tipo.int:
                                                    if(s.Saltos != 0){
                                                        dir = s.direccion + 4;
                                                    escribe.add("lw "+CuadTable.cuadruplos.get(i).dest + " , -"+dir+"($fp)");
                                                    temporales.TemporalenUso(CuadTable.cuadruplos.get(i).dest, tipo false);
                                               } **
                                               
                                               
                                           }
                                          
                                       }
                                   
                                   }
                                }
                            } */
                               break;
                        case "goto": /*
                            String hola =CuadTable.cuadruplos.get(i).dest;
                            int juan =Integer.parseInt(hola);
                            System.out.println(juan);
                            System.out.println("rrrrrrrrrrrrrrrrrr"+CuadTable.cuadruplos.get(juan).operator);
//                                 escribe.add("b "+ CuadTable.cuadruplos.get(Integer.parseInt(CuadTable.cuadruplos.get(i).dest)).operator);
                                */ break;
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
                                escribe.add(CuadTable.cuadruplos.get(i).dest);
                                
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
                        case "_main":
                            escribe.add("main:");
                            escribe.add("move $fp , $sp");
                                break;
                        case "_salida":
                            escribe.add("li $v0 , 10");
                            escribe.add("syscall");
                            SimboloActual = Tabla.getrootScope();
                                break;
                        case "read":
                                Scope sc = null;
                              //   sc = SimboloActual.findVar(CuadTable.cuadruplos.get(i).dest);
                            switch (sc.getTipo()){
                                case Tipo.Int:
                                     escribe.add("li $v0 , 5");
                                     escribe.add("syscall");
                                    if(sc.Saltos == 0 ){
                                         if(sc.Referencia){
                                            dir = sc.getdireccion() + 4;
                                    temp1 = temporales.getSgteTemporal();
                                    escribe.add("lw "+temp1+" , -"+dir+"($fp)");
                                    escribe.add("sw $v0 , ("+temp1+")");
                                }else{
                                    dir = sc.getdireccion() + 4;
                                    escribe.add("sw $v0 , -"+dir+"($fp)");
                                }
                            }else{
                                if(!(sc.Referencia)){
                                    t = sc.Saltos;
                                    temp1 = temporales.getSgteTemporal();
                                    temp2 = temporales.getSgteTemporal();
                                    escribe.add("lw "+temp1+" -12($fp)");
                                    t--;
                                    while(t!=0){
                                        escribe.add("move "+temp2+" , "+temp1);
                                        escribe.add("lw "+temp1+" , -12("+temp2+")");
                                        t--;
                                    }
                                    temporales.TemporalLibre(temp1);
                                    temporales.TemporalLibre(temp2);
                                    dir = sc.direccion + 4;
                                    escribe.add("sw $v0 , -"+dir+"("+temp1+")");
                                    
                                }
                            }
                            break;
                            case Tipo.Char : 
                                 escribe.add("li $v0 , 8");
                                 escribe.add("li $a1 , 2");
                                 if(sc.Saltos == 0){
                                        if(!(sc.Referencia)){
                                             dir = sc.getdireccion() +2;
                                              escribe.add("la $a0 , -"+dir+"($fp)");
                                  }
                                 }else{
                                     if(!(sc.Referencia)){
                                            t = sc.Saltos;
                                           temp1 = temporales.getSgteTemporal();
                                         temp2 = temporales.getSgteTemporal();
                                         escribe.add("lw "+temp1+" -12($fp)");
                                         t--;
                                         while(t!=0){
                                        escribe.add("move "+temp2+" , "+temp1);
                                        escribe.add("lw "+temp1+" , -12("+temp2+")");
                                        t--;
                                        }
                                        temporales.TemporalLibre(temp1);
                                       temporales.TemporalLibre(temp2);
                                       dir = sc.direccion + 2;
                                        escribe.add("la $a0 , -"+dir+"("+temp1+")");
                                     }
                                }
                                   escribe.add("syscall");
                                   break;
                            case Tipo.String:
                                    escribe.add("li $v0 , 8");
                                    escribe.add("li $a1 , 46");
                                if(sc.Saltos == 0){
                                    if(!(sc.Referencia)){
                                        dir = sc.getdireccion() + 46;
                                        escribe.add("la $a0 , -"+dir+"($fp)");
                                   }
                               }else{
                                   if(!(sc.Referencia)){
                                       t = sc.Saltos;
                                       temp1 = temporales.getSgteTemporal();
                                      temp2 = temporales.getSgteTemporal();
                                      escribe.add("lw "+temp1+" -12($fp)");
                                       t--;
                                     while(t!=0){
                                         escribe.add("move "+temp2+" , "+temp1);
                                        escribe.add("lw "+temp1+" , -12("+temp2+")");
                                        t--;
                                    }
                                        temporales.TemporalLibre(temp1);
                                        temporales.TemporalLibre(temp2);
                                       dir = sc.direccion + 46;
                                       escribe.add("la $a0 , -"+dir+"("+temp1+")");
                                   }
                                
                                }
                               escribe.add("syscall");
                              break;
                    }
                    break;
                            
                    case "write":
                            if(istemp(CuadTable.cuadruplos.get(i).dest) || istempf(CuadTable.cuadruplos.get(i).dest)){
                                 switch (temporales.get_tipo(CuadTable.cuadruplos.get(i).dest)){
                            case Tipo.Int:
                                if(!(temporales.is_ref(CuadTable.cuadruplos.get(i).dest))){
                                    escribe.add("li $v0 , 1");
                                    escribe.add("move $a0 , "+ CuadTable.cuadruplos.get(i).dest);
                                    escribe.add("syscall");
                                    temporales.TemporalLibre(CuadTable.cuadruplos.get(i).dest);
                                }
                                break;
                            case Tipo.String:
                                if(!(temporales.is_ref(CuadTable.cuadruplos.get(i).dest))){
                                    escribe.add("li $v0 , 4");
                                    escribe.add("move $a0 , "+ CuadTable.cuadruplos.get(i).dest);
                                    escribe.add("syscall");
                                    temporales.TemporalLibre(CuadTable.cuadruplos.get(i).dest);
                                }
                                break;
                            case Tipo.Char:
                               if(!(temporales.is_ref(CuadTable.cuadruplos.get(i).dest))){
                                    escribe.add("li $v0 , 4");
                                    escribe.add("move $a0 , "+ CuadTable.cuadruplos.get(i).dest);
                                    escribe.add("syscall");
                                    temporales.TemporalLibre(CuadTable.cuadruplos.get(i).dest);
                               }
                                break;
                            case Tipo.Boolean:
                                escribe.add("li $v0 , 4");
                                if(CuadTable.cuadruplos.get(i).dest.equals("True")){
                                    escribe.add("la $a0 , _true");
                                }else{
                                    escribe.add("la $a0 , _false");
                                }
                                escribe.add("syscall");
                                break;

                            }                    
                             }else{
                                if(CuadTable.cuadruplos.get(i).dest.equals("True")){
                                    escribe.add("li $v0 , 4");
                                    escribe.add("la $a0 , _true");
                                    escribe.add("syscall");                            
                                    }else{
                                        if(CuadTable.cuadruplos.get(i).dest.equals("False")){
                                            escribe.add("li $v0 , 4");
                                            escribe.add("la $a0 , _false");
                                            escribe.add("syscall");  
                                        }else{
                                           escribe.add("li $v0 , 4");
                                           escribe.add("la $a0 , "+ CuadTable.cuadruplos.get(i).dest);
                                           escribe.add("syscall");
                                        }
                                    }
                        
                                }
                                break;
                    case "SAVE_PARAMS":/*
                        dir = 12;
                        ArrayList<Temporal> activos = temporales.getTempActivos();;
                        t = Cuadruplos.cuadruplos.indexOf(quad) + 1;
                        ArrayList<String> temporales_parametros = new ArrayList();
                        ArrayList<String> tempos_guardados = new ArrayList();
                        while(Cuadruplos.cuadruplos.get(t).operacion.equals("PARAM")){
                        temporales_parametros.add(Cuadruplos.cuadruplos.get(t).resultado);
                        t++;
                        }
                       for (Temporal tempo : activos) {
                          if(!temporales_parametros.contains(tempo.name)){
                            if(this.es_tempf(tempo.name)){
                                escribe.add("s.s "+tempo.name +" , -4($sp)");
                            }else{
                                escribe.add("sw "+tempo.name +" , -4($sp)");
                            }
                            escribe.add("sub $sp , $sp ,4");
                            tempos_guardados.add(tempo.name);
                        }
                    }
                    this.temps_activas.push(tempos_guardados); */
                    break;
                            }
                        
		}
         return escribe;
    }
	
    public static boolean istemp(String s){
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