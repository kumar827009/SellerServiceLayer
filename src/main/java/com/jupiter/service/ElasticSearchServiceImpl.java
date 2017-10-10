package com.jupiter.service;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

public class ElasticSearchServiceImpl implements ElasticSearchService {

    public TransportClient getElasticSearchClient() throws Exception {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9200))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9200));
        return client;
    }
}
