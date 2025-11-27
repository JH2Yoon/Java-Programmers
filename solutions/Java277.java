//277. 서버 증설 횟수

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int t = 0; t < 24; t++) {

            while (!pq.isEmpty() && pq.peek() <= t) pq.poll();

            int needed = players[t] / m;
            int active = pq.size();

            if (needed > active) {
                int add = needed - active;
                answer += add;

                for (int i = 0; i < add; i++) {
                    pq.offer(t + k);
                }
            }
        }

        return answer;
    }
}