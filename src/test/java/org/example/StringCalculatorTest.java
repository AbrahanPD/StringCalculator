package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    public void testAddEmptyString(){
        assertEquals(0, StringCalculator.add(""));
    }
    @Test
    public void testAddOneString(){
        assertEquals(1, StringCalculator.add("1"));
    }
    @Test
    public void testAddTwoStrings(){
        assertEquals(3, StringCalculator.add("1,2"));
    }
    @Test
    public void testAddUnknownAmountOfNumbers(){
        assertEquals(10, StringCalculator.add("1,2,3,4"));
    }
    @Test
    public void testAddNewLinesBetweenNumbers(){
        assertEquals(6,StringCalculator.add("1\n2,3"));
    }
    @Test
    public void testAddSupportDifferentDelimiters(){
        assertEquals(3,StringCalculator.add("//;\n1;2"));
    }
    @Test
    public void testAddSupportNegativeNumber(){
        assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("1,-2,3");
        });
    }
}
