package com.company.store.sample.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class ThreadPoolTest {

    private static final AtomicInteger count = new AtomicInteger(0);

    // 서버를 구동시킨 후, 서버의 로그(Application 의 로그임) 를 본다.
    // [시나리오] 는 application-thread.yml
    // - 테스트 통과, 실패 는 무의미함
    @DisplayName("Thread Pool 테스트")
    @Test
    void threadPool_Test() throws Exception {
        var threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> incrementIfOk(TestHttpUtils.send("/thread-test"))); // 각 스레드를 초기화
        }

        for (final var thread : threads) {
            thread.start();
            Thread.sleep(50); //  각 스레드 사이에 50밀리초의 지연을 추가.스레드들 사이에 약간의 시간 차이
        }

        for (final var thread : threads) {
            thread.join();   // 모든 스레드가 작업을 완료할 때까지 대기
        }

        assertThat(count.intValue()).isEqualTo(10);
    }

    private static void incrementIfOk(final HttpResponse<String> response) {
        if (response.statusCode() == 200) {
            count.incrementAndGet();
        }
    }
}