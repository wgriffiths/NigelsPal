
package com.cwmni.nigelspal;

import org.junit.Test;
import static org.junit.Assert.*;


public class UsernameTest
{
    
   @Test
    public void testGetValue()
    {
        String expected = "boombang";
        String result = new Username(expected).getValue();
        assertEquals(expected, result);
    }
    
}
