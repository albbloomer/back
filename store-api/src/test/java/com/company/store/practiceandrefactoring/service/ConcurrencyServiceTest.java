package com.company.store.practiceandrefactoring.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class ConcurrencyServiceTest {

    private final ConcurrencyService concurrencyService = new ConcurrencyService();

    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> {
            concurrencyService.saveAndFind("userA");
        };

        Runnable userB = () -> {
            concurrencyService.saveAndFind("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");

        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start(); // Runnable 로직 실행
        sleep(100); // 동시성 문제 발생 O
        threadB.start(); // Runnable 로직 실행

        sleep(3000); // 메인 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}