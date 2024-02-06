package com.company.external.service;

import com.company.external.fetcher.webclient.WebClientFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonBlockingService {

    private static final Logger logger = LoggerFactory.getLogger(BlockingService.class);

    private final WebClientFetcher webClientFetcher;

    public NonBlockingService(WebClientFetcher webClientFetcher) {
        this.webClientFetcher = webClientFetcher;
    }

    public void webClientStreamTest() {
        List<String> typeList = List.of("typeA", "typeB", "typeC");
        List<Integer> collect = typeList
                .stream()
                .map(webClientFetcher::getResponse) // Todo : stream 일 때, 해당 외부 api 를 호출할 떄 어떻게하는 것이 가장 좋을까 ?
                .toList();

        for (Integer value : collect) {
            logger.info("value [{}]", value);
        }
    }
}
