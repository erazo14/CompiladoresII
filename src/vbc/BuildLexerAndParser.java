/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vbc;

/**
 *
 * @author Armando
 */
public class BuildLexerAndParser {
	public static void main(String[] args){
		jflex.VbLexerBuilder.main(args);
		cup.VbParserBuilder.main(args);
	}
}
