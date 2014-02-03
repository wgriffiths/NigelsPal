package com.cwmni.nigelspal.messages;

/**
 * Factory class for creating message objects from Strings i.e message contents.
 */
public final class QuizMessageFactory
{

    /**
     * @param theMessageBody - Message content
     * @return - QuizMessage created from string.
     */
    public QuizMessage get(String theMessageBody)
    {
        if (QuestionMessage.isOne(theMessageBody))
        {
            return new QuestionMessage(theMessageBody);
        }

        if (ErrorMessage.isOne(theMessageBody))
        {
            return new ErrorMessage(theMessageBody);
        }

        if (EndMessage.isOne(theMessageBody))
        {
            return new EndMessage(theMessageBody);
        }

        return new OtherMessage(theMessageBody);
    }

}
