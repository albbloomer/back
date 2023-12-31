package com.company.programers;

import java.util.HashMap;

public class CoteHighScoreKit {

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
}
