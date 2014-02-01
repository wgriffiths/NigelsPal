package com.cwmni.nigelspal;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnswerTest
{

    @Test
    public void testGetMessage()
    {
        assertEquals("A1. 3", new Answer(1, 3).getMessage());
    }

    @Test
    public void testGetMessage_DiffrentQuestion()
    {
        assertEquals("A42. 3", new Answer(42, 3).getMessage());
    }
    
    @Test
    public void testGetMessage_ThreeDecimalPlaces()
    {
        assertEquals("A42. 87.333", new Answer(42, 87.3333).getMessage());
    }
    
     @Test
    public void testGetMessage_HalfEven()
    {
        assertEquals("A42. 2345687.334", new Answer(42, 2345687.3335).getMessage());
    }

}
