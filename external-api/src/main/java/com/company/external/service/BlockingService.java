package com.company.external.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BlockingService {

    private static final Logger logger = LoggerFactory.getLogger(BlockingService.class);

    public void runSync() {
        logger.info("runSync");
    }

    public void runASync() {
        logger.info("runAsync");
    }

}
