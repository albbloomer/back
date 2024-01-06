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

    // Todo : 기능 개발
    /**
     * <p>
     *     Queue
     * </p>
     */
    static class Solution_2 {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> answerList = new ArrayList<>();

            for (int i = 0; i < progresses.length; i++) {
                // 각 작업이 완료되는 데 필요한 일수 계산
                int days = (100 - progresses[i]) / speeds[i];
                if ((100 - progresses[i]) % speeds[i] != 0) {
                    days++;
                }
                if (!queue.isEmpty() && queue.peek() < days) {
                    // 이전 작업보다 더 오래 걸리는 작업을 만났을 때
                    answerList.add(queue.size());
                    queue.clear();
                }
                queue.add(days);
            }
            answerList.add(queue.size()); // 마지막 배포 추가

            return answerList.stream().mapToInt(i -> i).toArray();
        }
    }

    // Todo : 디스크 컨트롤러
    /**
     * <p>
     *     Queue
     * </p>
     */
    static class Solution_3 {
        public int solution(int[][] jobs) {
            PriorityQueue<Work> startQueue = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
            PriorityQueue<Work> timeQueue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);

            for(int[] work : jobs) {
                startQueue.offer(new Work(work[0], work[1]));
            }

            int answer = 0;
            int startTime = startQueue.peek().start;
            while(!startQueue.isEmpty()){
                while(true){
                    if(!startQueue.isEmpty() && startTime >= startQueue.peek().start)
                        timeQueue.offer(startQueue.poll());
                    else
                        break;
                }

                if(!timeQueue.isEmpty()) {
                    Work task = timeQueue.poll();
                    answer += startTime + task.time - task.start;
                    startTime += task.time;
                }
                else{
                    Work task = startQueue.poll();
                    answer += task.time;
                    startTime = task.time + task.start;
                }

                while(!timeQueue.isEmpty())
                    startQueue.offer(timeQueue.poll());
            }

            return answer / jobs.length;
        }
        public static class Work {
            private final int start;
            private final int time;

            public Work(int start, int time){
                this.start = start;
                this.time = time;
            }
        }
    }

    // Todo : 가장 큰수 - 정렬
    static class Solution_4 {
        public String solution(int[] numbers) {
            String[] numStrs = new String[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                numStrs[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b)); // 내림차순


            if (numStrs[0].equals("0")) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            for (String num : numStrs) {
                sb.append(num);
            }

            return sb.toString();
        }
    }

    // Todo : 모의고사- 완전탐색
    static class Solution_6 {
        public int[] solution(int[] answers) {
            // 각 수포자의 찍기 패턴
            int[] supoja1 = {1, 2, 3, 4, 5};
            int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            // 각 수포자가 맞힌 문제 수
            int[] score = new int[3];

            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == supoja1[i % supoja1.length]) score[0]++;
                if (answers[i] == supoja2[i % supoja2.length]) score[1]++;
                if (answers[i] == supoja3[i % supoja3.length]) score[2]++;
            }

            // 가장 높은 점수 찾기
            int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

            // 가장 높은 점수를 받은 사람 찾기
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                if (score[i] == maxScore) {
                    list.add(i + 1);
                }
            }

            // 결과 반환
            return list.stream().mapToInt(i -> i).toArray();
        }
    }

    // Todo : 네트워크 - DFS/BFS
    static class Solution_7 {
        public int solution(int n, int[][] computers) {
            boolean[] visited = new boolean[n];
            int answer = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(computers, visited, i);
                    answer++;
                }
            }

            return answer;
        }

        private void dfs(int[][] computers, boolean[] visited, int start) {
            visited[start] = true;

            for (int i = 0; i < computers.length; i++) {
                if (computers[start][i] == 1 && !visited[i]) {
                    dfs(computers, visited, i);
                }
            }
        }
    }
}
