/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Slobodan
 */
public class RadnikRadnaSmena implements Serializable{
    
    private int id;
    private int idRadnik;
    private int idRadnaSmena;
    private LocalDate datum;

    public RadnikRadnaSmena() {
    }

    public RadnikRadnaSmena(int id, int idRadnik, int idRadnaSmena, LocalDate datum) {
        this.id = id;
        this.idRadnik = idRadnik;
        this.idRadnaSmena = idRadnaSmena;
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRadnik() {
        return idRadnik;
    }

    public void setIdRadnik(int idRadnik) {
        this.idRadnik = idRadnik;
    }

    public int getIdRadnaSmena() {
        return idRadnaSmena;
    }

    public void setIdRadnaSmena(int idRadnaSmena) {
        this.idRadnaSmena = idRadnaSmena;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "RadnikRadnaSmena{" + "id=" + id + ", idRadnik=" + idRadnik + ", idRadnaSmena=" + idRadnaSmena + ", datum=" + datum + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final RadnikRadnaSmena other = (RadnikRadnaSmena) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idRadnik != other.idRadnik) {
            return false;
        }
        return this.idRadnaSmena == other.idRadnaSmena;
    }
    
     
}
