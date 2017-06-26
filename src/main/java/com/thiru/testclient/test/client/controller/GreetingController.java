package com.thiru.testclient.test.client.controller;

/**
 * Created by thiru on 6/24/17.
 */
import java.util.concurrent.atomic.AtomicLong;

import com.thiru.testclient.test.client.model.DownstreamConfig;
import com.thiru.testclient.test.client.model.Greeting;
import com.thiru.testclient.test.client.model.UpstreamConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private UpstreamConfig uc;
    @Autowired
    private DownstreamConfig dc;
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
    @RequestMapping(value = "/testclient", method = RequestMethod.POST)
    public String testclient(@RequestBody String payload) {
        System.out.println("upstream object name:"+uc.getName());
        System.out.println("downstream object name:"+dc.getName());
        return payload;
    }
}
