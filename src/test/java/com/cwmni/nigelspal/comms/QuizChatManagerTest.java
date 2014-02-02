package com.cwmni.nigelspal.comms;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.XMPPConnection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)   
@PrepareForTest(
{
  QuizChatManager.class,ConnectionManager.class
})
public class QuizChatManagerTest
{

    private Chat myChat;
    private ConnectionManager myConnectionManager;
    private final String myRecipientAddress = "bob@example.com";
    private QuizChatManager instance;

    @Before
    public void setup()
    {
        myChat = Mockito.mock(Chat.class);

        myConnectionManager = PowerMockito.mock(ConnectionManager.class);
        XMPPConnection theConnection = PowerMockito.mock(XMPPConnection.class);
        Mockito.when(myConnectionManager.get()).thenReturn(theConnection);

        ChatManager theChatManager = PowerMockito.mock(ChatManager.class);
        Mockito.when(theConnection.getChatManager()).thenReturn(theChatManager);

        Mockito.when(theChatManager.createChat(myRecipientAddress, null)).thenReturn(myChat);

        instance = new QuizChatManager(myConnectionManager, myRecipientAddress);
    }

    @Test
    public void testGet()
    {
        assertEquals(myChat, instance.get());
    }
    
     @Test
    public void testGet_SameOneReturned()
    {
        assertEquals(instance.get(), instance.get());
    }

}
