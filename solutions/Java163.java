// 163. 등대

import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int[] road : lighthouse) {
            int a = road[0];
            int b = road[1];
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        
        int[][] dp = new int[n + 1][2];
        boolean[] visited = new boolean[n + 1];

        dfs(1, tree, dp, visited);
        
        return Math.min(dp[1][0], dp[1][1]);
    }

    private void dfs(int node, List<List<Integer>> tree, int[][] dp, boolean[] visited) {
        visited[node] = true;
        
        dp[node][0] = 1;
        dp[node][1] = 0;
        
        for (int next : tree.get(node)) {
            if (!visited[next]) {
                dfs(next, tree, dp, visited);
                
                dp[node][0] += Math.min(dp[next][0], dp[next][1]);
                dp[node][1] += dp[next][0];
            }
        }
    }
}
