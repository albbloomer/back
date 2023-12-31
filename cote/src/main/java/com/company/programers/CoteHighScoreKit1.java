package com.company.programers;

import java.util.*;

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


    // Todo : k 번째 수
    /**
     * <p>
     * 중용한 부분 <br>
     * - PriorityQueue 초기화 <br>
     * - PriorityQueue 내장된 함수
     * </p>
     */
    static class Solution_4 {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for(int i=0; i<commands.length; i++){
                int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(temp);
                answer[i] = temp[commands[i][2]-1];
            }

            return answer;
        }
    }

    // Todo : 최소 직사각형

    /**
     * 중요한 부분 <br>
     * - Math.max, Math.min  <br>
     * - 가로 정의, 세로 정의 <br>
     */
    static class Solution_5 {
        public int solution(int[][] sizes) {
            // 가로를 정의, 세로를 정의
            int maxGaro = 0;
            int maxSero = 0;

            for (int[] size : sizes) {

                int garo = Math.max(size[0], size[1]);
                int sero = Math.min(size[0], size[1]);

                maxGaro = Math.max(garo, maxGaro);
                maxSero = Math.max(sero, maxSero);
            }


            return maxGaro * maxSero;
        }
    }

    // Todo : 체육복
    static class Solution_6 {
        public int solution(int n, int[] lost, int[] reserve) {
            // Todo : 1
            int answer = n;

            Set<Integer> reserveSet = new HashSet<>();
            Set<Integer> lostSet = new HashSet<>();

            for (int r : reserve) {
                reserveSet.add(r);
            }

            for (int l : lost) {
                // 여벌 체육복을 가져온 학생이 체육복을 잃어버렸을 경우
                if (reserveSet.contains(l)) {
                    reserveSet.remove(l);
                } else {
                    lostSet.add(l);
                }
            }

            Set<Integer> removedFromLost = new HashSet<>();

            for (int l : lostSet) {
                if (reserveSet.contains(l - 1)) {
                    reserveSet.remove(l - 1);
                    removedFromLost.add(l);
                } else if (reserveSet.contains(l + 1)) {
                    reserveSet.remove(l + 1);
                    removedFromLost.add(l);
                }
            }

            // 임시 집합에 있는 요소를 lostSet에서 제거합니다.
            for (int r : removedFromLost) {
                lostSet.remove(r);
            }
            // Todo : 2
            int[] people = new int[n];
            int answer1 = n;

            for (int l : lost)
                people[l-1]--;
            for (int r : reserve)
                people[r-1]++;

            for (int i = 0; i < people.length; i++) {
                if(people[i] == -1) {
                    if(i-1>=0 && people[i-1] == 1) {
                        people[i]++;
                        people[i-1]--;
                    }else if(i+1< people.length && people[i+1] == 1) {
                        people[i]++;
                        people[i+1]--;
                    }else
                        answer1--;
                }
            }
            return answer1;
        }
    }

    // Todo : 타겟 넘버
    /**
     * DFS
     */
    static class Solution_7 {
        public int solution(int[] numbers, int target) {
            return dfs(numbers, 0, 0, target);
        }

        private int dfs(int[] numbers, int index, int sum, int target) {
            if (index == numbers.length) {
                if (sum == target) {
                    return 1;
                }
                return 0;
            }

            // 현재 숫자를 더하는 경우
            int count = dfs(numbers, index + 1, sum + numbers[index], target);

            // 현재 숫자를 빼는 경우
            count += dfs(numbers, index + 1, sum - numbers[index], target);

            return count;
        }
    }


    // Todo : 입국 심사
    /**
     * 이진 탐색
     */
    static class solution_8 {
        public long solution(int n, int[] times) {
            long answer = Long.MAX_VALUE;
            long minTime = 1;
            long maxTime = (long) n * getMax(times);

            while (minTime <= maxTime) {
                long midTime = (minTime + maxTime) / 2;
                long peopleProcessed = getPeopleProcessed(times, midTime);

                if (peopleProcessed < n) {
                    minTime = midTime + 1;
                } else {
                    answer = Math.min(answer, midTime);
                    maxTime = midTime - 1;
                }
            }

            return answer;
        }

        private long getPeopleProcessed(int[] times, long time) {
            long people = 0;
            for (int t : times) {
                people += time / t;
            }
            return people;
        }

        private long getMax(int[] times) {
            long max = 0;
            for (int t : times) {
                if (t > max) {
                    max = t;
                }
            }
            return max;
        }
    }

    static class solution_9 {
        public int solution(int n, int[][] edge) {
            ArrayList<Integer>[] path = new ArrayList[n];
            ArrayList<Integer> bfs = new ArrayList<Integer>();
            int answer = 0;
            int[] dist = new int[n];
            dist[0] = 1;
            int max = 0;

            for ( int i = 0; i < edge.length; i++) {
                int num1 = edge[i][0] - 1;
                int num2 = edge[i][1] - 1;
                if(path[num1] == null)
                    path[num1] = new ArrayList<Integer>();
                if(path[num2] == null)
                    path[num2] = new ArrayList<Integer>();
                path[num1].add(num2);
                path[num2].add(num1);
            }

            bfs.add(0);
            while(!bfs.isEmpty()) {
                int idx = bfs.get(0);
                bfs.remove(0);
                while(!path[idx].isEmpty()) {
                    int num = path[idx].get(0);
                    path[idx].remove(0);
                    bfs.add(num);
                    if(dist[num] == 0) {
                        dist[num] = dist[idx] + 1;
                        max = dist[num];
                    }
                }
            }
            for(int i = 0; i < n; i++) {
                if(dist[i] == max)
                    answer++;
            }

            return answer;
        }
    }
}
