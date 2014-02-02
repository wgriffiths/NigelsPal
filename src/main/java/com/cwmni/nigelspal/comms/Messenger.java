package com.cwmni.nigelspal.comms;

import com.cwmni.nigelspal.messages.QuizMessage;
import com.cwmni.nigelspal.messages.QuizMessageFactory;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;

/**
 *
 */
public final class Messenger
{

    private static final String NIGEL_EMAIL = "bangordev@gmail.com";
    private static final String CANT_SEND_MESSAGE_TO_NIGEL = "Can't send message to  " + NIGEL_EMAIL;

    private final ChatManager myChatManager;
    private final ConnectionManager myConnectionManager;
    private final PacketCollectionManager myPacketCollectionManager;

    public Messenger(Username theUserName, Password thePassword)
    {
        myConnectionManager = new ConnectionManager(theUserName, thePassword);
        myChatManager = new ChatManager(myConnectionManager, NIGEL_EMAIL);
        myPacketCollectionManager = new PacketCollectionManager(myConnectionManager, NIGEL_EMAIL);
    }

    public void send(QuizMessage theQuizMessage)
    {
        Message theMessage = new Message(NIGEL_EMAIL);
        theMessage.setBody(theQuizMessage.getMessage());

        try
        {
            myChatManager.get().sendMessage(theMessage);
        } catch (XMPPException ex)
        {
            String theExMessage = String.format(CANT_SEND_MESSAGE_TO_NIGEL);
            throw new MessangerException(theExMessage, ex);
        }
    }

    public QuizMessage poll()
    {
        Packet thePacket = myPacketCollectionManager.get().pollResult();

        if (thePacket == null)
        {
            return null;
        }

        String theMessageBody = ((Message) thePacket).getBody();

        if (theMessageBody == null)
        {
            return null;
        }

        return new QuizMessageFactory(theMessageBody).get();

    }

}
