/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.time.LocalTime;
/**
 *
 * @author Slobodan
 */
public class RadnaSmena implements Serializable{
    
    private int idRadnaSmena;
    private String naziv;
    private LocalTime vremeOd;
    private LocalTime vremeDo;

    public RadnaSmena() {
    }

    public RadnaSmena(int idRadnaSmena, String naziv, LocalTime vremeOd, LocalTime vremeDo) {
        this.idRadnaSmena = idRadnaSmena;
        this.naziv = naziv;
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
    }

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

    public LocalTime getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(LocalTime vremeOd) {
        this.vremeOd = vremeOd;
    }

    public LocalTime getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(LocalTime vremeDo) {
        this.vremeDo = vremeDo;
    }

    @Override
    public String toString() {
        return "RadnaSmena{" + "idRadnaSmena=" + idRadnaSmena + ", naziv=" + naziv + ", vremeOd=" + vremeOd + ", vremeDo=" + vremeDo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final RadnaSmena other = (RadnaSmena) obj;
        return this.idRadnaSmena == other.idRadnaSmena;
    }


    
    
}
