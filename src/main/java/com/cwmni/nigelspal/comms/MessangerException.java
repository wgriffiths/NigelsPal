package com.cwmni.nigelspal.comms;

/**
 *
 */
final class MessangerException extends RuntimeException
{

    public MessangerException(String theMessage, Exception ex)
    {
        super(theMessage, ex);
    }

    public MessangerException(String theMessage)
    {
        super(theMessage);
    }

}
