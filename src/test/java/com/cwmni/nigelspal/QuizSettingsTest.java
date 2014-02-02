
package com.cwmni.nigelspal;

import org.junit.Test;
import static org.junit.Assert.*;


public class QuizSettingsTest
{

    private final Username myUserName = new Username("A");
    private final Password myPassword = new Password("B");
    private final NumberOfQuestions myNumberOfQuestions = new NumberOfQuestions(42);
    private final QuizSettings instance = new QuizSettings(myUserName, myPassword, myNumberOfQuestions);

    @Test
    public void testGetUserName()
    {
        assertEquals(myUserName, instance.getUserName());
    }

    @Test
    public void testGetPassword()
    {
         assertEquals(myPassword, instance.getPassword());
    }

    @Test
    public void testGetNumberOfQuestions()
    {
         assertEquals(myNumberOfQuestions, instance.getNumberOfQuestions());
    }

}
