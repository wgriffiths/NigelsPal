package com.cwmni.nigelspal;

import org.junit.Test;
import static org.junit.Assert.*;

public class ResetQuizTest
{

    @Test
    public void testGetCommand()
    {
        assertEquals("reset", new ResetQuiz().getMessage());
    }

}
