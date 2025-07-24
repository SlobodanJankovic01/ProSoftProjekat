/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.musterija;

import domain.Musterija;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Slobodan
 */
public class SoUpdateMusterijaIT {

    private SoUpdateMusterija so;
    private Musterija musterija;

    @Before
    public void setUp() {
        so = new SoUpdateMusterija();
        musterija = new Musterija();
        musterija.setIme("Petar");
        musterija.setPrezime("Petrovic");
        musterija.setBrojTelefona("0641234567");
        musterija.setIdMesto(1);
    }

    @After
    public void tearDown() {
        so = null;
        musterija = null;
    }

    @Test
    public void testExecuteOperationSuccessful() {
        try {
            so.execute(musterija);
            assertTrue(so.getAffectedRows() >= 0);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidObject() throws Exception {
        so.validate(new Object());
    }

    @Test(expected = Exception.class)
    public void testValidationEmptyFields() throws Exception {
        musterija.setIme("");
        musterija.setPrezime("");
        musterija.setBrojTelefona("");
        so.validate(musterija);
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidPhoneFormat() throws Exception {
        musterija.setBrojTelefona("123"); // neispravno
        so.validate(musterija);
    }

    @Test(expected = Exception.class)
    public void testValidationMissingMesto() throws Exception {
        musterija.setIdMesto(0);
        so.validate(musterija);
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidImeFormat() throws Exception {
        musterija.setIme("P3tar");
        so.validate(musterija);
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidPrezimeFormat() throws Exception {
        musterija.setPrezime("Petrov1c");
        so.validate(musterija);
    }

}
