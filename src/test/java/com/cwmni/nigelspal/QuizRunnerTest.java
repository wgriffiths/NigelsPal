package com.cwmni.nigelspal;

import com.cwmni.nigelspal.comms.Messenger;
import com.cwmni.nigelspal.messages.AnswerMessage;
import com.cwmni.nigelspal.messages.EndMessage;
import com.cwmni.nigelspal.messages.ErrorMessage;
import com.cwmni.nigelspal.messages.MessageRenderer;
import com.cwmni.nigelspal.messages.QuestionMessage;
import com.cwmni.nigelspal.messages.ResetQuizMessage;
import com.cwmni.nigelspal.messages.StartQuizMessage;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(
        {
            QuizRunner.class, Messenger.class, StartQuizMessage.class,
            EndMessage.class, QuestionMessage.class, AnswerMessage.class,
            ErrorMessage.class, ResetQuizMessage.class, MessageRenderer.class
        })
public class QuizRunnerTest
{

    private static final int NO_QUESTION = 42;
    private Messenger myMessenger;
    private StartQuizMessage myStartMessage;
    private QuizRunner instance;
    private EndMessage myEndMessage;
    private QuestionMessage myQuestionMessage1;
    private AnswerMessage myAnswerMessage1;
    private QuestionMessage myQuestionMessage2;
    private AnswerMessage myAnswerMessage2;
    private ErrorMessage myErrorMessage;
    private ResetQuizMessage myResetQuizMessage;

    @Before
    public void setup() throws Exception
    {
        MessageRenderer theMessageRenderer = PowerMockito.mock(MessageRenderer.class);
        PowerMockito.whenNew(MessageRenderer.class).withNoArguments().thenReturn(theMessageRenderer);
        myMessenger = PowerMockito.mock(Messenger.class);
        myEndMessage = PowerMockito.mock(EndMessage.class);

        Username theUsername = new Username("A");
        Password thePassword = new Password("B");
        NumberOfQuestions theNumberOfQuestions = new NumberOfQuestions(NO_QUESTION);
        PowerMockito.whenNew(Messenger.class).withArguments(theUsername, thePassword).thenReturn(myMessenger);

        QuizSettings theQuizSettings = new QuizSettings(theUsername, thePassword, theNumberOfQuestions);

        myStartMessage = PowerMockito.mock(StartQuizMessage.class);
        PowerMockito.whenNew(StartQuizMessage.class).withArguments(NO_QUESTION).thenReturn(myStartMessage);

        myQuestionMessage1 = PowerMockito.mock(QuestionMessage.class);
        myAnswerMessage1 = PowerMockito.mock(AnswerMessage.class);
        PowerMockito.whenNew(AnswerMessage.class).withArguments(myQuestionMessage1).thenReturn(myAnswerMessage1);

        myQuestionMessage2 = PowerMockito.mock(QuestionMessage.class);
        myAnswerMessage2 = PowerMockito.mock(AnswerMessage.class);
        PowerMockito.whenNew(AnswerMessage.class).withArguments(myQuestionMessage2).thenReturn(myAnswerMessage2);

        myErrorMessage = PowerMockito.mock(ErrorMessage.class);
        myResetQuizMessage = PowerMockito.mock(ResetQuizMessage.class);
        PowerMockito.whenNew(ResetQuizMessage.class).withNoArguments().thenReturn(myResetQuizMessage);

        instance = new QuizRunner(theQuizSettings);
    }

    @Test
    public void testRun_StartMessage()
    {
        Mockito.when(myMessenger.poll()).thenReturn(myEndMessage);

        instance.run();

        Mockito.verify(myMessenger).send(myStartMessage);
    }

    @Test
    public void testRun_AnswerMessage() 
    {
        Mockito.when(myMessenger.poll()).thenReturn(myQuestionMessage1).thenReturn(myEndMessage);

        instance.run();

        Mockito.verify(myMessenger).send(myAnswerMessage1);
    }

    @Test
    public void testRun_AnswerMessage_Two() 
    {
        Mockito.when(myMessenger.poll()).thenReturn(myQuestionMessage1).thenReturn(myQuestionMessage2).thenReturn(myEndMessage);

        instance.run();

        Mockito.verify(myMessenger).send(myAnswerMessage1);
        Mockito.verify(myMessenger).send(myAnswerMessage2);
    }

    @Test
    public void testRun_RestartMessage() 
    {
        Mockito.when(myMessenger.poll()).thenReturn(myErrorMessage).thenReturn(myEndMessage);

        instance.run();

        Mockito.verify(myMessenger).send(myResetQuizMessage);
    }

}
