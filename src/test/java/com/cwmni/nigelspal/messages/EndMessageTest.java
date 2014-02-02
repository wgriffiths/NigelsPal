
package com.cwmni.nigelspal.messages;

import org.junit.Test;
import static org.junit.Assert.*;


public class EndMessageTest
{
    @Test
    public void testIsOne()
    {
        assertTrue(EndMessage.isOne("Quiz over - there are no more questions. You got 5 correct out of 10 (50%)"));
    }
    
     @Test
    public void testIsOne_NoQuestions()
    {
        assertTrue(EndMessage.isOne("There are no more questions."));
    }
    
     @Test
    public void testIsOne_Invalid()
    {
        assertFalse(EndMessage.isOne("bang boom."));
    }
    

    @Test
    public void testIsOne_Null()
    {
        assertFalse(EndMessage.isOne(null));
    }
    
}
