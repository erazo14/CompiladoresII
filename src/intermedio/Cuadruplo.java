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
    
    Cuadruplo(String operator, String operand1, String dest){
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = "";
        this.dest = dest;
    }
    
    Cuadruplo(String operator, String operand1){
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = "";
        this.dest = "";
    }
    
    Cuadruplo(String operator){
        this.operator = operator;
        this.operand1 = "";
        this.operand2 = "";
        this.dest = "";
    }
    
	@Override
    public String toString(){
		switch(this.operator){
			case "+":
			case "-":
			case "*":
			case "/":
			case "&":
				return this.dest + " = " + this.operand1 + " " + this.operator + " " + this.operand2;
			case "=":
				return this.dest + " = " + this.operand1;
			case "if<":
				return "if " + this.operand1 + " < " + this.operand2 + " goto " + this.dest;
			case "if=":
				return "if " + this.operand1 + " = " + this.operand2 + " goto " + this.dest;
			case "if":
				return "if " + this.operand1 + " = 1 goto " + this.dest;
			case "goto": 
				return "goto " + this.dest;
                        case "if>":
				return "if " + this.operand1 + " > " + this.operand2 + " goto " + this.dest;
                        case "if<=":
				return "if " + this.operand1 + " <= " + this.operand2 + " goto " + this.dest;
                        case "if>=":
				return "if " + this.operand1 + " >= " + this.operand2 + " goto " + this.dest;
                        case "_etiq":
                            return this.operator + ": ";
                        case "call":
                            return this.operator + " _" + this.dest;
                        case "param":
                            return this.operator+ " " + this.operand1;
                        case "write":
                            return this.operator+ " " + this.operand1;
			default:
				return this.operator + ":";
		}
	}
}
