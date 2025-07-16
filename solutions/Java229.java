//229. 3 x n 타일링

class Solution {
    public int solution(int n) {
        final int MOD = 1_000_000_007;
        if (n % 2 != 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = (int)((3L * dp[i - 2]) % MOD);
            for (int j = 4; j <= i; j += 2) {
                dp[i] = (int)((dp[i] + 2L * dp[i - j]) % MOD);
            }
        }

        return dp[n];
    }
}
