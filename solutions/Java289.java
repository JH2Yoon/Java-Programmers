//289. 상담원 인원

import java.util.*;

class Solution {

    static final int INF = Integer.MAX_VALUE;
    int k, n;
    List<int[]>[] typeReqs;
    int[][] cost;
    int answer = INF;

    public int solution(int k, int n, int[][] reqs) {
        this.k = k;
        this.n = n;

        typeReqs = new ArrayList[k];
        for (int i = 0; i < k; i++) typeReqs[i] = new ArrayList<>();

        for (int[] r : reqs) {
            typeReqs[r[2] - 1].add(new int[]{r[0], r[1]});
        }

        cost = new int[k][n + 1];
        for (int i = 0; i < k; i++) {
            for (int m = 1; m <= n; m++) {
                cost[i][m] = calcWait(typeReqs[i], m);
            }
        }

        dfs(0, n, new int[k]);

        return answer;
    }

    void dfs(int idx, int remain, int[] alloc) {
        if (idx == k) {
            if (remain == 0) {
                int sum = 0;
                for (int i = 0; i < k; i++) {
                    sum += cost[i][alloc[i]];
                }
                answer = Math.min(answer, sum);
            }
            return;
        }

        for (int i = 1; i <= remain - (k - idx - 1); i++) {
            alloc[idx] = i;
            dfs(idx + 1, remain - i, alloc);
        }
    }

    int calcWait(List<int[]> reqs, int m) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) pq.offer(0);

        int wait = 0;
        for (int[] r : reqs) {
            int start = r[0];
            int time = r[1];

            int end = pq.poll();
            if (end > start) {
                wait += end - start;
                pq.offer(end + time);
            } else {
                pq.offer(start + time);
            }
        }
        return wait;
    }
}
