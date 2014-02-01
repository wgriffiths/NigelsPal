package com.cwmni.nigelspal;

/**
 * Message used to start a quiz, the number of questions required are supplied
 * to the constructor.
 */
final class StartQuiz implements QuizeMessage
{
    private static final String START_MESSAGE = "send me %s questions.";
    private final int myNumberOfQuestions;

    /**
     * Create new Start Quiz Command object
     *
     * @param theNumberOfQuestions - number of questions that should be in the
     * quiz.
     */
    public StartQuiz(int theNumberOfQuestions)
    {
        myNumberOfQuestions = theNumberOfQuestions;
    }

    @Override
    public String getMessage()
    {
        return String.format(START_MESSAGE, myNumberOfQuestions);
    }

}
