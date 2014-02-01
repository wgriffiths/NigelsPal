package com.cwmni.nigelspal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
final class Question
{

    enum Operation
    {
        ADD, SUBTRACT, DIVIDE, MULTIPLY
    };

    private static final String QUESTION_REGEX = "Q([0-9]*). What is ([0-9]*)(\\+|-|/|\\*)([0-9]*)?";
    private static final Pattern QUESTION_PATTERN = Pattern.compile(QUESTION_REGEX);
    private final int myQuestionNumber;
    private final int myFirstNumber;
    private final int mySecondNumber;
    private final String myOperator;

    public Question(String theQuestion)
    {
        Matcher theMatcher = QUESTION_PATTERN.matcher(theQuestion);

        if (!theMatcher.find())
        {
            throw new IllegalArgumentException("Invalid question format.");
        }

        myQuestionNumber = Integer.parseInt(theMatcher.group(1));
        myFirstNumber = Integer.parseInt(theMatcher.group(2));
        myOperator = theMatcher.group(3);
        mySecondNumber = Integer.parseInt(theMatcher.group(4));
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

        if ("+".equals(myOperator))
        {
            return Operation.ADD;
        }

        if ("-".equals(myOperator))
        {
            return Operation.SUBTRACT;
        }

        if ("/".equals(myOperator))
        {
            return Operation.DIVIDE;
        }

        if ("*".equals(myOperator))
        {
            return Operation.MULTIPLY;
        }

        throw new UnsupportedOperationException("The " + myOperator + " operator is not supported.");

    }

}
