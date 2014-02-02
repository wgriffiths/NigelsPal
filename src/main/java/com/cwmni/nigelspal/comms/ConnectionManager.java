package com.cwmni.nigelspal.comms;

import com.cwmni.nigelspal.Username;
import com.cwmni.nigelspal.Password;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

/**
 *
 */
final class ConnectionManager
{

    private XMPPConnection myConnection;
    private final Username myUserName;
    private final Password myPassword;
    private static final String CANT_LOG_IN = "Can't log in to talk.google.com as %s";

    public ConnectionManager(Username theUserName, Password thePassword)
    {
        myUserName = theUserName;
        myPassword = thePassword;
    }

    public XMPPConnection get()
    {
        if (myConnection == null || !myConnection.isAuthenticated())
        {
            myConnection = createConnection();
        }

        if (!myConnection.isAuthenticated())
        {
            String theMessage = String.format(CANT_LOG_IN, myUserName.getValue());
            throw new MessangerException(theMessage);
        }

        return myConnection;
    }

    private XMPPConnection createConnection()
    {
        try
        {
            ConnectionConfiguration config = new ConnectionConfiguration("talk.google.com", 5222, "gmail.com");
            XMPPConnection theConnection = new XMPPConnection(config);
            theConnection.connect();
            SASLAuthentication.supportSASLMechanism("PLAIN", 0);
            theConnection.login(myUserName.getValue(), myPassword.getValue());

            return theConnection;
        } catch (XMPPException ex)
        {
            String theMessage = String.format(CANT_LOG_IN, myUserName.getValue());
            throw new MessangerException(theMessage);
        }
    }
}
