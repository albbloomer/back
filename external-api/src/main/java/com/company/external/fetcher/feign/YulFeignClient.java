package com.company.external.fetcher.feign;

import com.company.external.config.NotEscapeFeignConfig;
import com.company.external.fetcher.dto.YulRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "yulFeignClient", url = "${api.yul}", configuration = NotEscapeFeignConfig.class)
public interface YulFeignClient {

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<String> sendEmail(@RequestBody YulRequest yulRequest);
}
