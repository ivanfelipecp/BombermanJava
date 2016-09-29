package bomberman;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BarrelTest {
    public static Barrel test;
    public BarrelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //(ArrayList<Characters> mobs, Element[][] matrix, int positionX, int positionY, ImageIcon image)
        ArrayList<Characters> mobs = new ArrayList<>();
        Element[][] element = new Element[35][35];
        test = new Barrel(mobs,element,32,18,Globals.getGlobals().getBarrel());
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
     * Test of move method, of class Barrel.
     */ /*
    @Test
    public void testMove() {
        System.out.println("move");
        int X = 0;
        int Y = 0;
        int x = 0;
        int y = 0;
        Barrel instance = null;
        boolean expResult = false;
        boolean result = instance.move(X, Y, x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    /**
     * Test of AI method, of class Barrel.
     */
    @Test
    public void testAICase1() {
        System.out.println("Test AI case 1");
        test.setPositionX(32);
        test.setPositionY(18);
        int expResult = -14;
        //int result = test.AI(20,15);
        //assertEquals("Prueba de IA",expResult,result);
    }
    
     @Test
    public void testAICase2() {
        System.out.println("Test AI case 2");
        test.setPositionX(8);
        test.setPositionY(6);
        int expResult = -3;
        //int result = test.AI(10,4);
        //assertEquals("Prueba de IA",expResult,result);
    }
    @Test
    public void testAICase3() {
        System.out.println("Test AI case 3");
        test.setPositionX(2);
        test.setPositionY(4);
        int expResult = 7;
        //int result = test.AI(6,8);
        //assertEquals("Prueba de IA",expResult,result);
    }
     @Test
    public void testAICase4() {
        System.out.println("Prueba AI case 4");
        test.setPositionX(10);
        test.setPositionY(2);
        int expResult = 13;
        //int result = test.AI(2,8);
        //assertEquals("Prueba de IA",expResult,result);
    }

    /**
     * Test of run method, of class Barrel.
     *//*
    @Test
    public void testRun() {
        System.out.println("run");
        Barrel instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of isDoor method, of class Barrel.
     */
    /*
    @Test
    public void testIsDoor() {
        System.out.println("isDoor");
        Barrel instance = null;
        boolean expResult = false;
        boolean result = instance.isDoor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of isPower method, of class Barrel.
     */
    /*
    @Test
    public void testIsPower() {
        System.out.println("isPower");
        Barrel instance = null;
        boolean expResult = false;
        boolean result = instance.isPower();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of isDanger method, of class Barrel.
     */
    /*
    @Test
    public void testIsDanger() {
        System.out.println("isDanger");
        Barrel instance = null;
        boolean expResult = false;
        boolean result = instance.isDanger();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
}
