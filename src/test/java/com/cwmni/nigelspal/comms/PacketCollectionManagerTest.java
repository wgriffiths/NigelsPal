package com.cwmni.nigelspal.comms;

import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.FromContainsFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
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
            PacketCollectionManager.class, ConnectionManager.class
        })
public class PacketCollectionManagerTest
{
    private PacketCollector myPacketCollector;
    private PacketCollectionManager instance;

    @Before
    public void setup() throws Exception
    {
        String myRecipientAddress = "bob@example.com";
        myPacketCollector = Mockito.mock(PacketCollector.class);

        ConnectionManager myConnectionManager = PowerMockito.mock(ConnectionManager.class);
        XMPPConnection theConnection = PowerMockito.mock(XMPPConnection.class);
        Mockito.when(myConnectionManager.get()).thenReturn(theConnection);

        PacketTypeFilter thePacketTypeFilter = Mockito.mock(PacketTypeFilter.class);
        PowerMockito.whenNew(PacketTypeFilter.class).withArguments(Message.class).thenReturn(thePacketTypeFilter);

        FromContainsFilter theFromContainsFilter = Mockito.mock(FromContainsFilter.class);
        PowerMockito.whenNew(FromContainsFilter.class).withArguments(myRecipientAddress).thenReturn(theFromContainsFilter);

        AndFilter theAndFilter = Mockito.mock(AndFilter.class);
        PowerMockito.whenNew(AndFilter.class).withArguments(thePacketTypeFilter, theFromContainsFilter).thenReturn(theAndFilter);
       
        Mockito.when(theConnection.createPacketCollector(theAndFilter)).thenReturn(myPacketCollector);

        instance = new PacketCollectionManager(myConnectionManager, myRecipientAddress);
    }

    @Test
    public void testGet()
    {
        assertEquals(myPacketCollector, instance.get());
    }

    @Test
    public void testGet_Same()
    {
        assertEquals(instance.get(), instance.get());
    }

}
