/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jflex;
/**
 *
 * @author Armando
 */
public class VbLexerBuilder {
	
	public static void main(String[] args) {
		args = new String[3];
		args[0] = "-d";
		args[1] = "src\\lexer\\";
		args[2] = "src\\jflex\\VbLexer.flex";
		
		try{
			JFlex.Main.generate(args);
		}catch (JFlex.SilentExit e){
			System.out.println("Error building lexer");
		}
	}
}
