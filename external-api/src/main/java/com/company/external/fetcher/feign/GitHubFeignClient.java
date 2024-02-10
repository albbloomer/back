package com.company.external.fetcher.feign;

import com.company.external.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "githubFeignClient", url = "${api.github.list}", configuration = FeignConfig.class)
public interface GitHubFeignClient {

}
