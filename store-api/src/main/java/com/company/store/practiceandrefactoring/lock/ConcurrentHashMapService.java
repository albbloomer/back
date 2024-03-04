package com.company.store.practiceandrefactoring.lock;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class ConcurrentHashMapService {

    private final ConcurrentHashMap<String, Lock> locks = new ConcurrentHashMap<>();

    public void performTask(String key) {
        locks.putIfAbsent(key, new ReentrantLock());
        Lock lock = locks.get(key);
        lock.lock(); // 잠금 획득
        try {
            System.out.println("Task for key " + key + " is being performed...");
        } finally {
            lock.unlock();
        }
    }
}
