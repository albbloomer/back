package com.company.programers;

import java.util.*;

public class CoteHighScoreKit2 {

    // Todo : 폰켓몬
    /**
     * <p>
     *     우선 문제에 쫄지 말기
     *     예시를 보면서 이해하기
     *     hashSet 은 int 가 들어가지 않기
     * </p>
     */
    static class Solution_1 {
        public int solution(int[] nums) {
            // 가질 수 있는 마리 수
            int answer = (nums.length) / 2;

            // 우선 중복이 있을 수 있으니까 nums -> hashSet
            HashSet<Integer> hs = new HashSet<>();
            for (int num : nums) {
                hs.add(num);
            }
            // 가질수 있는 마리 수 vs 종류 수
            if (hs.size() <= answer) {
                answer = hs.size();
            }

            return answer;
        }
    }
}
