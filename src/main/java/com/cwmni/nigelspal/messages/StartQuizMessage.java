package com.cwmni.nigelspal.messages;


/**
 * Message used to start a quiz, the number of questions required are supplied
 * to the constructor.
 */
public final class StartQuizMessage implements QuizMessage
{
    private static final String START_MESSAGE = "send me %s questions.";
    private final int myNumberOfQuestions;

    /**
     * Create new Start Quiz Command object
     *
     * @param theNumberOfQuestions - number of questions that should be in the
     * quiz.
     */
    public StartQuizMessage(int theNumberOfQuestions)
    {
        myNumberOfQuestions = theNumberOfQuestions;
    }

    @Override
    public String getMessage()
    {
        return String.format(START_MESSAGE, myNumberOfQuestions);
    }

}
