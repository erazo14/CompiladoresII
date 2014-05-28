/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Intermedio;

/**
 *
 * @author owner
 */
public class Cuadruplos {
    public String operator;
    public String var;
    public String id;
    public String temp;
    
    Cuadruplos(String op , String var, String id, String temp){
        this.operator = op;
        this.var = var;
        this.id = id;
        this.temp = temp;
    }
    
    Cuadruplos(String op , String id, String temp){
        this.operator = op;
        this.var = id;
        this.temp = temp;
    }
    
    Cuadruplos(String op, String temp){
        this.operator = op;
        this.temp = temp;
    }
    
    
}
