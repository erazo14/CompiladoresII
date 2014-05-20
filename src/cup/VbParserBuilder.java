/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cup;

/**
 *
 * @author Armando
 */
public class VbParserBuilder {
	
	public static void main(String[] args) {		
		args = new String[7];
		args[0] = "-destdir";
		args[1] = "src\\parser\\";
		args[2] = "-parser";
		args[3] = "VbParser";
		args[4] = "-symbols";
		args[5] = "sym";
		args[6] = "src/cup/VbParser.cup";
		
		try {
			java_cup.Main.main(args);
		} catch (Exception e) {
			System.out.print(e);
		}

	}
}
