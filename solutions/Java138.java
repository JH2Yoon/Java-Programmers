//138. 교점에 별 만들기

import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        Set<Point> points = new HashSet<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long a1 = line[i][0], b1 = line[i][1], c1 = line[i][2];
                long a2 = line[j][0], b2 = line[j][1], c2 = line[j][2];
                long den = a1 * b2 - a2 * b1;

                if (den != 0) {
                    long x = b1 * c2 - b2 * c1, y = a2 * c1 - a1 * c2;
                    if (x % den == 0 && y % den == 0)
                        points.add(new Point(x / den, y / den));
                }
            }
        }

        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE, minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        for (Point p : points) {
            minX = Math.min(minX, p.x); maxX = Math.max(maxX, p.x);
            minY = Math.min(minY, p.y); maxY = Math.max(maxY, p.y);
        }

        int width = (int) (maxX - minX + 1), height = (int) (maxY - minY + 1);
        char[][] grid = new char[height][width];
        for (char[] row : grid) java.util.Arrays.fill(row, '.');

        for (Point p : points) {
            grid[(int)(maxY - p.y)][(int)(p.x - minX)] = '*';
        }

        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(grid[i]);
        }
        return answer;
    }

    static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
    }
}
