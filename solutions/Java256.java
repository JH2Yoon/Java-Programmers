//256. 카카오프렌즈 컬러링북

import java.util.*;

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    int size = bfs(i,j,picture,visited,m,n);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                    numberOfArea++;
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int bfs(int x, int y, int[][] picture, boolean[][] visited, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        int color = picture[x][y];
        int size = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            for (int d=0;d<4;d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx>=0 && nx<m && ny>=0 && ny<n
                        && !visited[nx][ny] && picture[nx][ny]==color) {
                    visited[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                    size++;
                }
            }
        }
        return size;
    }
}