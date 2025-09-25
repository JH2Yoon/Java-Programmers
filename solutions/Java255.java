//255. 합승 택시 요금

class Solution {
    static final int INF = 20000001; // 최대 요금 100,000 * 200보다 큰 값

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n+1][n+1];

        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                if (i==j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int[] f : fares) {
            int u = f[0], v = f[1], w = f[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        for (int k=1;k<=n;k++) {
            for (int i=1;i<=n;i++) {
                for (int j=1;j<=n;j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int answer = INF;
        for (int k=1;k<=n;k++) {
            answer = Math.min(answer, dist[s][k] + dist[k][a] + dist[k][b]);
        }

        return answer;
    }
}