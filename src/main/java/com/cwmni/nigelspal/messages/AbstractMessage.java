package com.cwmni.nigelspal.messages;

/**
 * Abstract class used to create simple text based messages.
 */
abstract class AbstractMessage implements QuizMessage
{

    private final String myMessage;

    /**
     * @param theMessage - Text contents of message
     */
    protected AbstractMessage(String theMessage)
    {
        myMessage = theMessage;
    }

    @Override
    public String getMessage()
    {
        return myMessage;
    }

}
