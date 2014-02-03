package com.cwmni.nigelspal.messages;

/**
 * Class used to display messages
 */
public final class MessageRenderer
{

    /**
     * Outputs message to standard out.
     *
     * @param theQuizMessage - Message to display
     */
    public void display(QuizMessage theQuizMessage)
    {
        System.out.println(" > " + theQuizMessage.getMessage());
    }

}
