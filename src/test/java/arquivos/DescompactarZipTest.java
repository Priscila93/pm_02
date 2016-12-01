/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


/**
 *
 * @author marce
 */
public class DescompactarZipTest {
    
    public DescompactarZipTest() {
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
     * Test of ExtrairConteudoZip method, of class DescompactarZip.
     */
    @org.junit.Test
    public void testExtrairConteudoZip() {
        System.out.println("ExtrairConteudoZip");
        String nome_arquivo = "dictionary_pt-br.zip";
        DescompactarZip instance = new DescompactarZip();
        instance.ExtrairConteudoZip(nome_arquivo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
