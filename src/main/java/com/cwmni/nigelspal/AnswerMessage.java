package com.cwmni.nigelspal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 */
final class AnswerMessage
{
    private final int myQuestionNumber;
    private final String myAnswer;
    private final DecimalFormat myAnswerFormat = new DecimalFormat("#.###");

    public AnswerMessage(int theQuestionNumber, double theAnswer)
    {
        myAnswerFormat.setRoundingMode(RoundingMode.HALF_EVEN);
        
        myQuestionNumber = theQuestionNumber;
        myAnswer = myAnswerFormat.format(theAnswer);
    }

    public String getMessage()
    {
        return "A" + myQuestionNumber + ". " + myAnswer;
    }

}
