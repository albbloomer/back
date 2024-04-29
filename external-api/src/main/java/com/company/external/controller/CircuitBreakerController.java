package com.company.external.controller;

import com.company.external.service.CircuitBreakerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
     *
     *
     *  '성공 코드' 만 작성할 경우, @ApiResponse(responseCode = "1000", description = "요청에 성공하였습니다.", content = @Content(mediaType = "application/json")) <br>
     *
     * @Paramter 를 통해, Query String, Body Field 명세 <br>
     *
     * 참고 : https://velog.io/@gmlstjq123/SpringBoot-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%EC%97%90-Swagger-UI-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0 <br>
     */
    @Operation(summary = "api call", description = "api test API")
    @GetMapping("/circuit/api-call")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "1000", description = "요청에 성공하였습니다.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "2002", description = "이미 가입된 계정입니다.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4000", description = "데이터베이스 연결에 실패하였습니다.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4011", description = "비밀번호 암호화에 실패하였습니다.", content = @Content(mediaType = "application/json"))
    })
    public String apiCall(
            @Parameter(name = "email", description = "이메일", example = "minyul@naver.com") @RequestParam String param) throws InterruptedException {
        return circuitBreakerService.process(param);
    }

};