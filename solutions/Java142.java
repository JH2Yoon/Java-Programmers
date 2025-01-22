// 142. 빛의 경로 사이클

import java.util.*;

class Solution {
    private static final int[] dr = {1, 0, -1, 0};
    private static final int[] dc = {0, -1, 0, 1};
    
    public int[] solution(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        
        boolean[][][] visited = new boolean[rows][cols][4];
        List<Integer> cycles = new ArrayList<>();
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int d = 0; d < 4; d++) {
                    if (!visited[r][c][d]) {
                        int cycleLength = light(grid, r, c, d, visited);
                        if (cycleLength > 0) {
                            cycles.add(cycleLength);
                        }
                    }
                }
            }
        }
        
        Collections.sort(cycles);
        
        int[] result = new int[cycles.size()];
        for (int i = 0; i < cycles.size(); i++) {
            result[i] = cycles.get(i);
        }
        return result;
    }

    private int light(String[] grid, int r, int c, int d, boolean[][][] visited) {
        int rows = grid.length;
        int cols = grid[0].length();
        int cycleLength = 0;
        
        int startR = r, startC = c, startD = d;
        
        while (!visited[r][c][d]) {
            visited[r][c][d] = true;
            cycleLength++;

            if (grid[r].charAt(c) == 'L') {
                d = (d + 3) % 4;
            } else if (grid[r].charAt(c) == 'R') {
                d = (d + 1) % 4;
            }
            
            r = (r + dr[d] + rows) % rows;
            c = (c + dc[d] + cols) % cols;

            if (r == startR && c == startC && d == startD) {
                return cycleLength;
            }
        }
        return 0;
    }
}
