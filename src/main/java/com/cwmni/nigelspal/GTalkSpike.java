package com.cwmni.nigelspal;

import static java.lang.Thread.sleep;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromContainsFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;

public class GTalkSpike
{

    private static final String PASSWORD = "";
    private static final String ME = "wjlgriffiths@gmail.com";
    private static final String NIGEL = "bangordev@gmail.com";

    public static void main(String[] args) throws XMPPException, InterruptedException
    {

        // System.setProperty("smack.debugEnabled", "true");
        //XMPPConnection.DEBUG_ENABLED = true;
        ConnectionConfiguration config = new ConnectionConfiguration("talk.google.com", 5222, "gmail.com");
        XMPPConnection connection = new XMPPConnection(config);

        connection.connect();
        SASLAuthentication.supportSASLMechanism("PLAIN", 0);
        connection.login(ME, PASSWORD);

        Chat chat = connection.getChatManager().createChat(NIGEL, null);

        PacketFilter filter = new AndFilter(new PacketTypeFilter(Message.class), new FromContainsFilter(NIGEL));
        PacketCollector collector = connection.createPacketCollector(filter);

        Message theMessage = new Message(NIGEL);

        theMessage.setBody("help");
        chat.sendMessage(theMessage);

        Packet thePacket = null;
        while (thePacket == null)
        {
            sleep(100);
            thePacket = collector.pollResult();
        }

        System.out.println(((Message) thePacket).getBody());
    }
}
