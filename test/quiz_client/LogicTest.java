/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_client;

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
public class LogicTest {
    
    public LogicTest() {
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
     * Test of newQuestionRequest method, of class Logic.
     */
    @Test
    public void testNewQuestionRequest() throws Exception {
        System.out.println("newQuestionRequest");
        Logic instance = null;
        instance.newQuestionRequest();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuestionGUI method, of class Logic.
     */
    @Test
    public void testSetQuestionGUI() {
        System.out.println("setQuestionGUI");
        Logic instance = null;
        instance.setQuestionGUI();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestion method, of class Logic.
     */
    @Test
    public void testGetQuestion() throws Exception {
        System.out.println("getQuestion");
        Logic instance = null;
        String expResult = "";
        String result = instance.getQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswers method, of class Logic.
     */
    @Test
    public void testGetAnswers() throws Exception {
        System.out.println("getAnswers");
        Logic instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getAnswers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of correctAnswer method, of class Logic.
     */
    @Test
    public void testCorrectAnswer() throws Exception {
        System.out.println("correctAnswer");
        int i = 0;
        Logic instance = null;
        boolean expResult = false;
        boolean result = instance.correctAnswer(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitServer method, of class Logic.
     */
    @Test
    public void testExitServer() throws Exception {
        System.out.println("exitServer");
        Logic instance = null;
        instance.exitServer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
