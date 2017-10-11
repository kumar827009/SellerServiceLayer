package com.jupiter.service;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;

import java.util.HashMap;

public class TestElastic {

    public static void main(String[] args) {
        try {
            TransportClient client = ESSingleton.getClientSingleton().transportClient;
            HashMap<String, String> place = new HashMap<String, String>();
            place.put("name", "Naresh Kumar");
            IndexResponse response = client.prepareIndex("my_database", "places", "4")
                    .setSource(place)
                    .get();
            System.out.println(response.toString());
            // Index name
            String _index = response.getIndex();
            System.out.println(_index);
            // Type name
            String _type = response.getType();
            System.out.println(_type);
            // Document ID (generated or not)
            String _id = response.getId();
            System.out.println(_id);
            // Version (if it's the first time you index this document, you will get: 1)
            long _version = response.getVersion();
            System.out.println(_version);
            // isCreated() is true if the document is a new one, false if it has been updated
            String created = response.toString();
            System.out.println(created);
            client.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}