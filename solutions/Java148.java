// 148. 섬 연결하기

import java.util.*;

public class Solution {
    public int solution(int n, int[][] costs) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int answer = 0;
        int edgesUsed = 0;

        for (int[] cost : costs) {
            int island1 = cost[0];
            int island2 = cost[1];
            int costValue = cost[2];
            
            if (find(parent, island1) != find(parent, island2)) {
                union(parent, island1, island2);
                answer += costValue;
                edgesUsed++;
                
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }
        
        return answer;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
