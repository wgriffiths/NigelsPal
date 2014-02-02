package com.cwmni.nigelspal.comms;

/**
 * Exception used by Messenger
 */
final class MessengerException extends RuntimeException
{

    /**
     *
     * @param theMessage - Message related to exception
     * @param ex - source exception
     */
    public MessengerException(String theMessage, Exception ex)
    {
        super(theMessage, ex);
    }

    /**
     *
     * @param theMessage - Message related to exception
     */
    public MessengerException(String theMessage)
    {
        super(theMessage);
    }

}
