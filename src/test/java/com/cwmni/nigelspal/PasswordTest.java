package com.cwmni.nigelspal;

import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordTest
{

    @Test
    public void testGetValue()
    {
        String expected = "value1";
        String result = new Password(expected).getValue();
        assertEquals(expected, result);
    }

}
