package com.cwmni.nigelspal.messages;

/**
 * Help message.
 */
public final class HelpMessage extends AbstractMessage
{

    private static final String HELP_MESSAGE = "Type help for help.";

    /**
     * @param theMessage - Message content
     */
    public HelpMessage(String theMessage)
    {
        super(theMessage);
    }

    /**
     * @param theMessage - String to test
     * @return true if supplied String is an help message, otherwise
     * false.
     */
    public static boolean isOne(String theMessage)
    {
        if (theMessage == null)
        {
            return false;
        }

        return HELP_MESSAGE.equals(theMessage);
    }

}
