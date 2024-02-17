package com.company.store.practiceandrefactoring.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcurrencyService {
    private String nameStore;

    public String saveAndFind(String name) {
        log.info("[저장] | 현재 저장된 값 nameStore = {}, 저장할 값 : name = {} ",nameStore, name);
        nameStore = name;
        sleep(1000);
        log.info("[조회] | 현재 저장된 값  = {}", nameStore);
        return nameStore;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}