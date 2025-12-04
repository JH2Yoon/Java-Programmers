//279. [PCCP 기출문제] 3번 / 충돌위험 찾기

import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int robotCount = routes.length;

        List<List<String>> robotPaths = new ArrayList<>();

        int maxTime = 0;

        for (int i = 0; i < robotCount; i++) {
            int[] route = routes[i];
            List<String> path = new ArrayList<>();

            int[] start = points[route[0] - 1];
            int cr = start[0];
            int cc = start[1];
            path.add(cr + "," + cc);

            for (int j = 1; j < route.length; j++) {
                int[] nextPoint = points[route[j] - 1];
                int nr = nextPoint[0];
                int nc = nextPoint[1];

                while (cr != nr) {
                    if (cr < nr) cr++;
                    else cr--;
                    path.add(cr + "," + cc);
                }

                while (cc != nc) {
                    if (cc < nc) cc++;
                    else cc--;
                    path.add(cr + "," + cc);
                }
            }

            robotPaths.add(path);
            maxTime = Math.max(maxTime, path.size());
        }

        Map<String, Integer>[] timeline = new HashMap[maxTime];
        for (int i = 0; i < maxTime; i++) {
            timeline[i] = new HashMap<>();
        }

        for (List<String> path : robotPaths) {
            for (int t = 0; t < path.size(); t++) {
                String pos = path.get(t);
                timeline[t].put(pos, timeline[t].getOrDefault(pos, 0) + 1);
            }
        }

        int danger = 0;
        for (int t = 0; t < maxTime; t++) {
            for (int count : timeline[t].values()) {
                if (count >= 2) danger++;
            }
        }

        return danger;
    }
}