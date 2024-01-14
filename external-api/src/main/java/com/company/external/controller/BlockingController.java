package com.company.external.controller;

import com.company.external.service.BlockingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/blocking")
@RestController
public class BlockingController {

    private final BlockingService blockingService;

    public BlockingController(BlockingService blockingService) {
        this.blockingService = blockingService;
    }

    @GetMapping
    public void runBlocking(@RequestParam Boolean isSync) {
        if (isSync) {
            blockingService.runSync();
            return;
        }
        blockingService.runASync();
    }
}
