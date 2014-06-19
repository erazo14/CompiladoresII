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

    public static ArrayList<String> FinalCode() {

        escribe = new ArrayList();
        mensajes = new ArrayList();
        escribe.add(".data");
        escribe.add("_true: .asciiz \"True\" ");
        escribe.add("_false: .asciiz \"False\" ");
        for (Texto texto : mensajes) {
            if (texto.texto.startsWith("'")) {
                texto.texto = texto.texto.replaceAll("'", "\"");
            }
            escribe.add(texto.nombre + ": .asciiz " + texto.texto);
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

        for (int i = 0; i < CuadTable.cuadruplos.size(); i++) {
            System.out.println(i + "...." + CuadTable.cuadruplos.get(i).operator);
            switch (CuadTable.cuadruplos.get(i).operator) {
                case "+":
                    //if(istempf(CuadTable.cuadruplos.get(i).operand1)){
                    escribe.add("add" + CuadTable.cuadruplos.get(i).dest + "," + CuadTable.cuadruplos.get(i).operand1 + "," + CuadTable.cuadruplos.get(i).operand2);
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
                    escribe.add("Neg" + CuadTable.cuadruplos.get(i).dest + "," + CuadTable.cuadruplos.get(i).operand1);
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
                /*  case "_etiq": //dentro del default
                 escribe.add(CuadTable.cuadruplos.get(i).dest);
                                
                 break;*/
                case "call":
                    //    s = SimboloActual.findVar1(CuadTable.cuadruplos.get(i).dest);
                    s = SymTable.curScope.findVar1(CuadTable.cuadruplos.get(i).dest);// esta cosa me esta cayendo mal
                    escribe.add("jal _func" + s.nombre);
                    if (!TempActivas.empty()) {
                        ArrayList<String> temps = TempActivas.pop();
                        for (String temporales1 : temps) {
                            if (istempf(temporales1)) {
                                escribe.add("l.s " + temporales1 + " , ($sp)");
                            } else {
                                escribe.add("lw " + temporales1 + " , ($sp)");
                            }
                            escribe.add("add $sp , $sp , 4");
                        }
                    }
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
                    //     sc = SimboloActual.findVar(CuadTable.cuadruplos.get(i).dest);
                    switch (CuadTable.cuadruplos.get(i).dest) {
                        case "integer":
                            escribe.add("li $v0 , 5");
                            escribe.add("syscall");
                            if (sc.Saltos == 0) {
                                if (sc.Referencia) {
                                    dir = sc.getdireccion() + 4;
                                    temp1 = temporales.getSgteTemporal();
                                    escribe.add("lw " + temp1 + " , -" + dir + "($fp)");
                                    escribe.add("sw $v0 , (" + temp1 + ")");
                                } else {
                                    dir = sc.getdireccion() + 4;
                                    escribe.add("sw $v0 , -" + dir + "($fp)");
                                }
                            } else {
                                if (!(sc.Referencia)) {
                                    t = sc.Saltos;
                                    temp1 = temporales.getSgteTemporal();
                                    temp2 = temporales.getSgteTemporal();
                                    escribe.add("lw " + temp1 + " -12($fp)");
                                    t--;
                                    while (t != 0) {
                                        escribe.add("move " + temp2 + " , " + temp1);
                                        escribe.add("lw " + temp1 + " , -12(" + temp2 + ")");
                                        t--;
                                    }
                                    temporales.TemporalLibre(temp1);
                                    temporales.TemporalLibre(temp2);
                                    dir = sc.direccion + 4;
                                    escribe.add("sw $v0 , -" + dir + "(" + temp1 + ")");

                                }
                            }
                            break;
                        case "char":
                            escribe.add("li $v0 , 8");
                            escribe.add("li $a1 , 2");
                            if (sc.Saltos == 0) {
                                if (!(sc.Referencia)) {
                                    dir = sc.getdireccion() + 2;
                                    escribe.add("la $a0 , -" + dir + "($fp)");
                                }
                            } else {
                                if (!(sc.Referencia)) {
                                    t = sc.Saltos;
                                    temp1 = temporales.getSgteTemporal();
                                    temp2 = temporales.getSgteTemporal();
                                    escribe.add("lw " + temp1 + " -12($fp)");
                                    t--;
                                    while (t != 0) {
                                        escribe.add("move " + temp2 + " , " + temp1);
                                        escribe.add("lw " + temp1 + " , -12(" + temp2 + ")");
                                        t--;
                                    }
                                    temporales.TemporalLibre(temp1);
                                    temporales.TemporalLibre(temp2);
                                    dir = sc.direccion + 2;
                                    escribe.add("la $a0 , -" + dir + "(" + temp1 + ")");
                                }
                            }
                            escribe.add("syscall");
                            break;
                        case "string":
                            escribe.add("li $v0 , 8");
                            escribe.add("li $a1 , 46");
                            if (sc.Saltos == 0) {
                                if (!(sc.Referencia)) {
                                    dir = sc.getdireccion() + 46;
                                    escribe.add("la $a0 , -" + dir + "($fp)");
                                }
                            } else {
                                if (!(sc.Referencia)) {
                                    t = sc.Saltos;
                                    temp1 = temporales.getSgteTemporal();
                                    temp2 = temporales.getSgteTemporal();
                                    escribe.add("lw " + temp1 + " -12($fp)");
                                    t--;
                                    while (t != 0) {
                                        escribe.add("move " + temp2 + " , " + temp1);
                                        escribe.add("lw " + temp1 + " , -12(" + temp2 + ")");
                                        t--;
                                    }
                                    temporales.TemporalLibre(temp1);
                                    temporales.TemporalLibre(temp2);
                                    dir = sc.direccion + 46;
                                    escribe.add("la $a0 , -" + dir + "(" + temp1 + ")");
                                }

                            }
                            escribe.add("syscall");
                            break;
                    }
                    break;

                case "write":
                        switch (CuadTable.cuadruplos.get(i).dest) {

                            case "string":
                               // if (!(temporales.is_ref(CuadTable.cuadruplos.get(i).dest))) {
                                    escribe.add("li $v0 , 8");
                                    escribe.add("move $a0 , _" + CuadTable.cuadruplos.get(i).operand1);
                                    escribe.add("syscall");
  //                                  temporales.TemporalLibre(CuadTable.cuadruplos.get(i).dest);
                                //}
                                break;
                            case "integer":
                                //if (!(temporales.is_ref(CuadTable.cuadruplos.get(i).dest))) {
                                    escribe.add("li $v0 , 5");
                                    escribe.add("move $a0 , _" + CuadTable.cuadruplos.get(i).operand1);
                                    escribe.add("syscall");
//                                    temporales.TemporalLibre(CuadTable.cuadruplos.get(i).dest);
                                //}
                                break;
/*                            case "char":
                                //if (!(temporales.is_ref(CuadTable.cuadruplos.get(i).dest))) {
                                    escribe.add("li $v0 , pendiente");
                                    escribe.add("move $a0 , " + CuadTable.cuadruplos.get(i).dest);
                                    escribe.add("syscall");
    //                                temporales.TemporalLibre(CuadTable.cuadruplos.get(i).dest);
                                //}
                                break;
                            case "boolean":
                                escribe.add("li $v0 , pendiente");
                                if (CuadTable.cuadruplos.get(i).dest.equals("True")) {
                                    escribe.add("la $a0 , _true");
                                } else {
                                    escribe.add("la $a0 , _false");
                                }
                                escribe.add("syscall");
                                break;*/

                        }
                    
                    break;
                case "Saveparam":
                    // dir = 12;
                    ArrayList<Temporal> activos = temporales.getTempActivos();
                    ;
                    t = CuadTable.cuadruplos.indexOf(CuadTable.cuadruplos) + 1;
                    ArrayList<String> temporales_parametros = new ArrayList();
                    ArrayList<String> tempos_guardados = new ArrayList();
                    while (CuadTable.cuadruplos.get(t).operator.equals("param")) {
                        temporales_parametros.add(CuadTable.cuadruplos.get(t).dest);
                        t++;
                    }
                    for (Temporal temp : activos) {
                        if (!temporales_parametros.contains(temp.name)) {
                            if (!(istempf(temp.name))) {
                                escribe.add("sw " + temp.name + " , -4($sp)");
                            }
                            escribe.add("sub $sp , $sp ,4");
                            tempos_guardados.add(temp.name);
                        }
                    }
                    TempActivas.push(tempos_guardados);
                    break;
                case "param":
                    if (!(istempf(CuadTable.cuadruplos.get(i).dest))) {
                        /* if(!(temporales.is_ref(CuadTable.cuadruplos.get(i).dest))){
                        
                         }else{
                         dir = dir + 4;
                         escribe.add("s.s "+quad.resultado+" , -"+dir+"($sp)");
                         tempos.free_temp(quad.resultado);
                         }*
                         }else{*/
                        if (istemp(CuadTable.cuadruplos.get(i).dest)) {
                            tipo = temporales.get_tipo(CuadTable.cuadruplos.get(i).dest);
                            switch (tipo) {
                                case Tipo.Int:
                                    if (!(temporales.is_ref(CuadTable.cuadruplos.get(i).dest))) {
                                        dir = dir + 4;
                                        escribe.add("sw " + CuadTable.cuadruplos.get(i).dest + " , -" + dir + "($sp)");
                                    }
                                    break;
                                case Tipo.Boolean:
                                    if (!(temporales.is_ref(CuadTable.cuadruplos.get(i).dest))) {
                                        dir = dir + 2;
                                        escribe.add("sb " + CuadTable.cuadruplos.get(i).dest + " , -" + dir + "($sp)");
                                    }
                                    break;
                                case Tipo.Char:
                                    if (!(temporales.is_ref(CuadTable.cuadruplos.get(i).dest))) {
                                        temp1 = temporales.getSgteTemporal(); //es la direccion de origen
                                        temp2 = temporales.getSgteTemporal(); //char
                                        temp3 = temporales.getSgteTemporal();//dir destino
                                        dir = dir + 2;
                                        if (iscadena(CuadTable.cuadruplos.get(i).dest)) {
                                            escribe.add("la " + temp1 + " , (" + CuadTable.cuadruplos.get(i).dest + ")");;
                                        } else {
                                            escribe.add("la " + temp1 + " , (" + CuadTable.cuadruplos.get(i).dest + ")");
                                        }
                                        escribe.add("la " + temp3 + " , -" + dir + "($sp)");
                                        escribe.add("_begin_copy" + cont_copia_string + ":");
                                        escribe.add("lb " + temp2 + " , (" + temp1 + ")");
                                        escribe.add("sb " + temp2 + " , (" + temp3 + ")");
                                        escribe.add("beq " + temp2 + " , $zero , _end_copy" + cont_copia_string);
                                        escribe.add("add " + temp1 + " , " + temp1 + " , 1");
                                        escribe.add("add " + temp3 + " , " + temp3 + " , 1");
                                        escribe.add("b _begin_copy" + cont_copia_string);
                                        escribe.add("_end_copy" + cont_copia_string + ":");
                                        temporales.TemporalLibre(temp1);
                                        temporales.TemporalLibre(temp2);
                                        temporales.TemporalLibre(temp3);
                                        cont_copia_string++;
                                    }
                                    break;
                                case Tipo.String:
                                    if (!(temporales.is_ref(CuadTable.cuadruplos.get(i).dest))) {
                                        temp1 = temporales.getSgteTemporal(); //es la direccion de origen
                                        temp2 = temporales.getSgteTemporal(); //string
                                        temp3 = temporales.getSgteTemporal();//dir destino
                                        dir = dir + 46;
                                        if (iscadena(CuadTable.cuadruplos.get(i).dest)) {
                                            escribe.add("la " + temp1 + " , " + CuadTable.cuadruplos.get(i).dest + "");
                                        } else {
                                            escribe.add("la " + temp1 + " , (" + CuadTable.cuadruplos.get(i).dest + ")");
                                        }

                                        escribe.add("la " + temp3 + " , -" + dir + "($sp)");
                                        escribe.add("_begin_copy" + cont_copia_string + ":");
                                        escribe.add("lb " + temp2 + " , (" + temp1 + ")");
                                        escribe.add("sb " + temp2 + " , (" + temp3 + ")");
                                        escribe.add("beq " + temp2 + " , $zero , _end_copy" + cont_copia_string);
                                        escribe.add("add " + temp1 + " , " + temp1 + " , 1");
                                        escribe.add("add " + temp3 + " , " + temp3 + " , 1");
                                        escribe.add("b _begin_copy" + cont_copia_string);
                                        escribe.add("_end_copy" + cont_copia_string + ":");
                                        temporales.TemporalLibre(temp1);
                                        temporales.TemporalLibre(temp2);
                                        temporales.TemporalLibre(temp3);
                                        cont_copia_string++;
                                    }
                                    temporales.TemporalLibre(CuadTable.cuadruplos.get(i).dest);
                                    break;
                            }
                        } else {

                        }
                    }
                    break;
                default:
                    // CuadTable.cuadruplos.add(new Cuadruplo("_"+CuadTable.cuadruplos.get(i).operator));
                    escribe.add("_" + CuadTable.cuadruplos.get(i).operator + ":");
                    break;
            }

        }
        return escribe;
    }

    public static boolean istemp(String s) {
        if (s.startsWith("$t")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean istempf(String s) {
        if (s.startsWith("$f")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean istemps(String s) {
        if (s.startsWith("$s")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isint(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean iscadena(String s) {
        if (s.startsWith("_msg")) {
            return true;
        }
        return false;
    }

    public static boolean isid(String s) {
        if (SimboloActual.findVar(s) != null) {
            return true;
        } else {

            return false;
        }
    }

}
