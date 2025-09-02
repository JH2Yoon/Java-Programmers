//247. 야근 지수

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) pq.offer(w);

        while (n > 0 && !pq.isEmpty()) {
            int max = pq.poll();
            if (max == 0) break;
            pq.offer(max - 1);
            n--;
        }

        long answer = 0;
        for (int w : pq) {
            answer += (long) w * w;
        }
        return answer;
    }
}