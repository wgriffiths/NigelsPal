

package com.cwmni.nigelspal.messages;

import org.junit.Test;
import static org.junit.Assert.*;

public class HelpMessageTest {

    @Test
    public void testIsOne()
    {
        assertTrue(HelpMessage.isOne("Type help for help."));
    }

    @Test
    public void testIsOne_Invalid()
    {
        assertFalse(HelpMessage.isOne("bla bla bla"));
    }

    @Test
    public void testIsOne_Null()
    {
        assertFalse(HelpMessage.isOne(null));
    }


}