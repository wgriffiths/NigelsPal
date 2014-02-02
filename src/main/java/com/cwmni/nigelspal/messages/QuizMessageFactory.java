package com.cwmni.nigelspal.messages;

/**
 *
 */
public class QuizMessageFactory
{

    private final String myMessageBody;

    public QuizMessageFactory(String theMessageBody)
    {
        myMessageBody = theMessageBody;
    }

    public QuizMessage get()
    {
        if (QuestionMessage.isOne(myMessageBody))
        {
            return new QuestionMessage(myMessageBody);
        }

        if (InvalidMessage.isOne(myMessageBody))
        {
            return new InvalidMessage(myMessageBody);
        }

        if (EndMessage.isOne(myMessageBody))
        {
            return new EndMessage(myMessageBody);
        }

        return new OtherMessage(myMessageBody);
    }

}
