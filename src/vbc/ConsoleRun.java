/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lexer.VbLexer;
import parser.VbParser;
import parser.VbSyntaxError;

/**
 *
 * @author Armando
 */
public class ConsoleRun {
	public static void main(String args[]){
		try {
			VbParser parser = new VbParser(new VbLexer(new FileReader("src\\vbc\\a.vb")));
	
			try {
				parser.parse();
				
				ArrayList<VbSyntaxError> errLst = parser.getErrLst();
			
				if (errLst.isEmpty()){
					System.out.println("OK!");
				}else{
					System.err.println("Parse finished with errors:");
					
					for (int i = 0; i < errLst.size(); i++){
						System.err.println(errLst.get(i).message);
					}
				}
			} catch (Exception ex) {
				Logger.getLogger(Vbc.class.getName()).log(Level.SEVERE, null, ex);
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Vbc.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
