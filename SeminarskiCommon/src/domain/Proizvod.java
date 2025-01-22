/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Slobodan
 */
public class Proizvod implements Serializable{
    
    private int idProizvod;
    private String naziv;
    private int jedinicnaCena;

    public Proizvod() {
    }

    public Proizvod(int idProizvod, String naziv, int jedinicnaCena) {
        this.idProizvod = idProizvod;
        this.naziv = naziv;
        this.jedinicnaCena = jedinicnaCena;
    }
    
    
    public int getIdProizvod() {
        return idProizvod;
    }

    public void setIdProizvod(int idProizvod) {
        this.idProizvod = idProizvod;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getJedinicnaCena() {
        return jedinicnaCena;
    }

    public void setJedinicnaCena(int jedinicnaCena) {
        this.jedinicnaCena = jedinicnaCena;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proizvod other = (Proizvod) obj;
        return this.idProizvod == other.idProizvod;
    }
    
    
    
    
}
