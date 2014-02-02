package com.cwmni.nigelspal;

/**
 * Class used to store settings used to create and run a quiz.
 */
final class QuizSettings
{

    private final Username myUserName;
    private final Password myPassword;
    private final NumberOfQuestions myNumberOfQuestions;

    /**
     * Create Quiz Settings
     *
     * @param theUserName - username used to log in to the server.
     * @param thePassword - password used to log in to the server.
     * @param theNumberOfQuestions - number of questions in the quiz.
     */
    public QuizSettings(Username theUserName, Password thePassword, NumberOfQuestions theNumberOfQuestions)
    {
        myUserName = theUserName;
        myPassword = thePassword;
        myNumberOfQuestions = theNumberOfQuestions;
    }

    /**
     * @return The username
     */
    public Username getUserName()
    {
        return myUserName;
    }

    /**
     * @return The password
     */
    public Password getPassword()
    {
        return myPassword;
    }

    /**
     * @return The number of questions in the quiz
     */
    public NumberOfQuestions getNumberOfQuestions()
    {
        return myNumberOfQuestions;
    }

}
