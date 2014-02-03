package com.cwmni.nigelspal;

import com.cwmni.nigelspal.comms.Messenger;
import com.cwmni.nigelspal.messages.AnswerMessage;
import com.cwmni.nigelspal.messages.EndMessage;
import com.cwmni.nigelspal.messages.ErrorMessage;
import com.cwmni.nigelspal.messages.MessageRenderer;
import com.cwmni.nigelspal.messages.QuestionMessage;
import com.cwmni.nigelspal.messages.QuizMessage;
import com.cwmni.nigelspal.messages.ResetQuizMessage;
import com.cwmni.nigelspal.messages.StartQuizMessage;

/**
 * Used to run a quiz
 */
final class QuizRunner
{

    private final MessageRenderer myRenderer = new MessageRenderer();
    private final Messenger myMessenger;
    private final StartQuizMessage myStartMessage;

    /**
     *
     * @param theQuizSettings - Settings used to create quiz.
     */
    public QuizRunner(QuizSettings theQuizSettings)
    {
        myMessenger = new Messenger(theQuizSettings.getUserName(), theQuizSettings.getPassword());
        Integer numberOfQuestions = theQuizSettings.getNumberOfQuestions().getValue();
        myStartMessage = new StartQuizMessage(numberOfQuestions);
    }

    /**
     * Run the quiz
     */
    public void run()
    {
        myMessenger.send(myStartMessage);
        myRenderer.display(myStartMessage);
        QuizMessage theMessage;

        do
        {
            if ((theMessage = myMessenger.poll()) != null)
            {
                processMessage(theMessage);
            }

        } while (!(theMessage instanceof EndMessage));
    }

    private void processMessage(QuizMessage theMessage)
    {
        myRenderer.display(theMessage);

        if (theMessage instanceof QuestionMessage)
        {
            answerQuestion((QuestionMessage)theMessage);
        }

        if (theMessage instanceof ErrorMessage)
        {
            restartQuiz();
        }
    }

    private void answerQuestion(QuestionMessage theMessage)
    {
        AnswerMessage theAnswer = new AnswerMessage(theMessage);
        myRenderer.display(theAnswer);
        myMessenger.send(theAnswer);
    }
    
    private void restartQuiz()
    {
        System.out.println("Whoops let just start again ;)");
        myMessenger.send(new ResetQuizMessage());
    }
}
