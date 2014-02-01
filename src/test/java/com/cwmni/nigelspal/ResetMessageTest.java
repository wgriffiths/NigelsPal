package com.cwmni.nigelspal;

import org.junit.Test;
import static org.junit.Assert.*;

public class ResetMessageTest
{

    @Test
    public void testGetCommand()
    {
        assertEquals("reset", new ResetMessage().getMessage());
    }

}
