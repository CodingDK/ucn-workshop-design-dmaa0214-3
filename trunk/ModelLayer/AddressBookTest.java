package ModelLayer;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AddressBookTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AddressBookTest
{
    /**
     * Default constructor for test class AddressBookTest
     */
    public AddressBookTest()
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
    public void AddressBookTest()
    {
        assertNotNull(ModelLayer.AddressBook.getInstance());
        ModelLayer.AddressBook addressB1 = ModelLayer.AddressBook.getInstance();
        addressB1.createPerson("Nick", "Hovedgaden", 8832, "Skals", "+4560211988");
        assertNotNull(addressB1.getPerson(1));
        assertNotNull(addressB1.getAllPersons());
        ModelLayer.Person person1 = addressB1.getPerson(1);
        addressB1.deletePerson(person1);
    }
}

