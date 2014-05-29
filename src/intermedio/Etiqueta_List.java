/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package intermedio;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Etiqueta_List {
     public  ArrayList <Etiquetas> LabelList = new ArrayList();

    public Etiqueta_List() {
    }
    
    public void  AddLabel(String paramc,String params , String params1 , String paramid1 , String paramid2 , String paramid3 ){
        Etiquetas label = new Etiquetas (paramc,params,params1,paramid1, paramid2, paramid3);
        LabelList.add(label);
        
    }
    
    public Etiquetas getEtiqueta(){
        return LabelList.get(LabelList.size()-1);

    }
    
    public void deletelastlabel(){
        
        LabelList.remove(LabelList.size()-1);
        
               
    }
 
    
}
