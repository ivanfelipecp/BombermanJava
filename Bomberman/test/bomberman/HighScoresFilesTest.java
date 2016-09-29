package bomberman;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HighScoresFilesTest {
    
    public static HighScoresFiles test;
    
    public HighScoresFilesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        test = new HighScoresFiles();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFile method, of class HighScoresFiles.
     */
    /*
    @Test
    public void testGetFile() {
        System.out.println("getFile");
        int difficult = 0;
        String expResult = "";
        String result = test.getFile(difficult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    */
    /**
     * Test of setFile method, of class HighScoresFiles.
     */
    /*
    @Test
    public void testSetFile() {
        System.out.println("setFile");
        int difficult = 0;
        String[] array = null;
        HighScoresFiles instance = new HighScoresFiles();
        instance.setFile(difficult, array);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of isGreater method, of class HighScoresFiles.
     */
    @Test
    public void testIsGreater() {
        System.out.println("isGreater");
        int difficult = 15;
        int score = 1;

        boolean expResult = true;
        boolean result = test.isGreater(difficult, score);
        assertEquals("isGreater test",expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of newHighScore method, of class HighScoresFiles.
     */
    /*
    @Test
    public void testNewHighScore() {
        System.out.println("newHighScore");
        int difficult = 0;
        int score = 0;
        String name = "";
        HighScoresFiles instance = new HighScoresFiles();
        instance.newHighScore(difficult, score, name);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    */

    /**
     * Test of contains method, of class HighScoresFiles.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        int number = 6;
        int[] array = {5,6,7,8};

        boolean expResult = true;
        boolean result = test.contains(number, array);
        assertEquals("Test contains",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
