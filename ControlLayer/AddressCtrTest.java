package ControlLayer;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AddressCtrTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AddressCtrTest
{
    /**
     * Default constructor for test class AddressCtrTest
     */
    public AddressCtrTest()
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
    public void AddressTest()
    {
        ControlLayer.AddressCtr addressC1 = new ControlLayer.AddressCtr();
        addressC1.createPerson("Lasse", "Aalborg", 8800, "ASD", "+4598642601");
        addressC1.changeLocation(1, "Noget", 9820, "Jamen ja!");
        addressC1.changePhone(1, "60211988");
        addressC1.changeName(1, "Nick");
        assertEquals("Nick", addressC1.getNameByID(1));
        assertNotNull(addressC1.getPersonInfo(1));
        assertNotNull(addressC1.listAllPersons());
        addressC1.deletePerson(1);
    }
}

