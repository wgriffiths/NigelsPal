package com.cwmni.nigelspal;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberOfQuestionsTest
{

    @Test
    public void testGetValue()
    {
        int expected = 42;
        int result = new NumberOfQuestions(expected).getValue();
        assertEquals(expected, result);
    }

}
