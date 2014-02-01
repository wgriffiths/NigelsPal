package com.cwmni.nigelspal;

/**
 *
 */
final class ResetQuiz implements QuizeMessage
{

    private static final String RESET_MESSAGE = "reset";

    @Override
    public String getMessage()
    {
        return RESET_MESSAGE;
    }

}
