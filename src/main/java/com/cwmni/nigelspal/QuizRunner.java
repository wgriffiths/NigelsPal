package com.cwmni.nigelspal;

import com.cwmni.nigelspal.comms.Messenger;
import com.cwmni.nigelspal.comms.Password;
import com.cwmni.nigelspal.comms.Username;
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

    private static final MessageRenderer theDisplay = new MessageRenderer();
    public static void main(String[] args) throws InterruptedException
    {
        new QuizRunner().run();
    }

    public void run() throws InterruptedException
    {
        StartQuizMessage theStartMessage = new StartQuizMessage(100);
        Username theUserName = new Username("wjlgriffiths@gmail.com");
        Password thePassword = new Password("***REMOVED***");
        Messenger theMessenger = new Messenger(theUserName, thePassword);

        theMessenger.send(theStartMessage);
        System.out.println(theStartMessage.getMessage());
        
        QuizMessage theMessage;

        do
        {
            theMessage = theMessenger.poll();

            if (theMessage != null)
            {
                theDisplay.display(theMessage);
                
                

                if (theMessage instanceof QuestionMessage)
                {
                    QuestionMessage theQuestion = (QuestionMessage) theMessage;
                    AnswerMessage theAnswer = new AnswerMessage(theQuestion);

                    theDisplay.display(theAnswer);
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
