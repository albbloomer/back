package com.company.store.practiceandrefactoring.reactive;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyExample {

    public static void main(String[] args) {
        int cpuCores = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU 개수 : " + cpuCores);
        List<Integer> data = new ArrayList<>();

        for (int index = 0 ; index < cpuCores ; ++index) {
            data.add(index);
        }

        /**
         * cpu 개수 만큼 또는 그것보다 적은 스레드를 처리할 때는 동시 ( 병렬성 )에 처리가 가능 <br>
         * 다만, cpu 개수가 적고 그것보다 많은 스레드가 있는 경우 병렬 및 동시에 처리를 할 수 있다 ( 조합 )
         */
        long startTime = System.currentTimeMillis();
        long sum1 = data.parallelStream()
                .mapToLong(index -> {
                    try {
                        Thread.sleep(500L);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return index + index;
                })
                .sum();

        long endTime = System.currentTimeMillis();
        System.out.print("CPU 개수만큼 데이터를 병렬로 처리하는데 걸린 시간 : " + (endTime - startTime) + "ms");
    }
}
