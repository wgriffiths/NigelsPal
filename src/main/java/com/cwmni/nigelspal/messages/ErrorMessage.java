package com.cwmni.nigelspal.messages;

/**
 * This message is returned if an error was detected.
 */
public final class ErrorMessage extends AbstractMessage
{

    private static final String INVALID = "Invalid";

    /**
     * @param theMessage - Message content
     */
    public ErrorMessage(String theMessage)
    {
        super(theMessage);
    }

    /**
     * @param theMessage - String to test
     * @return true if supplied String is an error quiz message, otherwise
     * false.
     */
    public static boolean isOne(String theMessage)
    {
        if (theMessage == null)
        {
            return false;
        }

        return theMessage.startsWith(INVALID);
    }

}
