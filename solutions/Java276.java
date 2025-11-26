//276. 코딩 테스트 공부

import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {

        int maxAlp = 0, maxCop = 0;
        for (int[] p : problems) {
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }

        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);

        int[][] dp = new int[maxAlp + 1][maxCop + 1];

        for (int i = 0; i <= maxAlp; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;

        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {

                if (dp[i][j] == Integer.MAX_VALUE) continue;

                if (i + 1 <= maxAlp) dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);

                if (j + 1 <= maxCop) dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                for (int[] p : problems) {
                    int reqA = p[0], reqC = p[1];
                    int rewardA = p[2], rewardC = p[3], cost = p[4];

                    if (i >= reqA && j >= reqC) {
                        int nextA = Math.min(maxAlp, i + rewardA);
                        int nextC = Math.min(maxCop, j + rewardC);

                        dp[nextA][nextC] = Math.min(dp[nextA][nextC], dp[i][j] + cost);
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }
}