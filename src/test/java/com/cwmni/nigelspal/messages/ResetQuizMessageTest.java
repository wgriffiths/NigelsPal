package com.cwmni.nigelspal.messages;

import org.junit.Test;
import static org.junit.Assert.*;

public class ResetQuizMessageTest
{

    @Test
    public void testGetCommand()
    {
        assertEquals("reset", new ResetQuizMessage().getMessage());
    }

}
