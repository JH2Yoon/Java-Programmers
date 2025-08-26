//245. 등굣길

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        long[][] dp = new long[n + 1][m + 1];
        boolean[][] water = new boolean[n + 1][m + 1];

        for (int[] p : puddles) {
            int x = p[0], y = p[1];
            if (1 <= x && x <= m && 1 <= y && y <= n) {
                water[y][x] = true;
            }
        }

        dp[1][1] = 1;
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (y == 1 && x == 1) continue;
                if (water[y][x]) {
                    dp[y][x] = 0;
                } else {
                    dp[y][x] = ((dp[y-1][x] + dp[y][x-1]) % MOD);
                }
            }
        }
        return (int)(dp[n][m] % MOD);
    }
}
