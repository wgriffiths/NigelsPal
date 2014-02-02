package com.cwmni.nigelspal.messages;

/**
 *
 */
public final class EndMessage extends AbstractMessage
{
    private static final String NO_MORE_QUESTIONS = "there are no more questions";

    public EndMessage(String theMessage)
    {
        super(theMessage);
    }
    
    public static boolean isOne(String theMessage)
    {
        if (theMessage == null)
        {
            return false;
        }

        return theMessage.toLowerCase().contains(NO_MORE_QUESTIONS);
    }


}
