package com.cwmni.nigelspal.messages;


/**
 *
 */
public final class ResetQuizMessage implements QuizMessage
{

    private static final String RESET_MESSAGE = "reset";

    @Override
    public String getMessage()
    {
        return RESET_MESSAGE;
    }
}
