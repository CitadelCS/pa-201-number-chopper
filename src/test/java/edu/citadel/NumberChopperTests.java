
/*
 * 
 * 
 * 
 * 
 * DO NOT MODIFY THIS FILE OR YOU WILL GET A ZERO.
 * 
 * 
 * 
 * 
 * 
 * 
 */

package edu.citadel;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Number Chopper.
 */
public class NumberChopperTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void shouldChop1234() {
        String consoleInput = "1234";
        InputStream in = new ByteArrayInputStream(consoleInput.getBytes());
        System.setIn(in);
        NumberChopper.main(null);
        String result = outContent.toString();
        assertTrue(result.contains("1-2-3-4".replaceAll("-", System.lineSeparator())));
    }

    @Test
    public void shouldChop5555() {
        String consoleInput = "5555";
        InputStream in = new ByteArrayInputStream(consoleInput.getBytes());
        System.setIn(in);
        NumberChopper.main(null);
        String result = outContent.toString();
        assertTrue(result.contains("5-5-5-5".replaceAll("-", System.lineSeparator())));
    }

    @Test
    public void shouldChop8765() {
        String consoleInput = "8765";
        InputStream in = new ByteArrayInputStream(consoleInput.getBytes());
        System.setIn(in);
        NumberChopper.main(null);
        String result = outContent.toString();
        assertTrue(result.contains("8-7-6-5".replaceAll("-", System.lineSeparator())));
    }

    @Test
    public void shouldReject123() {
        String consoleInput = "123";
        InputStream in = new ByteArrayInputStream(consoleInput.getBytes());
        System.setIn(in);
        NumberChopper.main(null);
        String result = outContent.toString().toLowerCase();
        assertTrue(result.contains("too small".replaceAll("-", System.lineSeparator())));
    }

    @Test
    public void shouldReject12345() {
        String consoleInput = "12345";
        InputStream in = new ByteArrayInputStream(consoleInput.getBytes());
        System.setIn(in);
        NumberChopper.main(null);
        String result = outContent.toString().toLowerCase();
        assertTrue(result.contains("too large".replaceAll("-", System.lineSeparator())));
    }

}