// 161. 카운트 다운

class Solution {
    public int[] solution(int target) {
        int[] dp = new int[target + 1];
        int[] count = new int[target + 1];
        
        for (int i = 0; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            count[i] = 0;
        }
        dp[0] = 0;
        
        for (int i = 1; i <= 20; i++) {
            int[] scores = {i, 2*i, 3*i};
            for (int score : scores) {
                for (int j = score; j <= target; j++) {
                    if (dp[j - score] + 1 < dp[j]) {
                        dp[j] = dp[j - score] + 1;
                        count[j] = count[j - score] + (score == i ? 1 : 0);
                    } else if (dp[j - score] + 1 == dp[j] && count[j - score] + (score == i ? 1 : 0) > count[j]) {
                        count[j] = count[j - score] + (score == i ? 1 : 0);
                    }
                }
            }
        }
        
        for (int j = 50; j <= target; j++) {
            if (dp[j - 50] + 1 < dp[j]) {
                dp[j] = dp[j - 50] + 1;
                count[j] = count[j - 50] + 1;
            } else if (dp[j - 50] + 1 == dp[j] && count[j - 50] + 1 > count[j]) {
                count[j] = count[j - 50] + 1;
            }
        }
        
        return new int[]{dp[target], count[target]};
    }
}
