
package com.cwmni.nigelspal.messages;

import org.junit.Test;
import static org.junit.Assert.*;


public class AbstractMessageTest
{

    @Test
    public void testGetMessage()
    {
        String theMessage = "hello mum";
        assertEquals(theMessage,new AbstractMessageImpl(theMessage).getMessage());
    }

    public class AbstractMessageImpl extends AbstractMessage
    {

        public AbstractMessageImpl(String theMessage)
        {
            super(theMessage);
        }
    }
    
}
