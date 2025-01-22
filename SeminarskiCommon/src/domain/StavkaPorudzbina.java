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
public class StavkaPorudzbina implements Serializable{
    
    private int idPorudzbina;
    private int rb;
    private int kolicina;
    private int cena;
    private int idProizvod;

    public StavkaPorudzbina() {
    }

    public StavkaPorudzbina(int idPorudzbina, int rb, int kolicina, int cena, int idProizvod) {
        this.idPorudzbina = idPorudzbina;
        this.rb = rb;
        this.kolicina = kolicina;
        this.cena = cena;
        this.idProizvod = idProizvod;
    }

    public int getIdPorudzbina() {
        return idPorudzbina;
    }

    public void setIdPorudzbina(int idPorudzbina) {
        this.idPorudzbina = idPorudzbina;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getIdProizvod() {
        return idProizvod;
    }

    public void setIdProizvod(int idProizvod) {
        this.idProizvod = idProizvod;
    }

    @Override
    public String toString() {
        return "StavkaPorudzbina{" + "idPorudzbina=" + idPorudzbina + ", rb=" + rb + ", kolicina=" + kolicina + ", cena=" + cena + ", idProizvod=" + idProizvod + '}';
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
        final StavkaPorudzbina other = (StavkaPorudzbina) obj;
        if (this.idPorudzbina != other.idPorudzbina) {
            return false;
        }
        return this.rb == other.rb;
    }
    
    
    
    
}
