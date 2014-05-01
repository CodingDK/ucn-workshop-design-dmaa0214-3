package ControlLayer;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class UnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UnitTest
{
    /**
     * Default constructor for test class UnitTest
     */
    public UnitTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testAll(){
        ControlLayer.AddressCtr addressC1 = new ControlLayer.AddressCtr();
        ControlLayer.DVDCtr dVDCtr1 = new ControlLayer.DVDCtr();
        ControlLayer.LoanCtr loanCtr1 = new ControlLayer.LoanCtr();
        dVDCtr1.createDVD("Batman", "None", 2000);
        assertEquals("Batman", dVDCtr1.getTitleByID(1));
        assertNotNull(dVDCtr1.getDVD(1));
        assertNotNull(dVDCtr1.listAllDVDs());
        dVDCtr1.addCopy(1, "01-01-2013", 150);
        dVDCtr1.addCopy(1, "02-02-2014", 110);
        dVDCtr1.updateDVD(1, "Batman 2", "Lau", 2000);
        assertEquals("Batman 2", dVDCtr1.getTitleByID(1));
        dVDCtr1.updateCopy(1, 1001, "01-01-0000", 100);
        java.lang.String string1 = dVDCtr1.getDVDInfo(1);
        assertNotNull(string1);
        ModelLayer.DVD dVD1 = dVDCtr1.getDVD(1);
        assertNotNull(dVD1);
        ModelLayer.Copy copy1 = dVD1.getAvailableCopy();
        assertNotNull(copy1);
        assertEquals("01-01-0000", dVDCtr1.getDVD(1).getCopy(1001).getPurchaseDate());
        addressC1.createPerson("Nick", "None", 8832, "Skals", "60211988");
        assertEquals("Nick", addressC1.getNameByID(1));
        addressC1.changeName(1, "Lau");
        assertEquals("Lau", addressC1.getNameByID(1));
        ModelLayer.Person person1 = addressC1.getPerson(1);
        assertNotNull(person1);
        assertEquals(1, person1.getID());
        assertNotNull(addressC1.getPersonInfo(1));
        assertEquals(true, loanCtr1.hasCopies(1));
        assertEquals("Batman 2", loanCtr1.getDVDTitleByID(1));

        LoanCtr lCtr = new LoanCtr();
        
        ArrayList<Integer> loan = new ArrayList<Integer>();
        loan.add(1);
        lCtr.personExist(1);
        lCtr.createLoan(loan);
        
        assertNotNull(lCtr.getLoansByID(1));
        
        ArrayList<Integer> loan2 = new ArrayList<Integer>();
        loan2.add(1);
        lCtr.personExist(1);
        lCtr.createLoan(loan2);
        
        assertNotNull(lCtr.getLoansByID(1));
    }
}

