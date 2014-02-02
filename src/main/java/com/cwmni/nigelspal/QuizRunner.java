package com.cwmni.nigelspal;

import com.cwmni.nigelspal.comms.Messenger;
import com.cwmni.nigelspal.messages.AnswerMessage;
import com.cwmni.nigelspal.messages.EndMessage;
import com.cwmni.nigelspal.messages.InvalidMessage;
import com.cwmni.nigelspal.messages.MessageRenderer;
import com.cwmni.nigelspal.messages.QuestionMessage;
import com.cwmni.nigelspal.messages.QuizMessage;
import com.cwmni.nigelspal.messages.ResetQuizMessage;
import com.cwmni.nigelspal.messages.StartQuizMessage;

/**
 *
 */
final class QuizRunner
{

    private static final MessageRenderer theMessageRenderer = new MessageRenderer();

    private final QuizSettings myQuizSettings;

    public QuizRunner(QuizSettings theQuizSettings)
    {
        myQuizSettings = theQuizSettings;
    }

    public void run() throws InterruptedException
    {
        Messenger theMessenger = new Messenger(myQuizSettings.getUserName(), myQuizSettings.getPassword());

        Integer numberOfQuestions = myQuizSettings.getNumberOfQuestions().getValue();
        StartQuizMessage theStartMessage = new StartQuizMessage(numberOfQuestions);
        
        theMessenger.send(theStartMessage);
        
        theMessageRenderer.display(theStartMessage);

        QuizMessage theMessage;

        do
        {
            theMessage = theMessenger.poll();

            if (theMessage != null)
            {
                theMessageRenderer.display(theMessage);

                if (theMessage instanceof QuestionMessage)
                {
                    QuestionMessage theQuestion = (QuestionMessage) theMessage;
                    AnswerMessage theAnswer = new AnswerMessage(theQuestion);

                    theMessageRenderer.display(theAnswer);
                    
                    theMessenger.send(theAnswer);
                }

                if (theMessage instanceof InvalidMessage)
                {
                    System.out.println("Woops let just start again ;)");
                    theMessenger.send(new ResetQuizMessage());
                }
            }

        } while (!(theMessage instanceof EndMessage));
    }
}
