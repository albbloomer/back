package com.company.programers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class CoteHighScoreKit1 {

    // Todo : 완주하지 못한 선수
    /**
     * <p>
     * 중용한 부분 <br>
     * - HashMap 초기화 <br>
     * - HashMap 내장된 함수
     * </p>
     */
    static class Solution_1 {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> hm = new HashMap<>();
            for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
            for (String player : completion) hm.put(player, hm.get(player) - 1);

            for (String key : hm.keySet()) {
                if (hm.get(key) != 0){
                    answer = key;
                }
            }
            return answer;
        }
    }

    // Todo : 같은 숫자는 싫어
    /**
     * <p>
     * 중용한 부분 <br>
     * - Stack, List 초기화 <br>
     * - Stack, List 내장된 함수
     * </p>
     */
    static class Solution_2 {
        public int[] solution(int[] arr) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    list.add(arr[i]);
                }
            }
            int[] answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

    // Todo : 더 맵게
    /**
     * <p>
     * 중용한 부분 <br>
     * - PriorityQueue 초기화 <br>
     * - PriorityQueue 내장된 함수
     * </p>
     */
    static class Solution_3 {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> heap = new PriorityQueue<>();

            for (int scov : scoville) {
                heap.add(scov);
            }
            while (heap.size() > 1 && heap.peek() < K) {
                int leastSpicy = heap.poll(); // 가장 안 매운 음식
                int secondLeastSpicy = heap.poll(); // 두 번째로 안 매운 음식

                int mixed = leastSpicy + (secondLeastSpicy * 2);
                heap.add(mixed);
                answer++;
            }

            // 모든 음식의 스코빌 지수가 K 이상인지 확인
            if (heap.peek() < K) {
                return -1;
            }

            return answer;
        }
    }
}
