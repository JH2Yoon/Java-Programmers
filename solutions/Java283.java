//283. 완전범죄

import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        final int INF = 1_000_000;
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int[] item : info) {
            int aCost = item[0];
            int bCost = item[1];

            int[] next = new int[m];
            Arrays.fill(next, INF);

            for (int b = 0; b < m; b++) {
                if (dp[b] == INF) continue;

                if (dp[b] + aCost < n) {
                    next[b] = Math.min(next[b], dp[b] + aCost);
                }

                if (b + bCost < m) {
                    next[b + bCost] = Math.min(next[b + bCost], dp[b]);
                }
            }

            dp = next;
        }

        int answer = INF;
        for (int b = 0; b < m; b++) {
            answer = Math.min(answer, dp[b]);
        }

        return answer == INF ? -1 : answer;
    }
}