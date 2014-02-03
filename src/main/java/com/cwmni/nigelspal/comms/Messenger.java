package com.cwmni.nigelspal.comms;

import com.cwmni.nigelspal.Username;
import com.cwmni.nigelspal.Password;
import com.cwmni.nigelspal.messages.QuizMessage;
import com.cwmni.nigelspal.messages.QuizMessageFactory;

import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;

/**
 * Used to send and receive messages
 */
public final class Messenger
{

    private static final String NIGEL_EMAIL = "bangordev@gmail.com";
    private static final String CANT_SEND_MESSAGE_TO_NIGEL = "Can't send message to  " + NIGEL_EMAIL;

    private final QuizChatManager myChatManager;
    private final ConnectionManager myConnectionManager;
    private final PacketCollectionManager myPacketCollectionManager;

    /**
     *
     * @param theUserName - Username used to connect
     * @param thePassword - password used to connect
     */
    public Messenger(Username theUserName, Password thePassword)
    {
        myConnectionManager = new ConnectionManager(theUserName, thePassword);
        myChatManager = new QuizChatManager(myConnectionManager, NIGEL_EMAIL);
        myPacketCollectionManager = new PacketCollectionManager(myConnectionManager, NIGEL_EMAIL);
    }

    /**
     * Send supplied message
     *
     * @param theQuizMessage - Message to send
     */
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
            throw new MessengerException(theExMessage, ex);
        }
    }

    /**
     * Polls for a new message, if no message is not found null is returned.
     *
     * @return QuizeMessage receive or null.
     */
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

        return new QuizMessageFactory().get(theMessageBody);

    }

}
