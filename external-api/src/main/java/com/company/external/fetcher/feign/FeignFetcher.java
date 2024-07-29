package com.company.external.fetcher.feign;

import com.company.external.fetcher.Adapter;
import com.company.external.fetcher.dto.YulRequest;

@Adapter
public class FeignFetcher {

    private final GitHubFeignClient gitHubFeignClient;
    private final YulFeignClient yulFeignClient;

    public FeignFetcher(GitHubFeignClient gitHubFeignClient, YulFeignClient yulFeignClient) {
        this.gitHubFeignClient = gitHubFeignClient;
        this.yulFeignClient = yulFeignClient;
    }

    public void sendUnescapeData() {
        final String data = "<html>안녕하세요.민율입니다.</html>";
        yulFeignClient.sendEmail(new YulRequest("yul", data));
    }
}
