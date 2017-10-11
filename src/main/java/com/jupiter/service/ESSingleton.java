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

    private static ESSingleton clientSingleton;
    public TransportClient transportClient;

    /**
     * @param transportClient org.elasticsearch.client.transport.TransportClient
     */
    private ESSingleton(TransportClient transportClient) {
        this.transportClient = transportClient;
    }

    /**
     * @return ESSingleton clientSingleton
     * @throws UnknownHostException unknown Host exception
     */
    public static ESSingleton getClientSingleton() throws UnknownHostException {
        if (clientSingleton == null) {
            synchronized (ESSingleton.class) {
                return new ESSingleton(new PreBuiltTransportClient((Settings.EMPTY))
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300))
                        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300)));
            }
        } else {
            return clientSingleton;
        }
    }


    public static void setClientSingleton(ESSingleton clientSingleton) {
        ESSingleton.clientSingleton = clientSingleton;
    }
}
