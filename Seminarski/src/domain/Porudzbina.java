/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Date;

/**
 *
 * @author Slobodan
 */
public class Porudzbina {
    
    private int idPorudzbina;
    private String nacinIsporuke;
    private int ukupnaCena;
    //Ovde sam stavio dateTime u seminarskom!!!!
    private Date datumVreme;
    private String napomena;

    public int getIdPorudzbina() {
        return idPorudzbina;
    }

    public void setIdPorudzbina(int idPorudzbina) {
        this.idPorudzbina = idPorudzbina;
    }

    public String getNacinIsporuke() {
        return nacinIsporuke;
    }

    public void setNacinIsporuke(String nacinIsporuke) {
        this.nacinIsporuke = nacinIsporuke;
    }

    public int getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(int ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String toString() {
        return "Porudzbina{" + "idPorudzbina=" + idPorudzbina + ", nacinIsporuke=" + nacinIsporuke + ", ukupnaCena=" + ukupnaCena + ", datumVreme=" + datumVreme + ", napomena=" + napomena + '}';
    }
    
    
    
    
    
    
}
