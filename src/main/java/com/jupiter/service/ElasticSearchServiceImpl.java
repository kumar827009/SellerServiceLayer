package com.jupiter.service;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ElasticSearchServiceImpl implements ElasticSearchService {

    private TransportClient transportClient;

    @Override
    public TransportClient getTransportClient() throws UnknownHostException {
        transportClient = new PreBuiltTransportClient((Settings.EMPTY))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9200))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9200));
        return transportClient;
    }

    @Override
    public void setTransportClient(TransportClient transportClient) {
        this.transportClient = transportClient;
    }
}
