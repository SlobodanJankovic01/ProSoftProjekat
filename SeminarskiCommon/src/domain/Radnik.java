/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Slobodan
 */
public class Radnik implements Serializable{
    
    private String ime;
    private String prezime;
    private String korIme;
    private String loznika;

    public Radnik() {
    }

    public Radnik(String ime, String prezime, String korIme, String loznika) {
        this.ime = ime;
        this.prezime = prezime;
        this.korIme = korIme;
        this.loznika = loznika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getLoznika() {
        return loznika;
    }

    public void setLoznika(String loznika) {
        this.loznika = loznika;
    }

    @Override
    public String toString() {
        return "Radnik{" + "ime=" + ime + ", prezime=" + prezime + ", korIme=" + korIme + ", loznika=" + loznika + '}';
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
        final Radnik other = (Radnik) obj;
        if (!Objects.equals(this.korIme, other.korIme)) {
            return false;
        }
        return Objects.equals(this.loznika, other.loznika);
    }
    
    
    
    
}
