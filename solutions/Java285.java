//285. 외벽 점검

import java.util.*;

class Solution {

    public int solution(int n, int[] weak, int[] dist) {
        int wLen = weak.length;

        int[] extended = new int[wLen * 2];
        for (int i = 0; i < wLen; i++) {
            extended[i] = weak[i];
            extended[i + wLen] = weak[i] + n;
        }

        Arrays.sort(dist);

        for (int cnt = 1; cnt <= dist.length; cnt++) {
            if (canCheck(cnt, dist, extended, wLen)) {
                return cnt;
            }
        }

        return -1;
    }

    private boolean canCheck(int cnt, int[] dist, int[] extended, int wLen) {
        boolean[] used = new boolean[dist.length];
        return dfs(0, cnt, new int[cnt], used, dist, extended, wLen);
    }

    private boolean dfs(int depth, int cnt, int[] order, boolean[] used,
                        int[] dist, int[] extended, int wLen) {

        if (depth == cnt) {
            for (int start = 0; start < wLen; start++) {
                int idx = 0;
                int cover = extended[start] + order[idx];

                for (int i = start; i < start + wLen; i++) {
                    if (extended[i] > cover) {
                        idx++;
                        if (idx >= cnt) break;
                        cover = extended[i] + order[idx];
                    }
                }

                if (idx < cnt) return true;
            }
            return false;
        }

        for (int i = dist.length - 1; i >= 0; i--) {
            if (!used[i]) {
                used[i] = true;
                order[depth] = dist[i];
                if (dfs(depth + 1, cnt, order, used, dist, extended, wLen)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}