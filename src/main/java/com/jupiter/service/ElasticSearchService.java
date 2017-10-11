package com.jupiter.service;

import org.elasticsearch.client.transport.TransportClient;

import java.net.UnknownHostException;

public interface ElasticSearchService {

    TransportClient getTransportClient() throws UnknownHostException;

    void setTransportClient(TransportClient transportClient);
}
