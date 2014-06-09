/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intermedio;

import java.util.ArrayList;
import java.util.Stack;
import symtable.Simbolo;
import symtable.SymTable;

/**
 *
 * @author usuario
 */
public class CodigoFinal {
    SymTable Tabla;
    CuadTable Cuadruplos;
    Simbolo SimboloActual;
    ArrayList<Texto> mensajes;
    CuadTable tempo; // maneja la lista de los temporales
    int cont_copia_string;
    Stack<ArrayList<String>> tempActivas;
    ArrayList<String> escribir;

    public CodigoFinal(SymTable Tabla, CuadTable Cuadruplos, ArrayList<Texto> mensajes) {
        this.Tabla = Tabla;
        this.Cuadruplos = Cuadruplos;
    //   this.SimboloActual = Tabla.getCurScope(); las clases estan static por eso no puedo depender de ellas
        this.mensajes = mensajes;
        tempo = new CuadTable();
        this.cont_copia_string = 0;
        tempActivas = new Stack();
        escribir = new ArrayList();
    }
    
    public void FinalCode(){
        escribir.add(".data");
        escribir.add("_true: .asciiz \"TRUE\" ");
        escribir.add("_false: .asciiz \"FALSE\" ");
        for (Texto texto : mensajes) {
            if(texto.texto.startsWith("'")){
                texto.texto = texto.texto.replaceAll("'", "\"");
            }
            escribir.add(texto.nombre+": .asciiz "+texto.texto);
        }
        escribir.add(".text");
        escribir.add(".globl main");
        int tipo;
        int dir = 0;
        int t;
        String temp,temp2,temp3;
        Simbolo s;
    }
    
    
    



}
