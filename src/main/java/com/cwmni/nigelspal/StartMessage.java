package com.cwmni.nigelspal;

/**
 * Message used to start a quiz, the number of questions required are supplied
 * to the constructor.
 */
final class StartMessage
{

    private final int myNumberOfQuestions;

    /**
     * Create new Start Quiz Command object
     *
     * @param theNumberOfQuestions - number of questions that should be in the
     * quiz.
     */
    public StartMessage(int theNumberOfQuestions)
    {
        myNumberOfQuestions = theNumberOfQuestions;
    }

    public String getMessage()
    {
        return "send me " + myNumberOfQuestions + " questions.";
    }

}
