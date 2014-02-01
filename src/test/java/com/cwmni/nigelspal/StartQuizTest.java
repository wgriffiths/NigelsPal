package com.cwmni.nigelspal;

import org.junit.Test;
import static org.junit.Assert.*;


public class StartQuizTest
{
    
    @Test
    public void testGetMessage()
    {
        assertEquals("send me 1 questions.", new StartQuiz(1).getMessage());
    }
    
     @Test
    public void testGetMessage_DiffrentNumber()
    {
        assertEquals("send me 5 questions.", new StartQuiz(5).getMessage());
    }
    
}
