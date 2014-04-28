package ModelLayer;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestUnit.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestUnit
{
    private ModelLayer.AddressBook addressB1;

    
    

    /**
     * Default constructor for test class TestUnit
     */
    public TestUnit()
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
        addressB1 = new ModelLayer.AddressBook();
        addressB1.createPerson("Lavet", "Lavet", 4, "addressbook", "med");
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
}
