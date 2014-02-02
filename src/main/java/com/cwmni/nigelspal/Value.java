package com.cwmni.nigelspal;

/**
 * Used to create wrapper value objects
 */
abstract class Value<I>
{

    private final I myValue;

    /**
     * Create new 
     * @param theValue - The value represented by the object.
     */
    protected Value(I theValue)
    {
        myValue = theValue;
    }

    /**
     * @return value represented by the object.
     */
    public I getValue()
    {
        return myValue;
    }

}
