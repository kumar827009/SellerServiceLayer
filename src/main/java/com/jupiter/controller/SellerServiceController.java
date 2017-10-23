package com.jupiter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jupiter.beans.Greeting;
import com.jupiter.beans.Seller;
import com.jupiter.service.ESSingleton;
import com.jupiter.util.CommonUtil;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SellerServiceController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*
        SAMPLE Input JSON
         {
              "id": "",
              "name": "wsretai1l",
              "ownername": "aa",
              "address": {
                "email": "nk@jupiter.com",
                "city": "aa",
                "addressLineOne": "aa",
                "addressLineTwo": "aa",
                "pin": "981981"
              }
          }
     */

    /**
     * Paste Sample JSON to fire request
     * http://localhost:8080/jupiter/seller/
     *
     * @param seller
     * @return
     * @throws UnknownHostException
     */
    @PostMapping("/jupiter/seller/")
    public Seller registerSeller(@RequestBody Seller seller) throws UnknownHostException, JsonProcessingException, IOException {
        TransportClient client = ESSingleton.getClientSingleton().transportClient;
        ObjectMapper mapper = new ObjectMapper();

        String userId = CommonUtil.generateUniqueId();
        seller.setId(userId);

        String inputJson = mapper.writeValueAsString(seller);
        System.out.println("Input JSON: " + inputJson);

        /* This piece of code will move to the registration module*/
        IndexResponse response = client.prepareIndex("sellers_db", "seller", userId)
                .setSource(mapper.writeValueAsString(seller), XContentType.JSON)
                .execute()
                .actionGet();


        GetResponse getResponse = client
                .prepareGet("sellers_db", "seller", response.getId())
                .execute()
                .actionGet();

        String source = getResponse.getSourceAsString();
        Seller sellerResp = mapper.readValue(source, Seller.class);

        client.close();
        return sellerResp;
    }

    /**
     * @param seller
     * @return
     * @throws UnknownHostException
     */
    @PostMapping("/jupiter/seller/search")
    public IndexResponse searchSeller(@RequestBody Seller seller) throws UnknownHostException {
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
