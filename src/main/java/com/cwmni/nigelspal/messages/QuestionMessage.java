package com.cwmni.nigelspal.messages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public final class QuestionMessage implements QuizMessage
{

    public enum Operation
    {

        ADD, SUBTRACT, DIVIDE, MULTIPLY
    };

    private static final String QUESTION_REGEX = "Q([0-9]*). What is ([0-9]*)(\\+|-|/|\\*)([0-9]*)?";
    private static final Pattern QUESTION_PATTERN = Pattern.compile(QUESTION_REGEX);
    private final int myQuestionNumber;
    private final int myFirstNumber;
    private final int mySecondNumber;
    private final String myOperation;
    private final String myMessage;

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

    public int getQuestionNumber()
    {
        return myQuestionNumber;
    }

    public int getFirstNumber()
    {
        return myFirstNumber;
    }

    public int getSecondNumber()
    {
        return mySecondNumber;
    }

    public Operation getOperation()
    {

        if ("+".equals(myOperation))
        {
            return Operation.ADD;
        }

        if ("-".equals(myOperation))
        {
            return Operation.SUBTRACT;
        }

        if ("/".equals(myOperation))
        {
            return Operation.DIVIDE;
        }

        if ("*".equals(myOperation))
        {
            return Operation.MULTIPLY;
        }

        throw new UnsupportedOperationException("The " + myOperation + " operator is not supported.");

    }

}
