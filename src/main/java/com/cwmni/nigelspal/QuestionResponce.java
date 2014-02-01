package com.cwmni.nigelspal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
final class QuestionResponce
{

    enum Operator
    {

        ADD, SUBTRACT, DIVIDE, MULTIPLY
    };

    private static final String QUESTION_REGEX = "Q([0-9]*). What is ([0-9]*)(\\+|-|/|\\*)([0-9]*)?";
    private static final Pattern QUESTION_PATTERN = Pattern.compile(QUESTION_REGEX);
    private final int myQuestionNumber;
    private final int myFirstNumber;
    private final int mySecondNumber;
    private final String myOperator;

    public QuestionResponce(String theQuestion)
    {
        Matcher theMatcher = QUESTION_PATTERN.matcher(theQuestion);

        theMatcher.find();

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

    public Operator getOperator()
    {

        if ("+".equals(myOperator))
        {
            return Operator.ADD;
        }

        if ("-".equals(myOperator))
        {
            return Operator.SUBTRACT;
        }
        
        if ("/".equals(myOperator))
        {
            return Operator.DIVIDE;
        }
        
        if ("*".equals(myOperator))
        {
            return Operator.MULTIPLY;
        }

        throw new UnsupportedOperationException("The " + myOperator + " operator is not supported.");

    }

}
