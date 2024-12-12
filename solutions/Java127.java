// 127. 리코쳇 로봇

import java.util.*;

class Solution {
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        int startX = -1, startY = -1;
        int endX = -1, endY = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                }
                if (board[i].charAt(j) == 'G') {
                    endX = i;
                    endY = j;
                }
            }
        }

        return bfs(board, startX, startY, endX, endY);
    }

    private int bfs(String[] board, int startX, int startY, int endX, int endY) {
        int n = board.length;
        int m = board[0].length();

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});

        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }
        visited[startX][startY] = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moveCount = visited[x][y];

            if (x == endX && y == endY) {
                return moveCount;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x, ny = y;

                while (true) {
                    int tmpX = nx + dx[i];
                    int tmpY = ny + dy[i];

                    if (tmpX < 0 || tmpX >= n || tmpY < 0 || tmpY >= m || board[tmpX].charAt(tmpY) == 'D') {
                        break;
                    }

                    nx = tmpX;
                    ny = tmpY;
                }

                if (visited[nx][ny] == -1) {
                    visited[nx][ny] = moveCount + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }
}