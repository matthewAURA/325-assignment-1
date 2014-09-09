package com.matthewdyer.assignment1.net;


import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MediaController {

    private static final String template = "Hello, %s!";
    
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/media")
    public MediaWeb mediaWeb(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new MediaWeb(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/")
    public String root(){
    	return "<h1>Hello, World!</h1>";
    }
}
