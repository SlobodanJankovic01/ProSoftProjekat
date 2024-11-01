/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Slobodan
 */
public class RadnaSmena {
    
    private int idRadnaSmena;
    private String naziv;
    
    //Ovo je Time atribut u seminarskom 
    private TimeUnit vremeOd;
    private TimeUnit vremeDo;

    public int getIdRadnaSmena() {
        return idRadnaSmena;
    }

    public void setIdRadnaSmena(int idRadnaSmena) {
        this.idRadnaSmena = idRadnaSmena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    
    
    
}
