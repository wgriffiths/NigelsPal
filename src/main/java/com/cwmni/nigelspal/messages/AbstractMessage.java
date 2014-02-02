package com.cwmni.nigelspal.messages;

/**
 *
 */
abstract class AbstractMessage implements QuizMessage
{

    private final String myMessage;

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
