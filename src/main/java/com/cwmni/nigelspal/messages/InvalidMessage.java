package com.cwmni.nigelspal.messages;

/**
 *
 */
public final class InvalidMessage extends AbstractMessage
{
    private static final String INVALID = "Invalid";

    public InvalidMessage(String theMessage)
    {
        super(theMessage);
    }
    
    public static boolean isOne(String theMessage)
    {
        if (theMessage == null)
        {
            return false;
        }

        return theMessage.startsWith(INVALID);
    }

}

