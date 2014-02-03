package com.cwmni.nigelspal.messages;

import org.apache.log4j.Logger;

/**
 * Class used to received messages
 */
public final class MessageRenderer
{

    private static final Logger LOG = Logger.getLogger(MessageRenderer.class);

    /**
     * @param theQuizMessage - Message to received
     */
    public void received(QuizMessage theQuizMessage)
    {
        LOG.info("(Received) "+theQuizMessage.getMessage());
    }

    /**
     * 
     * @param theQuizMessage Message to sent
     */
    public void send(QuizMessage theQuizMessage)
    {
        LOG.info("(Sent) "+theQuizMessage.getMessage());
    }

   
}
