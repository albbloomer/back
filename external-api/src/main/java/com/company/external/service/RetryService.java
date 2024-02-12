package com.company.external.service;

import com.company.external.exception.RetryException;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetryService {

    private static final String SIMPLE_RETRY_CONFIG = "simpleRetryConfig";

    @Retry(name = SIMPLE_RETRY_CONFIG, fallbackMethod = "fallback")
    public String process(String param) {
        return callAnotherServer(param);
    }

    /**
     *     Todo : 해당 부분은 만약 resilience4j 를 쓰지 않았을 떄, 순수 하드 코딩 <br>
     *     private static final int MAX_ATTEMPS = 3;
     *     private static final int WAIT_DURATION = 1000;
     *
     *     public String process(String param) throws InterruptedException {
     *         String result = null;
     *
     *         int retryCount = 0;
     *
     *         while (retryCount++ < MAX_ATTEMPS) {
     *             try {
     *                 result = callAnotherServer(param);
     *             } catch (RetryException ex) {
     *                 if (retryCount == MAX_ATTEMPS) {
     *                     return fallback(param, ex);
     *                 }
     *
     *                 Thread.sleep(WAIT_DURATION);
     *             }
     *
     *             if (result != null)
     *                 break;
     *         }
     *
     *         return result;
     *     }
     */


    private String fallback(String param, Exception ex) {
        // retry에 전부 실패해야 fallback이 실행
        log.info("fallback! your request is " + param);
        return "Recovered: " + ex.toString();
    }

    private String callAnotherServer(String param) {
        // retry exception은 retry된다.
        throw new RetryException("retry exception");
        // ignore exception은 retry하지 않고 바로 예외가 클라이언트에게 전달된다.
//        throw new IgnoreException("ignore exception");
    }

};