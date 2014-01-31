package com.cwmni.nigelspal;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

public class GTalkSpike
{

    private static final String PASSWORD = "";
    private static final String ME = "wjlgriffiths@gmail.com";
    private static final String NIGEL = "bangordev@gmail.com";

    public static void main(String[] args) throws XMPPException
    {

        // System.setProperty("smack.debugEnabled", "true");
        ConnectionConfiguration config = new ConnectionConfiguration("talk.google.com", 5222, "gmail.com");
        XMPPConnection connection = new XMPPConnection(config);

        connection.connect();
        SASLAuthentication.supportSASLMechanism("PLAIN", 0);
        connection.login(ME, PASSWORD);

        Chat chat = connection.getChatManager().createChat(NIGEL, new MessageListener()
        {

            public void processMessage(Chat chat, Message message)
            {
                System.out.println("Received message: " + message.getBody());
            }
        });

        Message theMessage = new Message(NIGEL, Message.Type.chat);

        theMessage.setBody("help");
        chat.sendMessage(theMessage);
    }

}
