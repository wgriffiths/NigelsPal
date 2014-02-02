package com.cwmni.nigelspal.messages;

import java.text.DecimalFormat;

/**
 *
 */
public final class AnswerMessage implements QuizMessage
{

    private static final String ANSWER_MESSAGE = "A%s. %s";
    private final String myAnswer;
    private final QuestionMessage myQuestion;
    private final DecimalFormat theAnswerFormat = new DecimalFormat("#.###");

    public AnswerMessage(QuestionMessage theQuestion)
    {
        myQuestion = theQuestion;
        myAnswer = getAnswer();
    }

    @Override
    public String getMessage()
    {
        return String.format(ANSWER_MESSAGE, myQuestion.getQuestionNumber(), myAnswer);
    }

    private String getAnswer()
    {
        String theOperator = myQuestion.getOperation();
        long theSecondNumber = myQuestion.getSecondNumber();
        long theFirstNumber = myQuestion.getFirstNumber();

        switch (theOperator)
        {
            case "+":
                return (theFirstNumber + theSecondNumber)+"";
            case "-":
                return (theFirstNumber - theSecondNumber)+"";
            case "/":
                return theAnswerFormat.format(theFirstNumber * 1.0 / theSecondNumber);
            case "*":
                return (theFirstNumber * theSecondNumber)+"";

        }

        throw new UnsupportedOperationException("The " + theOperator + " operator is not supported.");
    }

}
