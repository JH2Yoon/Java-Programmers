//258. 아이템 줍기

import java.util.*;

class Solution {

    private static final int SIZE = 101;
    private static final int[][] map = new int[SIZE][SIZE];
    private static final boolean[][] visited = new boolean[SIZE][SIZE];
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        drawRectangles(rectangle);

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    private void drawRectangles(int[][] rectangles) {
        for (int[] rect : rectangles) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    boolean isBorder = (x == x1 || x == x2 || y == y1 || y == y2);
                    if (isBorder) {
                        if (map[x][y] != 2) map[x][y] = 1;
                    } else {
                        map[x][y] = 2;
                    }
                }
            }
        }
    }

    private int bfs(int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == targetX && y == targetY) return dist;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return 0;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < SIZE && y < SIZE;
    }
}
