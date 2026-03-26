//305. [PCCP 기출문제] 4번 / 수레 움직이기

import java.util.*;

class Solution {
    int n, m;
    int[][] maze;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(int[][] maze) {
        this.maze = maze;
        n = maze.length;
        m = maze[0].length;

        int rx = 0, ry = 0, bx = 0, by = 0;
        int rgx = 0, rgy = 0, bgx = 0, bgy = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) { rx = i; ry = j; }
                if (maze[i][j] == 2) { bx = i; by = j; }
                if (maze[i][j] == 3) { rgx = i; rgy = j; }
                if (maze[i][j] == 4) { bgx = i; bgy = j; }
            }
        }

        Queue<State> q = new ArrayDeque<>();
        Set<State> visited = new HashSet<>();

        int rMask = 1 << (rx * m + ry);
        int bMask = 1 << (bx * m + by);

        State start = new State(rx, ry, bx, by, rMask, bMask, 0);
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.rx == rgx && cur.ry == rgy &&
                    cur.bx == bgx && cur.by == bgy) {
                return cur.dist;
            }

            List<int[]> rMoves = getMoves(cur.rx, cur.ry, rgx, rgy);
            List<int[]> bMoves = getMoves(cur.bx, cur.by, bgx, bgy);

            for (int[] rm : rMoves) {
                for (int[] bm : bMoves) {
                    int nrx = rm[0], nry = rm[1];
                    int nbx = bm[0], nby = bm[1];

                    if (nrx == nbx && nry == nby) continue;

                    if (nrx == cur.bx && nry == cur.by &&
                            nbx == cur.rx && nby == cur.ry) continue;

                    int rIdx = nrx * m + nry;
                    int bIdx = nbx * m + nby;

                    int newRMask = cur.rMask;
                    int newBMask = cur.bMask;

                    if (!(cur.rx == rgx && cur.ry == rgy)) {
                        if ((cur.rMask & (1 << rIdx)) != 0) continue;
                        newRMask |= (1 << rIdx);
                    }

                    if (!(cur.bx == bgx && cur.by == bgy)) {
                        if ((cur.bMask & (1 << bIdx)) != 0) continue;
                        newBMask |= (1 << bIdx);
                    }

                    State next = new State(nrx, nry, nbx, nby,
                            newRMask, newBMask,
                            cur.dist + 1);

                    if (visited.add(next)) {
                        q.add(next);
                    }
                }
            }
        }

        return 0;
    }

    List<int[]> getMoves(int x, int y, int gx, int gy) {
        List<int[]> list = new ArrayList<>();

        if (x == gx && y == gy) {
            list.add(new int[]{x, y});
            return list;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (maze[nx][ny] == 5) continue;

            list.add(new int[]{nx, ny});
        }

        return list;
    }

    static class State {
        int rx, ry, bx, by, rMask, bMask, dist;

        State(int rx, int ry, int bx, int by,
              int rMask, int bMask, int dist) {
            this.rx = rx; this.ry = ry;
            this.bx = bx; this.by = by;
            this.rMask = rMask; this.bMask = bMask;
            this.dist = dist;
        }

        public boolean equals(Object o) {
            State s = (State) o;
            return rx == s.rx && ry == s.ry &&
                    bx == s.bx && by == s.by &&
                    rMask == s.rMask && bMask == s.bMask;
        }

        public int hashCode() {
            return Objects.hash(rx, ry, bx, by, rMask, bMask);
        }
    }
}