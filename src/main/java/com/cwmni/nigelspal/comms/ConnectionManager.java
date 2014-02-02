package com.cwmni.nigelspal.comms;

import com.cwmni.nigelspal.Username;
import com.cwmni.nigelspal.Password;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

/**
 * Class used to create an XMPPConnection connection
 */
final class ConnectionManager
{
    private static final String SERVICE = "gmail.com";
    private static final String HOST = "talk.google.com";
    private static final int PORT = 5222;
    private static final String CANT_LOG_IN = "Can't log in to talk.google.com as %s";
    
    private XMPPConnection myConnection;
    private final Username myUserName;
    private final Password myPassword;
    /**
     * 
     * @param theUserName - Username used to create connection.
     * @param thePassword - Password used to create connection.
     */
    public ConnectionManager(Username theUserName, Password thePassword)
    {
        myUserName = theUserName;
        myPassword = thePassword;
    }

    /**
     * @return Authenticated XMPPConnection
     */
    public XMPPConnection get()
    {
        if (myConnection == null)
        {
            myConnection = createConnection();
        }

        if (!myConnection.isAuthenticated())
        {
            String theMessage = String.format(CANT_LOG_IN, myUserName.getValue());
            throw new MessengerException(theMessage);
        }

        return myConnection;
    }

    private XMPPConnection createConnection()
    {
        try
        {
            ConnectionConfiguration config = new ConnectionConfiguration(HOST, PORT, SERVICE);
            XMPPConnection theConnection = new XMPPConnection(config);
            theConnection.connect();
            SASLAuthentication.supportSASLMechanism("PLAIN", 0);
            theConnection.login(myUserName.getValue(), myPassword.getValue());

            return theConnection;
        } catch (XMPPException ex)
        {
            String theMessage = String.format(CANT_LOG_IN, myUserName.getValue());
            throw new MessengerException(theMessage, ex);
        }
    }
}
