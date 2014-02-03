package com.cwmni.nigelspal.messages;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(
        {
            QuestionMessage.class, ErrorMessage.class,
            EndMessage.class, QuizMessageFactory.class,
            OtherMessage.class
        })

public class QuizMessageFactoryTest
{

    private static final String MESSAGE = "A";

    private QuestionMessage myQuestionMessage;
    private ErrorMessage myErrorMessage;
    private EndMessage myEndMessage;
    private OtherMessage myOtherMessage;

    private QuizMessageFactory instance;

    @Before
    public void setup() throws Exception
    {
        PowerMockito.mockStatic(QuestionMessage.class);
        PowerMockito.mockStatic(ErrorMessage.class);
        PowerMockito.mockStatic(EndMessage.class);

        myQuestionMessage = PowerMockito.mock(QuestionMessage.class);
        myErrorMessage = PowerMockito.mock(ErrorMessage.class);
        myEndMessage = PowerMockito.mock(EndMessage.class);
        myOtherMessage = PowerMockito.mock(OtherMessage.class);

        PowerMockito.whenNew(QuestionMessage.class).withArguments(MESSAGE).thenReturn(myQuestionMessage);
        PowerMockito.whenNew(ErrorMessage.class).withArguments(MESSAGE).thenReturn(myErrorMessage);
        PowerMockito.whenNew(EndMessage.class).withArguments(MESSAGE).thenReturn(myEndMessage);
        PowerMockito.whenNew(OtherMessage.class).withArguments(MESSAGE).thenReturn(myOtherMessage);

        instance = new QuizMessageFactory();

    }

    @Test
    public void testGet_Question()
    {
        PowerMockito.when(QuestionMessage.isOne(MESSAGE)).thenReturn(Boolean.TRUE);
        assertEquals(myQuestionMessage, instance.get(MESSAGE));
    }

    @Test
    public void testGet_Error()
    {
        PowerMockito.when(ErrorMessage.isOne(MESSAGE)).thenReturn(Boolean.TRUE);
        assertEquals(myErrorMessage, instance.get(MESSAGE));
    }

    @Test
    public void testGet_End()
    {
        PowerMockito.when(EndMessage.isOne(MESSAGE)).thenReturn(Boolean.TRUE);
        assertEquals(myEndMessage, instance.get(MESSAGE));
    }

    @Test
    public void testGet_Other()
    {
        assertEquals(myOtherMessage, instance.get(MESSAGE));
    }

}
