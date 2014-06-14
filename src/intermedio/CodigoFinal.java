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
    SymTable Tabla;
    //CuadTable Cuadruplos;
    Scope AmbitoActual;
    ArrayList<Texto> mensajes;
    //CuadTable tempo; // maneja la lista de los temporales
    int cont_copia_string;
    Stack<ArrayList<String>> tempActivas;
    ArrayList<String> escribe;

    public CodigoFinal(SymTable Tabla, /*CuadTable Cuadruplos,*/ ArrayList<Texto> mensajes) {
        this.Tabla = Tabla;
        //this.Cuadruplos = Cuadruplos;
        this.AmbitoActual = SymTable.rootScope; //las clases estan static por eso no puedo depender de ellas
        this.mensajes = mensajes;
        //tempo = new CuadTable();
        this.cont_copia_string = 0;
        tempActivas = new Stack();
        escribe = new ArrayList();
    }
    
    public void FinalCode(){
        escribe.add(".data");
        escribe.add("_true: .asciiz \"TRUE\" ");
        escribe.add("_false: .asciiz \"FALSE\" ");
        for (Texto texto : mensajes) {
            if(texto.texto.startsWith("'")){
                texto.texto = texto.texto.replaceAll("'", "\"");
            }
            escribe.add(texto.nombre+": .asciiz "+texto.texto);
        }
        escribe.add(".text");
        escribe.add(".globl main");
        int tipo;
        int dir = 0;
        int t;
        String temp,temp2,temp3;
        Simbolo s;
        
        
        
           }
}
