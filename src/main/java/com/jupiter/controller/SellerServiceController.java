package com.jupiter.controller;

import com.jupiter.beans.Greeting;
import com.jupiter.beans.Seller;
import com.jupiter.service.ESSingleton;
import com.jupiter.util.CommonUtil;
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

    /**
     * Sample JSON to fire request
     * http://localhost:8080/jupiter/seller/
     * <p>
     * {
     * "name": "wsretail",
     * "ownerName":"aa",
     * "address":{
     * "email":"nk@jupiter.com",
     * "city":"aa",
     * "addressLineOne":"aa",
     * "addressLineTwo":"aa",
     * "pin":"113456"
     * }
     * }
     */
    @PostMapping("/jupiter/seller/")
    public IndexResponse registerSeller(@RequestBody Seller seller) throws UnknownHostException {
        TransportClient client = ESSingleton.getClientSingleton().transportClient;
        String userId = CommonUtil.generateUniqueId();
        seller.setId(userId);
        HashMap<String, Seller> newSeller = new HashMap<String, Seller>();
        /* This piece of code will move to the registration module*/
        newSeller.put(userId, seller);
        IndexResponse response = client.prepareIndex("sellers_db", "seller", userId)
                .setSource(seller)
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
