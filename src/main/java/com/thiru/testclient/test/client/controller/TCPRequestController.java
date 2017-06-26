package com.thiru.testclient.test.client.controller;

import com.thiru.testclient.test.client.service.TCPClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thiru on 6/26/17.
 */
@RestController

public class TCPRequestController {

    @RequestMapping(value = "/testclient", method = RequestMethod.POST)
    public String tcprequest(@RequestBody String payload) {
        TCPClient tc = new TCPClient();
        String response = "";
        try {
            response = tc.sendAndreceiveData(payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
