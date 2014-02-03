package com.cwmni.nigelspal;

import org.apache.commons.cli.HelpFormatter;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(
        {
            QuizRunnerCLIPasser.class
        })
public class QuizRunnerCLIPasserTest
{

    @Before
    public void setup() throws Exception
    {
        HelpFormatter theHelpFormatter = Mockito.mock(HelpFormatter.class);
        PowerMockito.whenNew(HelpFormatter.class).withNoArguments().thenReturn(theHelpFormatter);
    }

    private static final String[] VALID_ARGS = new String[]
    {
        "-user", "user1", "-password", "12345678", "-questions", "10"
    };

    private static final String[] ARGS_INVALID_NUMBER = new String[]
    {
        "-user", "user1", "-password", "12345678", "-questions", "Ten"
    };

    @Test(expected = IllegalArgumentException.class)
    public void testGetQuizSettings_NoSettings()
    {
        String[] args = new String[]
        {
            ""
        };
        QuizRunnerCLIPasser theParsser = new QuizRunnerCLIPasser(args);
        theParsser.getQuizSettings();
    }

    @Test
    public void testGetQuizSettings_User()
    {
        QuizRunnerCLIPasser theParsser = new QuizRunnerCLIPasser(VALID_ARGS);
        assertEquals("user1", theParsser.getQuizSettings().getUserName().getValue());
    }

    @Test
    public void testGetQuizSettings_Password()
    {
        QuizRunnerCLIPasser theParsser = new QuizRunnerCLIPasser(VALID_ARGS);
        assertEquals("12345678", theParsser.getQuizSettings().getPassword().getValue());
    }

    @Test
    public void testGetQuizSettings_Questions()
    {
        QuizRunnerCLIPasser theParsser = new QuizRunnerCLIPasser(VALID_ARGS);
        int expected = 10;
        int result = theParsser.getQuizSettings().getNumberOfQuestions().getValue();
        assertEquals(expected, result);
    }

    @Test(expected = NumberFormatException.class)
    public void testGetQuizSettings_Questions_Invalid()
    {
        QuizRunnerCLIPasser theParsser = new QuizRunnerCLIPasser(ARGS_INVALID_NUMBER);
        int expected = 10;
        int result = theParsser.getQuizSettings().getNumberOfQuestions().getValue();
        assertEquals(expected, result);
    }

}
