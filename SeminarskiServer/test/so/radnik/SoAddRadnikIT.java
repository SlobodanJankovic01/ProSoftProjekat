/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package so.radnik;

import domain.Radnik;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SoAddRadnikIT {

    private SoAddRadnik so;
    private Radnik radnik;

    @Before
    public void setUp() {
        so = new SoAddRadnik();
        radnik = new Radnik();
    }

    @After
    public void tearDown() {
        so = null;
        radnik = null;
    }

    @Test
    public void testExecuteOperationSuccessful() {
        try {
            radnik.setIme("Marko");
            radnik.setPrezime("Markovic");
            radnik.setKorIme("mmarko");
            radnik.setLoznika("sifra123");

            so.execute(radnik);

            assertTrue("ID mora biti veći od 0", so.getId() > 0);
        } catch (Exception e) {
            fail("Nije smeo da baci izuzetak: " + e.getMessage());
        }
    }

    @Test
    public void testValidationValidObject() {
        try {
            radnik.setIme("Petar");
            radnik.setPrezime("Petrovic");
            radnik.setKorIme("ppetrovic");
            radnik.setLoznika("tajna123");

            so.validate(radnik);
        } catch (Exception e) {
            fail("Validan objekat ne sme izazvati izuzetak: " + e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidObject() throws Exception {
        so.validate(new Object());
    }

    @Test(expected = Exception.class)
    public void testValidationEmptyIme() throws Exception {
        radnik.setIme("");
        radnik.setPrezime("Prezime");
        radnik.setKorIme("korisnik");
        radnik.setLoznika("lozinka");

        so.validate(radnik);
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidImeFormat() throws Exception {
        radnik.setIme("M4rk0");
        radnik.setPrezime("Markovic");
        radnik.setKorIme("korisnik");
        radnik.setLoznika("lozinka");

        so.validate(radnik);
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidPrezimeFormat() throws Exception {
        radnik.setIme("Marko");
        radnik.setPrezime("123Prezime");
        radnik.setKorIme("korisnik");
        radnik.setLoznika("lozinka");

        so.validate(radnik);
    }
}
