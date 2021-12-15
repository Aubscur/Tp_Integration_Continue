/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.froyo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author enzo.perez
 */
public class TriviaTest {

    public TriviaTest() {
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
     * Test of createRockQuestion method, of class Trivia.
     */
    @Test
    public void testCreateRockQuestion() {
        System.out.println("createRockQuestion");
        int index = 0;
        Trivia instance = new Trivia();
        String expResult = "Rock Question 0";
        String result = instance.createRockQuestion(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPlayable method, of class Trivia.
     */
    @Test
    public void testIsPlayable() {
        System.out.println("isPlayable");
        Trivia instance = new Trivia();
        boolean expResult = false;
        boolean result = instance.isPlayable();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class Trivia.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String playerName = "";
        Trivia instance = new Trivia();
        boolean expResult = true;
        boolean result = instance.add(playerName);
        assertEquals(expResult, result);

    }

    /**
     * Test of howManyPlayers method, of class Trivia.
     */
    @Test
    public void testHowManyPlayers() {
        System.out.println("howManyPlayers");
        Trivia instance = new Trivia();
        instance.players.add("TATA");
        int expResult = 1;
        int result = instance.howManyPlayers();
        assertEquals(expResult, result);
    }

    /**
     * Test of roll method, of class Trivia.
     */
    @Test
    public void testRoll() {
        System.out.println("roll");
        int roll = 0;
        Trivia instance = new Trivia();
        instance.roll(roll);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wasCorrectlyAnswered method, of class Trivia.
     */
    @Test
    public void testWasCorrectlyAnswered() {
        System.out.println("wasCorrectlyAnswered");
        Trivia instance = new Trivia();
        boolean expResult = false;
        boolean result = instance.wasCorrectlyAnswered();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wrongAnswer method, of class Trivia.
     */
    @Test
    public void testWrongAnswer() {
        System.out.println("wrongAnswer");
        Trivia instance = new Trivia();
        boolean expResult = true;
        System.out.println(instance.inPenaltyBox.length);
        boolean result = instance.wrongAnswer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
