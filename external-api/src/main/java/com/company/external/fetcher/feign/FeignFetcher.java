package com.company.external.fetcher.feign;

import com.company.external.fetcher.Adapter;
import org.springframework.cloud.openfeign.FeignClient;

@Adapter
public class FeignFetcher {

    private final GitHubFeignClient gitHubFeignClient;

    public FeignFetcher(GitHubFeignClient gitHubFeignClient) {
        this.gitHubFeignClient = gitHubFeignClient;
    }


}
