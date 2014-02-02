package com.cwmni.nigelspal.messages;

import org.junit.Test;
import static org.junit.Assert.*;


public class StartQuizMessageTest
{
    
    @Test
    public void testGetMessage()
    {
        assertEquals("send me 1 questions.", new StartQuizMessage(1).getMessage());
    }
    
     @Test
    public void testGetMessage_DiffrentNumber()
    {
        assertEquals("send me 5 questions.", new StartQuizMessage(5).getMessage());
    }
    
}
