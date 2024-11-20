/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Slobodan
 */
public class Musterija {
    
    private int idMusterija;
    private String ime;
    private String prezime;
    private String brojTelefona;
    private int idMesto;

    public Musterija() {
    }

    public Musterija(int idMusterija, String ime, String prezime, String brojTelefona, int idMesto) {
        this.idMusterija = idMusterija;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
        this.idMesto = idMesto;
    }

    
    public int getIdMusterija() {
        return idMusterija;
    }

    public void setIdMusterija(int idMusterija) {
        this.idMusterija = idMusterija;
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

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public int getIdMesto() {
        return idMesto;
    }

    public void setIdMesto(int idMesto) {
        this.idMesto = idMesto;
    }

    @Override
    public String toString() {
        return "Musterija{" + "idMusterija=" + idMusterija + ", ime=" + ime + ", prezime=" + prezime + ", brojTelefona=" + brojTelefona + ", idMesto=" + idMesto + '}';
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
        final Musterija other = (Musterija) obj;
        return this.idMusterija == other.idMusterija;
    }

    
    
}
