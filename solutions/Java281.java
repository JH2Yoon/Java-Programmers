//281. 기둥과 보 설치

import java.util.*;

class Solution {

    public int[][] solution(int n, int[][] build_frame) {
        boolean[][][] map = new boolean[n + 1][n + 1][2];

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];
            int b = frame[3];

            if (b == 1) {
                map[x][y][a] = true;
                if (!isValid(map, n)) {
                    map[x][y][a] = false;
                }
            } else {
                map[x][y][a] = false;
                if (!isValid(map, n)) {
                    map[x][y][a] = true;
                }
            }
        }

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int a = 0; a < 2; a++) {
                    if (map[i][j][a]) {
                        result.add(new int[]{i, j, a});
                    }
                }
            }
        }

        result.sort((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[2] - o2[2];
        });

        return result.toArray(new int[result.size()][]);
    }

    private boolean isValid(boolean[][][] map, int n) {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {

                if (map[x][y][0]) {
                    if (!checkPillar(map, x, y)) return false;
                }

                if (map[x][y][1]) {
                    if (!checkBeam(map, x, y)) return false;
                }
            }
        }
        return true;
    }

    private boolean checkPillar(boolean[][][] map, int x, int y) {
        if (y == 0) return true;

        if (y > 0 && map[x][y - 1][0]) return true;

        if (x > 0 && map[x - 1][y][1]) return true;

        if (map[x][y][1]) return true;

        return false;
    }

    private boolean checkBeam(boolean[][][] map, int x, int y) {
        if (y > 0 && map[x][y - 1][0]) return true;

        if (y > 0 && map[x + 1][y - 1][0]) return true;

        if (x > 0 && map[x - 1][y][1] && map[x + 1][y][1]) return true;

        return false;
    }
}