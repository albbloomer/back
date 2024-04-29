package com.company.store.practiceandrefactoring.controller;

import com.company.store.common.exception.BusinessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/return")
@RestController
public class ReturnController {

    /**
     *
     * 1. ResponseEntity 를 사용하는 이유 : 같단히 Dto, String 등의 데이터를 넘기면 HTTP 응답 제어를 할 수 없다.  적절한 상태 코드와 응답 헤더 및 응답 본문을 생성해서 클라이언트에 전달 <br>
     * 2.
     *
     */
    @GetMapping("/get-type")
    public ResponseEntity<String> getType() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("name", "yul");

        return ResponseEntity.ok()
                .headers(headers)
                .body("ok");
    }

    /**
     * BusinessException 예제
     *  GlobalExceptionHandler 에서 그 해당 Business Exception 에 잡힌다.
     *  현재 Handler 에서 500Internal Server Error 를 일으킴.
     */
    @GetMapping("/get-type/business-exception")
    public ResponseEntity<String> getErrorType() {

        throw new BusinessException("비지니스 Exception");
    }

}
