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
public class Lista_Temporales {
    public final static int NumTemporales = 10;
    public final static int NTemporalesS = 8;
    public final static int NTemporalesf = 14; //nose si dejarla para las 32 registros que se manejan
    Temporal[] temporales;
    Temporal[] temp_s;
    Temporal[] temp_f;
  
    public Lista_Temporales(){
        temporales = new Temporal[NumTemporales];
        temp_s = new Temporal[NTemporalesS];
        temp_f = new Temporal[NTemporalesf];
        for (int i = 0; i < NumTemporales; i++) {
            temporales[i] = new Temporal("$t"+i);
        }
        for (int i = 0; i < NTemporalesS; i++) {
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
    
      public String getSgteTemporal(){
        String result = "";
        for (int i = 0; i < NumTemporales; i++) {
            if(temporales[i].available){
                result = temporales[i].name;
                temporales[i].available = false;
                break;
            }
        }
        return result;
    }
      
      
      public String getSgteTemporals(){
        String result = "";
        for (int i = 0; i < NTemporalesS; i++) {
            if(temp_s[i].available){
                result = temp_s[i].name;
                temp_s[i].available = false;
                break;
            }
        }
        return result;
    }
    
      
    public String getSgteTemporalf(){
        String result = "";
        for (int i = 0; i < temp_f.length; i++) {
            if(temp_f[i].available){
                result = temp_f[i].name;
                temp_f[i].available = false;
                break;
            }
        }
        return result;
    }
    
    public void TemporalLibre(String name){
        for (int i = 0; i < NumTemporales; i++) {
            if(temporales[i].name.equalsIgnoreCase(name)){
                temporales[i].available = true;
                return;
            }
        }
        for (int i = 0; i < NTemporalesS; i++) {
            if(this.temp_s[i].name.equalsIgnoreCase(name)){
                temp_s[i].available = true;
                return;
            }
        }
        for (int i = 0; i < temp_f.length ; i++) {
            if(temp_f[i].name.equalsIgnoreCase(name)){
                temp_f[i].available = true;
                return;
            }
        }
    }
    
    
    public boolean IsTemporal(String name){
        for (int i = 0; i < NumTemporales; i++) {
            if(temporales[i].name.equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
    
    public void TemporalenUso(String name, int tipo, boolean referencia){ // aqui creo que podria ir el tipo del valor del temporal, deberia de crear una clase tipo
        for (int i = 0; i < NumTemporales; i++) {
            if(temporales[i].name.equalsIgnoreCase(name)){
               temporales[i].tipo = tipo;
               temporales[i].referencia = referencia;
               temporales[i].available = false;
                return;
            }
        }
        for (int i = 0; i < NTemporalesS; i++) {
            if(this.temp_s[i].name.equalsIgnoreCase(name)){
                temp_s[i].tipo =tipo;
                temporales[i].referencia = referencia;
                temp_s[i].available = false;
                return;
            }
        }
        
        for (int i = 0; i < temp_f.length ; i++) {
            if(temp_f[i].name.equalsIgnoreCase(name)){
                temp_f[i].tipo = tipo;
                temporales[i].referencia = referencia;
                temp_f[i].available = false;
                return;
            }
        }
    }
    
    public void set_tipo (String name , int tipo){
        for (int i = 0; i < NumTemporales; i++) {
            if(temporales[i].name.equalsIgnoreCase(name)){
                temporales[i].tipo = tipo;
                return;
            }
        }
        for (int i = 0; i < NTemporalesS; i++) {
            if(this.temp_s[i].name.equalsIgnoreCase(name)){
                temp_s[i].tipo = tipo;
                return;
            }
        }
        for (int i = 0; i < temp_f.length ; i++) {
            if(temp_f[i].name.equalsIgnoreCase(name)){
                temp_f[i].tipo = tipo;
                return;
            }
        }
    }
    
    public int get_tipo(String name){
                for (int i = 0; i < NumTemporales; i++) {
            if(temporales[i].name.equalsIgnoreCase(name)){
                return temporales[i].tipo;
            }
        }
        for (int i = 0; i < NTemporalesS; i++) {
            if(this.temp_s[i].name.equalsIgnoreCase(name)){
                return temp_s[i].tipo;
            }
        }
        for (int i = 0; i < temp_f.length ; i++) {
            if(temp_f[i].name.equalsIgnoreCase(name)){
                return temp_f[i].tipo;                 
            }
        }
        return Tipo.Sub;    
    }
    
    public void set_ref (String name , boolean ref){
        for (int i = 0; i < NumTemporales; i++) {
            if(temporales[i].name.equalsIgnoreCase(name)){
                temporales[i].referencia = ref;
                return;
            }
        }
        for (int i = 0; i < NTemporalesS; i++) {
            if(this.temp_s[i].name.equalsIgnoreCase(name)){
                temp_s[i].referencia = ref;
                return;
            }
        }
        for (int i = 0; i < temp_f.length ; i++) {
            if(temp_f[i].name.equalsIgnoreCase(name)){
                temp_f[i].referencia = ref;
                return;
            }
        }
    }
    public boolean is_ref(String name){
                for (int i = 0; i < NumTemporales; i++) {
            if(temporales[i].name.equalsIgnoreCase(name)){
                if(temporales[i].referencia){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        for (int i = 0; i < NTemporalesS; i++) {
            if(this.temp_s[i].name.equalsIgnoreCase(name)){
                if(temp_s[i].referencia){
                    return true;
                }else{
                    return false;
                }
            }
        }
        for (int i = 0; i < temp_f.length ; i++) {
            if(temp_f[i].name.equalsIgnoreCase(name)){
                if(temp_f[i].referencia){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
    
    
    public ArrayList<Temporal> getTempActivos(){
        ArrayList<Temporal> tempactivos = new ArrayList();
        for (int i = 0; i < NumTemporales; i++) {
            if(!temporales[i].available){
                tempactivos.add(temporales[i]);
            }
        }
        for (int i = 0; i < temp_f.length ; i++) {
            if(!temp_f[i].available){
                tempactivos.add(temp_f[i]);
            }
        }
        return tempactivos;
    }
      
    
    

}
