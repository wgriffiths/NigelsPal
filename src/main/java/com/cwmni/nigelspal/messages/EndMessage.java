package com.cwmni.nigelspal.messages;

/**
 * Message sent to indicate quiz has finished.
 */
public final class EndMessage extends AbstractMessage
{

    private static final String NO_MORE_QUESTIONS = "there are no more questions";

    /**
     * @param theMessage - Message contents
     */
    public EndMessage(String theMessage)
    {
        super(theMessage);
    }

    /**
     * @param theMessage - String to test
     * @return true if supplied String is a valid end of quiz message, otherwise
     * false.
     */
    public static boolean isOne(String theMessage)
    {
        if (theMessage == null)
        {
            return false;
        }

        return theMessage.toLowerCase().contains(NO_MORE_QUESTIONS);
    }

}
