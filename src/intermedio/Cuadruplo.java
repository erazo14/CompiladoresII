/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intermedio;

/**
 *
 * @author owner
 */
public class Cuadruplo {
    public String operator;
    public String operand1;
    public String operand2;
    public String dest;
    
    Cuadruplo(String operator , String operand1, String operand2, String dest){
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.dest = dest;
    }
    
    Cuadruplo(String operator , String operand1, String dest){
        this.operator = operator;
        this.operand1 = operand1;
        this.dest = dest;
    }
    
    Cuadruplo(String operator, String operand1){
        this.operator = operator;
        this.operand1 = operand1;
    }
    
    
}
