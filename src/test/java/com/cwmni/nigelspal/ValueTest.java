package com.cwmni.nigelspal;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValueTest {

    @Test
    public void testGetValue()
    {
        assertEquals("boom", new ValueImpl("boom").getValue());
    }

    public class ValueImpl extends Value<String>
    {

        public ValueImpl(String theValue)
        {
            super(theValue);
        }
    }


}