//291. 지역 이동

import java.util.*;

class Solution {
    static int N;
    static int[][] land;
    static int height;
    static int[][] group;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] landInput, int heightInput) {
        land = landInput;
        height = heightInput;
        N = land.length;
        group = new int[N][N];

        int groupId = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (group[i][j] == 0) {
                    bfs(i, j, ++groupId);
                }
            }
        }

        List<int[]> edges = new ArrayList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                    if (group[x][y] != group[nx][ny]) {
                        int cost = Math.abs(land[x][y] - land[nx][ny]);
                        edges.add(new int[]{
                                group[x][y],
                                group[nx][ny],
                                cost
                        });
                    }
                }
            }
        }

        return mst(groupId, edges);
    }

    void bfs(int sx, int sy, int id) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        group[sx][sy] = id;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (group[nx][ny] != 0) continue;

                if (Math.abs(land[x][y] - land[nx][ny]) <= height) {
                    group[nx][ny] = id;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    int mst(int nodes, List<int[]> edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }

        boolean[] visited = new boolean[nodes + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[]{1, 0});
        int totalCost = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            if (visited[node]) continue;
            visited[node] = true;
            totalCost += cost;

            for (int[] next : graph.get(node)) {
                if (!visited[next[0]]) {
                    pq.add(next);
                }
            }
        }

        return totalCost;
    }
}

