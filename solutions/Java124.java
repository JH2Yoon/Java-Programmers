// 124. 미로 탈출

import java.util.*;

class Solution {
    static int rows;
    static int cols;

    public int solution(String[] maps) {
        int answer = 0;
        rows = maps.length;
        cols = maps[0].length();

        int[] start = new int[2];   // 시작 지점
        int[] lever = new int[2];   // 레버
        int[] end = new int[2];    // 출구


        for(int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                char ch = maps[i].charAt(j);

                if (ch == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (ch == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (ch == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        int a = bfs(maps, start, lever);
        int b = bfs(maps, lever, end);

        if (a != -1 && b != -1) {
            answer = a + b;
        } else {
            answer = -1;
        }

        return answer;
    }

    private int bfs(String[] maps, int[] start, int[] end) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];

            if (x == end[0] && y == end[1]) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, dist + 1});
                }
            }
        }

        return -1;
    }
}