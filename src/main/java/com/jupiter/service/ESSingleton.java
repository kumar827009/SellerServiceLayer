package com.jupiter.service;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * This is a singleton class that creates a single instance of TransportClient
 */
public class ESSingleton {

    private ESSingleton clientSingleton;
    private TransportClient transportClient;

    /**
     * @param transportClient
     */
    private ESSingleton(TransportClient transportClient) {
        this.transportClient = transportClient;
    }

    /**
     * @return ESSingleton clientSingleton
     * @throws UnknownHostException
     */
    public ESSingleton getClientSingleton() throws UnknownHostException {
        if (!clientSingleton.isNull()) {
            synchronized (ESSingleton.class) {
                return new ESSingleton(new PreBuiltTransportClient((Settings.EMPTY))
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9200))
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9200)));
            }
        } else {
            return clientSingleton;
        }
    }

    private Boolean isNull() {
        if (this.clientSingleton != null)
            return false;
        else
            return true;
    }
}
