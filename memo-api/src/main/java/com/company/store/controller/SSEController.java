package com.company.store.controller;

import com.company.store.service.SSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class SSEController {

    private final SSEService sseService;

    @Autowired
    public SSEController(SSEService sseService) {
        this.sseService = sseService;
    }

    /**
     * 클라이언트가 특정 프로젝트에 대해 구독하는 엔드포인트.
     * @param projectId 구독하려는 프로젝트 ID
     * @param userId    구독할 사용자의 ID
     * @return SSE 스트리밍 데이터
     */
    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamEvents(@RequestParam("userId") Long userId, @RequestParam("projectId") Long projectId) {
        // 구독을 요청하면, 서비스에서 해당 프로젝트에 대한 구독을 처리하고
        // fakeKafkaData를 2초마다 호출하여 임의의 데이터를 발행
        sseService.fakeKafkaData(projectId);

        return sseService.subscribe(userId, projectId);
    }
}
