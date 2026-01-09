//290. 에어컨

import java.util.*;

class Solution {
    static final int INF = 1_000_000_000;

    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int n = onboard.length;
        int OFFSET = 10;
        int MAX = 50;

        int[][] dp = new int[n][MAX + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][temperature + OFFSET] = 0;

        for (int time = 0; time < n - 1; time++) {
            for (int t = 0; t <= MAX; t++) {
                if (dp[time][t] == INF) continue;

                int currTemp = t - OFFSET;

                int offNext = currTemp;
                if (currTemp < temperature) offNext++;
                else if (currTemp > temperature) offNext--;

                if (isValid(offNext, onboard[time + 1], t1, t2)) {
                    dp[time + 1][offNext + OFFSET] =
                            Math.min(dp[time + 1][offNext + OFFSET], dp[time][t]);
                }

                for (int d = -1; d <= 1; d++) {
                    int nextTemp = currTemp + d;
                    if (nextTemp < -10 || nextTemp > 40) continue;

                    int cost = (d == 0) ? b : a;

                    if (isValid(nextTemp, onboard[time + 1], t1, t2)) {
                        dp[time + 1][nextTemp + OFFSET] =
                                Math.min(dp[time + 1][nextTemp + OFFSET],
                                        dp[time][t] + cost);
                    }
                }
            }
        }

        int answer = INF;
        for (int t = 0; t <= MAX; t++) {
            answer = Math.min(answer, dp[n - 1][t]);
        }
        return answer;
    }

    private boolean isValid(int temp, int onboard, int t1, int t2) {
        if (onboard == 0) return true;
        return temp >= t1 && temp <= t2;
    }
}
