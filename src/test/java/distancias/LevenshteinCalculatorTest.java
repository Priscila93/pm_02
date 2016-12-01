/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distancias;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marce
 */
public class LevenshteinCalculatorTest {
    
    public LevenshteinCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of DistanciaEntrePalavras method, of class LevenshteinCalculator.
     */
    @Test
    public void testDistanciaEntrePalavras() {
        System.out.println("DistanciaLevenshtein");
        String palavra_um = "a";
        String palavra_dois = "as";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 1;
        int result = instance.DistanciaEntrePalavras(palavra_um, palavra_dois);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void test2DistanciaLevenshtein() {
        System.out.println("DistanciaLevenshtein");
        String palavra_um = "a";
        String palavra_dois = "asa";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 2;
        int result = instance.DistanciaEntrePalavras(palavra_um, palavra_dois);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void test3DistanciaLevenshtein() {
        System.out.println("DistanciaLevenshtein");
        String palavra_um = "preocupar";
        String palavra_dois = "ocupar";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 3;
        int result = instance.DistanciaEntrePalavras(palavra_um, palavra_dois);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void test4DistanciaLevenshtein() {
        System.out.println("DistanciaLevenshtein");
        String palavra_um = "idealizado";
        String palavra_dois = "ideal";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 5;
        int result = instance.DistanciaEntrePalavras(palavra_um, palavra_dois);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void test5DistanciaLevenshtein() {
        System.out.println("DistanciaLevenshtein");
        String palavra_um = "gostoso";
        String palavra_dois = "gostosa";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 1;
        int result = instance.DistanciaEntrePalavras(palavra_um, palavra_dois);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void test6DistanciaLevenshtein() {
        System.out.println("DistanciaLevenshtein");
        String palavra_um = "cola";
        String palavra_dois = "cone";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 2;
        int result = instance.DistanciaEntrePalavras(palavra_um, palavra_dois);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void test7DistanciaLevenshtein() {
        System.out.println("DistanciaLevenshtein");
        String palavra_um = "embaixador";
        String palavra_dois = "embaixatriz";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 4;
        int result = instance.DistanciaEntrePalavras(palavra_um, palavra_dois);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void test8DistanciaLevenshtein() {
        System.out.println("DistanciaLevenshtein");
        String palavra_um = "embaixatriz";
        String palavra_dois = "embaixador";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 4;
        int result = instance.DistanciaEntrePalavras(palavra_um, palavra_dois);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void test9DistanciaLevenshtein() {
        System.out.println("DistanciaLevenshtein");
        String palavra_um = "";
        String palavra_dois = "embaixador";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 10;
        int result = instance.DistanciaEntrePalavras(palavra_um, palavra_dois);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void test10DistanciaLevenshtein() {
        System.out.println("DistanciaLevenshtein");
        String palavra_um = "embaixatriz";
        String palavra_dois = "";
        LevenshteinCalculator instance = new LevenshteinCalculator();
        int expResult = 11;
        int result = instance.DistanciaEntrePalavras(palavra_um, palavra_dois);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
