/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.porudzbina;

import domain.Porudzbina;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Slobodan
 */
public class SoGetListPorudzbinaIT {

    SoGetListPorudzbina so;

    @Before
    public void setUp() {
        so = new SoGetListPorudzbina();
    }

    @After
    public void tearDown() {
        so = null;
    }

    @Test
    public void testExecuteOperation() {
        try {
            so.execute(new Porudzbina());
            assertNotNull(so.getPorudzbine());
            assertTrue(so.getPorudzbine().size() > 0);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void testValidationValidObject() {
        try {
            so.validate(new Porudzbina());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testValidationInvalidObject() throws Exception {
        so.validate(new Object());
    }

    @Test(expected = Exception.class)
    public void testValidationNullObject() throws Exception {
        so.validate(null);
    }
}
