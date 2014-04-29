package ModelLayer;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DVDContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DVDContainerTest
{
    /**
     * Default constructor for test class DVDContainerTest
     */
    public DVDContainerTest()
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
    public void DVDContainerTest()
    {
        ModelLayer.DVDContainer dVDConta1 = ModelLayer.DVDContainer.getInstance();
        assertNotNull(dVDConta1);
        dVDConta1.createDVD("Batman 2", "Lars", "01-02-2014");
        assertNotNull(dVDConta1.getDVD(1));
        assertNotNull(dVDConta1.getAllDVDs());
        dVDConta1.deleteDVD(1);
    }
}

