package com.cwmni.nigelspal.comms;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.XMPPConnection;

/**
 * Class used to create Smack Chat object
 */
final class QuizChatManager
{

    private Chat myChat;
    private final ConnectionManager myConnectionManager;
    private final String myRecipientAddress;

    /**
     *
     * @param theConnectionManager - Connection manager used to create Chat.
     * @param theRecipientAddress - Email address of chats recipient.
     */
    public QuizChatManager(ConnectionManager theConnectionManager, String theRecipientAddress)
    {
        myConnectionManager = theConnectionManager;
        myRecipientAddress = theRecipientAddress;
    }

    /**
     * @return - Chat object.
     */
    public Chat get()
    {
        if (myChat == null)
        {
            myChat = createChat();
        }

        return myChat;
    }

    private Chat createChat()
    {
        XMPPConnection connection = myConnectionManager.get();
        return connection.getChatManager().createChat(myRecipientAddress, null);
    }

}
