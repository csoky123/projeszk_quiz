/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionHandler;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lexike
 */
public class ServerConnectionTest {
    
    public ServerConnectionTest() {
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
     * Test of nextQuestion method, of class ServerConnection.
     */
    @Test
    public void testNextQuestion() throws IOException{
        System.out.println("nextQuestion");
        ServerConnection instance = new ServerConnection();
        String expResult = "";
        String result = instance.nextQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswers method, of class ServerConnection.
     */
    @Test
    public void testGetAnswers() throws IOException{
        System.out.println("getAnswers");
        ServerConnection instance = new ServerConnection();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAnswers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCorrect method, of class ServerConnection.
     */
    @Test
    public void testIsCorrect() throws IOException{
        System.out.println("isCorrect");
        String answer = "";
        ServerConnection instance = new ServerConnection();
        Boolean expResult = null;
        Boolean result = instance.isCorrect(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCorrectAnswer method, of class ServerConnection.
     */
    @Test
    public void testGetCorrectAnswer() throws IOException{
        System.out.println("getCorrectAnswer");
        ServerConnection instance = new ServerConnection();
        String expResult = "";
        String result = instance.getCorrectAnswer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quit method, of class ServerConnection.
     */
    @Test
    public void testQuit() throws Exception {
        System.out.println("quit");
        ServerConnection instance = new ServerConnection();
        instance.quit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
