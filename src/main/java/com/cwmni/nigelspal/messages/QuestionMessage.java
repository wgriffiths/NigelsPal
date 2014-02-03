package com.cwmni.nigelspal.messages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Question Message
 */
public final class QuestionMessage implements QuizMessage
{

    private static final String QUESTION_REGEX = "Q([0-9]*). What is ([0-9]*)(\\+|-|/|\\*)([0-9]*)?";
    private static final Pattern QUESTION_PATTERN = Pattern.compile(QUESTION_REGEX);
    private final int myQuestionNumber;
    private final int myFirstNumber;
    private final int mySecondNumber;
    private final String myOperation;
    private final String myMessage;

    /**
     *
     * @param theMessage - the message content.
     */
    public QuestionMessage(String theMessage)
    {
        myMessage = theMessage;
        Matcher theMatcher = QUESTION_PATTERN.matcher(theMessage);

        if (!theMatcher.find())
        {
            throw new IllegalArgumentException("Invalid question format.");
        }

        myQuestionNumber = Integer.parseInt(theMatcher.group(1));
        myFirstNumber = Integer.parseInt(theMatcher.group(2));
        myOperation = theMatcher.group(3);
        mySecondNumber = Integer.parseInt(theMatcher.group(4));
    }

    /**
     * @param theMessage - String to test
     * @return true if supplied String is a valid question message, otherwise
     * false.
     */
    public static boolean isOne(String theMessage)
    {
        if (theMessage == null)
        {
            return false;
        }

        return QUESTION_PATTERN.matcher(theMessage).find();
    }

    @Override
    public String getMessage()
    {
        return myMessage;
    }

    /**
     * @return - Number of question.
     */
    public int getQuestionNumber()
    {
        return myQuestionNumber;
    }

    /**
     * @return First number in question
     */
    public int getFirstNumber()
    {
        return myFirstNumber;
    }

    /**
     * @return second number in question.
     */
    public int getSecondNumber()
    {
        return mySecondNumber;
    }

    /**
     * @return Operation requested in question.
     */
    public String getOperation()
    {
        return myOperation;
    }

}
