/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intermedio;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Escritor {
    public static void escribe(String archivo, ArrayList<String> instrucciones) {
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("./src/"+archivo+".asm");
            pw = new PrintWriter(fichero);

                 for (int i=0;i<instrucciones.size();i++){
                     pw.println(instrucciones.get(i));
                 }
            
               

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
    }
}
