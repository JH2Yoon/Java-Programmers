//246. 단속카메라

import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int cameras = 0;
        int camera = -30001;

        for (int[] route : routes) {
            int entry = route[0];
            int exit = route[1];

            if (entry > camera) {
                cameras++;
                camera = exit;
            }
        }

        return cameras;
    }
}