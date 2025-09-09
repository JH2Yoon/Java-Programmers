//249. 최적의 행렬 곱셈

class Solution {
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        int[] p = new int[n + 1];
        p[0] = matrix_sizes[0][0];
        for (int i = 0; i < n; i++) {
            p[i+1] = matrix_sizes[i][1];
        }

        int[][] dp = new int[n+1][n+1];

        for (int length = 2; length <= n; length++) {
            for (int i = 1; i <= n - length + 1; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + p[i-1] * p[k] * p[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n];
    }
}