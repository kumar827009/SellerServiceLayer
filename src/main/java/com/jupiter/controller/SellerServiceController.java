package com.jupiter.controller;

import com.jupiter.beans.Greeting;
import com.jupiter.service.ESSingleton;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SellerServiceController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @PostMapping("/jupiter/seller/{id}")
    public IndexResponse registerSeller(@RequestParam(value = "name", defaultValue = "World") String name,
                                        @PathVariable("id") String id) throws UnknownHostException {
        TransportClient client = ESSingleton.getClientSingleton().transportClient;
        HashMap<String, String> place = new HashMap<String, String>();
        place.put("name", "Naresh Kumar5");
        IndexResponse response = client.prepareIndex("my_database", "places", id)
                .setSource(place)
                .get();
        client.close();
        return response;
    }

    /**
     * This is test API for testing Service is Up and Running
     *
     * @param name name for greeting
     * @return Greeting greeting message
     */
    @GetMapping("/jupiter/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Done....") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
