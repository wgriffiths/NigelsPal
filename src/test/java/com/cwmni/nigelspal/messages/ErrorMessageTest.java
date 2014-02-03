package com.cwmni.nigelspal.messages;

import org.junit.Test;
import static org.junit.Assert.*;

public class ErrorMessageTest
{

    @Test
    public void testIsOne()
    {
        assertTrue(ErrorMessage.isOne("Invalid bla bla bla"));
    }

    @Test
    public void testIsOne_Invalid()
    {
        assertFalse(ErrorMessage.isOne("bla bla bla"));
    }

    @Test
    public void testIsOne_Null()
    {
        assertFalse(ErrorMessage.isOne(null));
    }

}
