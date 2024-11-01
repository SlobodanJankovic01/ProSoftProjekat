/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Slobodan
 */
public class Proizvod {
    
    private int idProizvod;
    private String naziv;
    private int jedinicnaCena;

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
        return "Proizvod{" + "idProizvod=" + idProizvod + ", naziv=" + naziv + ", jedinicnaCena=" + jedinicnaCena + '}';
    }
    
    
    
    
}
