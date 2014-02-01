package com.cwmni.nigelspal;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 */
final class Answer implements QuizeMessage
{

    private static final String ANSWER_MESSAGE = "A%s. %s";
    private final int myQuestionNumber;
    private final String myAnswer;
    private final DecimalFormat myAnswerFormat = new DecimalFormat("#.###");

    public Answer(int theQuestionNumber, double theAnswer)
    {
        myAnswerFormat.setRoundingMode(RoundingMode.HALF_EVEN);
        myQuestionNumber = theQuestionNumber;
        myAnswer = myAnswerFormat.format(theAnswer);
    }

    @Override
    public String getMessage()
    {
        return String.format(ANSWER_MESSAGE, myQuestionNumber, myAnswer);
    }

}
