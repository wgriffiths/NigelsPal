package com.cwmni.nigelspal.comms;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.XMPPConnection;

/**
 *
 */
final class ChatManager
{

    private Chat myChat;
    private final ConnectionManager myConnectionManager;
    private final String myRecipientAddress;

    public ChatManager(ConnectionManager theConnectionManager, String theRecipientAddress)
    {
        myConnectionManager = theConnectionManager;
        myRecipientAddress = theRecipientAddress;
    }

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
