//303. 바이러스 파이프

import java.util.*;

class Solution {
    int n, k;
    List<Integer>[][] graph;
    int max = 0;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.k = k;

        graph = new ArrayList[4][n + 1];
        for (int t = 1; t <= 3; t++) {
            for (int i = 1; i <= n; i++) {
                graph[t][i] = new ArrayList<>();
            }
        }

        for (int[] e : edges) {
            int a = e[0], b = e[1], t = e[2];
            graph[t][a].add(b);
            graph[t][b].add(a);
        }

        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        dfs(0, infected, -1);

        return max;
    }

    void dfs(int depth, boolean[] infected, int prevType) {
        int count = count(infected);
        max = Math.max(max, count);

        if (depth == k || count == n) return;

        for (int t = 1; t <= 3; t++) {
            if (t == prevType) continue;

            boolean[] next = infected.clone();
            boolean changed = spread(next, t);

            if (!changed) continue;

            dfs(depth + 1, next, t);
        }
    }

    boolean spread(boolean[] infected, int type) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (infected[i]) {
                q.add(i);
                visited[i] = true;
            }
        }

        boolean changed = false;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[type][cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    if (!infected[next]) {
                        infected[next] = true;
                        changed = true;
                    }
                    q.add(next);
                }
            }
        }

        return changed;
    }

    int count(boolean[] infected) {
        int c = 0;
        for (int i = 1; i <= n; i++) {
            if (infected[i]) c++;
        }
        return c;
    }
}