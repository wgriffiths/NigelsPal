package com.cwmni.nigelspal.messages;

import java.text.DecimalFormat;

/**
 * Answer message, implements QuizMessage interface
 */
public final class AnswerMessage implements QuizMessage
{

    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String MINUS = "-";
    private static final String PLUS = "+";
    private static final String ANSWER_MESSAGE = "A%s. %s";
    private final String myAnswer;
    private final QuestionMessage myQuestion;
    private final DecimalFormat theAnswerFormat = new DecimalFormat("#.###");

    /**
     * @param theQuestion - Question that will be answered.
     */
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
            case PLUS:
                return Long.toString(theFirstNumber + theSecondNumber);
            case MINUS:
                return Long.toString(theFirstNumber - theSecondNumber);
            case DIVIDE:
                return theAnswerFormat.format(theFirstNumber * 1.0 / theSecondNumber);
            case MULTIPLY:
                return Long.toString(theFirstNumber * theSecondNumber);

        }

        throw new UnsupportedOperationException("The " + theOperator + " operator is not supported.");
    }

}
