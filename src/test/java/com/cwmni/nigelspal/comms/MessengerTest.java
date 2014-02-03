package com.cwmni.nigelspal.comms;

import com.cwmni.nigelspal.Password;
import com.cwmni.nigelspal.Username;
import com.cwmni.nigelspal.messages.QuizMessage;
import com.cwmni.nigelspal.messages.QuizMessageFactory;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
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
            Messenger.class, ConnectionManager.class, 
            QuizChatManager.class, PacketCollectionManager.class,
            QuizMessageFactory.class
        })
public class MessengerTest
{
    
    private static final String NIGEL = "bangordev@gmail.com";
    private Message myMessage;
    private Chat myChat;
    private PacketCollector myPacketCollector;
    private Messenger instance;
    
    @Before
    public void setup() throws Exception
    {
        Username theUserName = new Username("A");
        Password thePassword = new Password("B");
        
        ConnectionManager myConnectionManager = PowerMockito.mock(ConnectionManager.class);
        PowerMockito.whenNew(ConnectionManager.class).withArguments(theUserName, thePassword).thenReturn(myConnectionManager);
        
        QuizChatManager myChatManager = PowerMockito.mock(QuizChatManager.class);
        PowerMockito.whenNew(QuizChatManager.class).withArguments(myConnectionManager, NIGEL).thenReturn(myChatManager);
        
        PacketCollectionManager myPacketCollectionManager = PowerMockito.mock(PacketCollectionManager.class);
        PowerMockito.whenNew(PacketCollectionManager.class).withArguments(myConnectionManager, NIGEL).thenReturn(myPacketCollectionManager);
        
        myMessage = PowerMockito.mock(Message.class);
        PowerMockito.whenNew(Message.class).withArguments(NIGEL).thenReturn(myMessage);
        
        myChat = PowerMockito.mock(Chat.class);
        Mockito.when(myChatManager.get()).thenReturn(myChat);
        
        myPacketCollector = PowerMockito.mock(PacketCollector.class);
        Mockito.when(myPacketCollectionManager.get()).thenReturn(myPacketCollector);
        
        instance = new Messenger(theUserName, thePassword);
    }
    
    @Test
    public void testSend() throws XMPPException
    {
        QuizMessage theQuizMessage = PowerMockito.mock(QuizMessage.class);
        
        instance.send(theQuizMessage);
        
        Mockito.verify(myChat).sendMessage(myMessage);
    }
    
    @Test
    public void testSend_SetBody() throws XMPPException
    {
        String theMessage = "bing bong";
        QuizMessage theQuizMessage = PowerMockito.mock(QuizMessage.class);
        Mockito.when(theQuizMessage.getMessage()).thenReturn(theMessage);
        
        instance.send(theQuizMessage);
        
        Mockito.verify(myMessage).setBody(theMessage);
    }
    
    @Test(expected = MessengerException.class)
    public void testSend_Exception() throws Exception
    {
        XMPPException theXMPPException = PowerMockito.mock(XMPPException.class);
        QuizMessage theQuizMessage = PowerMockito.mock(QuizMessage.class);
        Mockito.doThrow(theXMPPException).when(myChat).sendMessage(myMessage);
        
        instance.send(theQuizMessage);
    }
    
    @Test
    public void testPoll_NullPackage()
    {
        Mockito.when(myPacketCollector.pollResult()).thenReturn(null);
        
        assertNull(instance.poll());
    }
    
    @Test
    public void testPoll_NullMessageBody()
    {
        Message theMessage = PowerMockito.mock(Message.class);
        Mockito.when(theMessage.getBody()).thenReturn(null);
        
        Mockito.when(myPacketCollector.pollResult()).thenReturn(theMessage);
        
        assertNull(instance.poll());
    }
    
    @Test
    public void testPoll() throws Exception
    {
        String theMessageBody ="hello everyone";
        Message theMessage = PowerMockito.mock(Message.class);
        Mockito.when(theMessage.getBody()).thenReturn(theMessageBody);
        
        Mockito.when(myPacketCollector.pollResult()).thenReturn(theMessage);
        
        QuizMessageFactory theFactory = PowerMockito.mock(QuizMessageFactory.class);
        PowerMockito.whenNew(QuizMessageFactory.class).withNoArguments().thenReturn(theFactory);
        
        QuizMessage theQuizMessage = PowerMockito.mock(QuizMessage.class);
        
        Mockito.when(theFactory.get(theMessageBody)).thenReturn(theQuizMessage);
        
        assertEquals(theQuizMessage, instance.poll());
    }
    
}
