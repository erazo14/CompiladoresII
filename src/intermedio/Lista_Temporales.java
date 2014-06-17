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
public class Lista_Temporales {
    public final static int NUM_TEMPORALES = 10;
    public final static int NUM_TEMP_S = 8;
    public final static int NUM_TEMP_F = 14;
    Temporal[] temporales;
    Temporal[] temp_s;
    Temporal[] temp_f;
  
    public Lista_Temporales(){
        temporales = new Temporal[NUM_TEMPORALES];
        temp_s = new Temporal[NUM_TEMP_S];
        temp_f = new Temporal[NUM_TEMP_F ];
        for (int i = 0; i < NUM_TEMPORALES; i++) {
            temporales[i] = new Temporal("$t"+i);
        }
        for (int i = 0; i < NUM_TEMP_S; i++) {
            temp_s [i] = new Temporal("$s"+i);            
        }
        int contador = 2;
        for (int i = 0; i < temp_f.length; i++) {
            if(contador!=12 && contador!=0){
                temp_f [i] = new Temporal("$f"+contador);
            }else{
                contador +=2;
                temp_f[i] = new Temporal("$f"+contador);
            }
            contador+=2;
        }
    }
    
    

}
