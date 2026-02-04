//295. 블록 이동하기

import java.util.*;

class Solution {
    static class Robot {
        int x1, y1, x2, y2, time;

        Robot(int x1, int y1, int x2, int y2, int time) {
            if (x1 < x2 || (x1 == x2 && y1 < y2)) {
                this.x1 = x1; this.y1 = y1;
                this.x2 = x2; this.y2 = y2;
            } else {
                this.x1 = x2; this.y1 = y2;
                this.x2 = x1; this.y2 = y1;
            }
            this.time = time;
        }
    }

    public int solution(int[][] board) {
        int N = board.length;
        boolean[][][][] visited = new boolean[N][N][N][N];
        Queue<Robot> q = new LinkedList<>();

        q.add(new Robot(0, 0, 0, 1, 0));
        visited[0][0][0][1] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            Robot cur = q.poll();

            if ((cur.x1 == N - 1 && cur.y1 == N - 1) ||
                    (cur.x2 == N - 1 && cur.y2 == N - 1)) {
                return cur.time;
            }

            for (int d = 0; d < 4; d++) {
                int nx1 = cur.x1 + dx[d];
                int ny1 = cur.y1 + dy[d];
                int nx2 = cur.x2 + dx[d];
                int ny2 = cur.y2 + dy[d];

                if (isValid(nx1, ny1, nx2, ny2, board, N)
                        && !visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    q.add(new Robot(nx1, ny1, nx2, ny2, cur.time + 1));
                }
            }

            if (cur.x1 == cur.x2) {
                for (int dir : new int[]{-1, 1}) {
                    if (check(board, cur.x1 + dir, cur.y1, cur.x2 + dir, cur.y2, N)) {
                        if (!visited[cur.x1][cur.y1][cur.x1 + dir][cur.y1]) {
                            visited[cur.x1][cur.y1][cur.x1 + dir][cur.y1] = true;
                            q.add(new Robot(cur.x1, cur.y1, cur.x1 + dir, cur.y1, cur.time + 1));
                        }
                        if (!visited[cur.x2][cur.y2][cur.x2 + dir][cur.y2]) {
                            visited[cur.x2][cur.y2][cur.x2 + dir][cur.y2] = true;
                            q.add(new Robot(cur.x2, cur.y2, cur.x2 + dir, cur.y2, cur.time + 1));
                        }
                    }
                }
            } else {
                for (int dir : new int[]{-1, 1}) {
                    if (check(board, cur.x1, cur.y1 + dir, cur.x2, cur.y2 + dir, N)) {
                        if (!visited[cur.x1][cur.y1][cur.x1][cur.y1 + dir]) {
                            visited[cur.x1][cur.y1][cur.x1][cur.y1 + dir] = true;
                            q.add(new Robot(cur.x1, cur.y1, cur.x1, cur.y1 + dir, cur.time + 1));
                        }
                        if (!visited[cur.x2][cur.y2][cur.x2][cur.y2 + dir]) {
                            visited[cur.x2][cur.y2][cur.x2][cur.y2 + dir] = true;
                            q.add(new Robot(cur.x2, cur.y2, cur.x2, cur.y2 + dir, cur.time + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    private boolean isValid(int x1, int y1, int x2, int y2, int[][] board, int N) {
        return check(board, x1, y1, x2, y2, N);
    }

    private boolean check(int[][] board, int x1, int y1, int x2, int y2, int N) {
        return x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0
                && x1 < N && y1 < N && x2 < N && y2 < N
                && board[x1][y1] == 0 && board[x2][y2] == 0;
    }
}