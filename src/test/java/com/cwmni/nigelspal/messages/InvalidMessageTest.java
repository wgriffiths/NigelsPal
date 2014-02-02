package com.cwmni.nigelspal.messages;

import org.junit.Test;
import static org.junit.Assert.*;

public class InvalidMessageTest
{

    @Test
    public void testIsOne()
    {
        assertTrue(InvalidMessage.isOne("Invalid bla bla bla"));
    }

    @Test
    public void testIsOne_Invalid()
    {
        assertFalse(InvalidMessage.isOne("bla bla bla"));
    }

    @Test
    public void testIsOne_Null()
    {
        assertFalse(InvalidMessage.isOne(null));
    }

}
