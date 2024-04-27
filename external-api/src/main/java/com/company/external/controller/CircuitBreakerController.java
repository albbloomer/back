package com.company.external.controller;

import com.company.external.service.CircuitBreakerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
@Tag(name = "Circuit Breaker Controller", description = "디테일")
public class CircuitBreakerController {

    private final CircuitBreakerService circuitBreakerService;

    public CircuitBreakerController(CircuitBreakerService circuitBreakerService) {
        this.circuitBreakerService = circuitBreakerService;
    }


    /**
     *  해당 API 를 호출한다. 가령, param "a"를 계속 보냈을 떄, Exception 이 계속적으로 터지면서 application.yml 에 적혀있듯 <br>
     *  해당 구성에 따라서 circuit state 가 close -> open 으로 된다 <br>
     *  구성된, 적용된 시간에 따라 open -> half_open 으로 상태가 변환되고 <br>
     *  변환된 half_open 에서 다시한번 호출하면 정상적으로 트래픽이 들어온다. <br>
     *  - 만약, 여기서 계속적인 exception 이 나면 다시 open 으로 되며 반대인 경우에는 close 로 상태르 회복한다. <br>
     */
    @Operation(summary = "api call", description = "api test API")
    @GetMapping("/circuit/api-call")
    public String apiCall(@RequestParam String param) throws InterruptedException {
        return circuitBreakerService.process(param);
    }

};