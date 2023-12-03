package com.company.store.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class SampleController {

    private static final int THREAD_SLEEP_TIME = 500;
    private static final Logger log = LoggerFactory.getLogger(SampleController.class);
    private static final AtomicInteger count = new AtomicInteger(0);

    @GetMapping("/thread-test")
    @ResponseBody
    public String threadTest() throws InterruptedException {
        Thread.sleep(THREAD_SLEEP_TIME);
        log.info("http call count : [{}]", count.incrementAndGet());
        return "thread-test";
    }
}
