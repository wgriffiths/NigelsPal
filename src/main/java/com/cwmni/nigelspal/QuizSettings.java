package com.cwmni.nigelspal;

/**
 *
 */
final class QuizSettings
{

    private final Username myUserName;
    private final Password myPassword;
    private final NumberOfQuestions myNumberOfQuestions;

    public QuizSettings(Username theUserName, Password thePassword, NumberOfQuestions theNumberOfQuestions)
    {
        myUserName = theUserName;
        myPassword = thePassword;
        myNumberOfQuestions = theNumberOfQuestions;
    }

    public Username getUserName()
    {
        return myUserName;
    }

    public Password getPassword()
    {
        return myPassword;
    }

    public NumberOfQuestions getNumberOfQuestions()
    {
        return myNumberOfQuestions;
    }
    
    

}
