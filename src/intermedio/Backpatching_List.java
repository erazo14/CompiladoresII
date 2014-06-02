/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intermedio;

/**
 *
 * @author usuario
 */
public class Backpatching_List {
     public  CuadTable l_siguiente ;
     public  CuadTable l_true ;
     public  CuadTable l_false ;
     public String lugar;
     public int tipo_lugar;
     public Backpatching_List(CuadTable l){
        l_siguiente = l;
        l_true = null;
        l_false = null;
        lugar = null;
     }
     
     public Backpatching_List(CuadTable l1, CuadTable l2){
        l_siguiente = null;
        l_true = l1;
        l_false = l2;
        lugar = null;
    }
   
     public Backpatching_List(String l){
        l_siguiente = null;
        l_true = null;
        l_false = null;
        lugar = l;
    } 
     
    
     public Backpatching_List(String l, int tipo){
        l_siguiente = null;
        l_true = null;
        l_false = null;
        lugar = l;
        this.tipo_lugar = tipo;
    }
    
}

