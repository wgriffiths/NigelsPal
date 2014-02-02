package com.cwmni.nigelspal.comms;

import com.cwmni.nigelspal.Password;
import com.cwmni.nigelspal.Username;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
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
            ConnectionManager.class, XMPPConnection.class, MessengerException.class
        })
public class ConnectionManagerTest
{

    private static final String SERVICE = "gmail.com";
    private static final String HOST = "talk.google.com";
    private static final int PORT = 5222;
    private XMPPConnection myConnection;
    private final Username myUserName = new Username("A");
    private final Password myPassword = new Password("B");
    private final ConnectionManager instance = new ConnectionManager(myUserName, myPassword);

    @Before
    public void setup() throws Exception
    {
        myConnection = PowerMockito.mock(XMPPConnection.class);
        Mockito.when(myConnection.isAuthenticated()).thenReturn(Boolean.TRUE);
        ConnectionConfiguration theConfig = PowerMockito.mock(ConnectionConfiguration.class);
        PowerMockito.whenNew(ConnectionConfiguration.class).withArguments(HOST, PORT, SERVICE).thenReturn(theConfig);

        PowerMockito.whenNew(XMPPConnection.class).withArguments(theConfig).thenReturn(myConnection);

    }

    @Test
    public void testGet()
    {
        assertEquals(myConnection, instance.get());
    }

    @Test
    public void testGet_SameReturned()
    {
        assertEquals(instance.get(), instance.get());
    }

    @Test
    public void testGet_Connect() throws XMPPException
    {
        instance.get();
        Mockito.verify(myConnection).connect();
    }

    @Test
    public void testGet_Login() throws XMPPException
    {
        instance.get();
        Mockito.verify(myConnection).login("A", "B");
    }

    @Test
    public void testGet_SASL()
    {
        instance.get();
        PowerMockito.verifyStatic();
        SASLAuthentication.supportSASLMechanism("PLAIN", 0);
    }

    @Test(expected = MessengerException.class)
    public void testGet_ConnectFailed() throws XMPPException
    {
        MessengerException theException = PowerMockito.mock(MessengerException.class);
        Mockito.doThrow(theException).when(myConnection).connect();

        instance.get();
    }

    @Test(expected = MessengerException.class)
    public void testGet_LoginFailed() throws XMPPException
    {
        MessengerException theException = PowerMockito.mock(MessengerException.class);
        Mockito.doThrow(theException).when(myConnection).login("A", "B");

        instance.get();
    }

    @Test(expected = MessengerException.class)
    public void testGet_NotAuthorised() throws XMPPException
    {
        Mockito.when(myConnection.isAuthenticated()).thenReturn(Boolean.FALSE);
        instance.get();
    }

}
