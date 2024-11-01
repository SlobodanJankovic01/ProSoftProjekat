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

    @Override
    public String toString() {
        return "Musterija{" + "idMusterija=" + idMusterija + ", ime=" + ime + ", prezime=" + prezime + ", brojTelefona=" + brojTelefona + '}';
    }
    
    
}
