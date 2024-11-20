/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import db.DBbroker;

/**
 *
 * @author Slobodan
 */
public class Kontroler {
    
    static Kontroler instance;

    DBbroker dbb;
    
    public Kontroler() {
    
        dbb=new DBbroker();
        
    }

    
    public static Kontroler getInstance() {
        
        if(instance==null){
            instance=new Kontroler();
        }
        
        return instance;
    }

    
    
    
    
}
