package com.company.store.practiceandrefactoring.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcurrencyService {
    private String nameStore;
    /**
     *  newNameStore.set(name);
     *  newNameStore.get();
     *
     *  처럼 해당 부분을 String nameStore 가 아닌 ThreadLocal< String > newNameStore 로 하면 동시성을 해결할 수 있다.
     *  [주의] : 현재 WAS 에서의 쓰레드풀을 쓰는데 만약, LocalThread 를 비워주지않늗나면 재사용할 때, 과거 데이터가 남아있을 수 있다.
     *
     *  ThreadLocal.remove()
     */
    private ThreadLocal<String> newNameStore = new ThreadLocal<>();

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