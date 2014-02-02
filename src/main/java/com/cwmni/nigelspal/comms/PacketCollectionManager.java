package com.cwmni.nigelspal.comms;

import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromContainsFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;

/**
 * Used to create Smack PacketCollector. PacketCollector is filtered on supplied
 * email/username
 */
final class PacketCollectionManager
{

    private PacketCollector myPacketCollector;
    private final ConnectionManager myConnectionManager;
    private final String myRecipientAddress;

    /**
     *
     * @param theConnectionManager - Connection manager used to create
     * PacketCollector.
     * @param theRecipientAddress - Recipient email address used to filter
     * messages
     */
    public PacketCollectionManager(ConnectionManager theConnectionManager, String theRecipientAddress)
    {
        myConnectionManager = theConnectionManager;
        myRecipientAddress = theRecipientAddress;
    }

    /**
     * @return PacketCollector
     */
    public PacketCollector get()
    {
        if (myPacketCollector == null)
        {
            PacketFilter filter = new AndFilter(new PacketTypeFilter(Message.class), new FromContainsFilter(myRecipientAddress));
            myPacketCollector = myConnectionManager.get().createPacketCollector(filter);
        }

        return myPacketCollector;
    }

}
