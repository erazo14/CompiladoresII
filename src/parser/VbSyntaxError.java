/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

/**
 *
 * @author Armando
 */
public class VbSyntaxError {
	public String message;
	public int line;
	public int column;
	public int offset;
	public int length;
	
	public VbSyntaxError(String message, int line, int column, int offset, int length){
		this.message = message;
		this.line = line;
		this.column = column;
		this.offset = offset;
		this.length = length;
	}
}
