//304. 캠핑

import java.util.*;

class Solution {
    public int solution(int n, int[][] data) {
        int[] xs = new int[n];
        int[] ys = new int[n];

        for (int i = 0; i < n; i++) {
            xs[i] = data[i][0];
            ys[i] = data[i][1];
        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        int xi = 1, yi = 1;
        for (int x : xs) {
            if (!xMap.containsKey(x)) xMap.put(x, xi++);
        }
        for (int y : ys) {
            if (!yMap.containsKey(y)) yMap.put(y, yi++);
        }

        int sizeX = xi;
        int sizeY = yi;

        int[][] grid = new int[sizeX][sizeY];

        for (int i = 0; i < n; i++) {
            int x = xMap.get(data[i][0]);
            int y = yMap.get(data[i][1]);
            grid[x][y] = 1;
        }

        int[][] psum = new int[sizeX][sizeY];

        for (int i = 1; i < sizeX; i++) {
            for (int j = 1; j < sizeY; j++) {
                psum[i][j] = grid[i][j]
                        + psum[i-1][j]
                        + psum[i][j-1]
                        - psum[i-1][j-1];
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int x1 = xMap.get(data[i][0]);
            int y1 = yMap.get(data[i][1]);

            for (int j = i + 1; j < n; j++) {
                int x2 = xMap.get(data[j][0]);
                int y2 = yMap.get(data[j][1]);

                if (x1 == x2 || y1 == y2) continue;

                int lx = Math.min(x1, x2);
                int rx = Math.max(x1, x2);
                int ly = Math.min(y1, y2);
                int ry = Math.max(y1, y2);

                int cnt = query(psum, lx + 1, ly + 1, rx - 1, ry - 1);

                if (cnt == 0) answer++;
            }
        }

        return answer;
    }

    int query(int[][] psum, int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) return 0;

        return psum[x2][y2]
                - psum[x1 - 1][y2]
                - psum[x2][y1 - 1]
                + psum[x1 - 1][y1 - 1];
    }
}