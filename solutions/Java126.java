// 126. 광물 캐기

import java.util.*;

class Solution {
    private static final Map<String, Integer> mineralMap = Map.of(
            "diamond", 0,
            "iron", 1,
            "stone", 2
    );
    private static final int[][] cost = {
            {1, 1, 1},   // 다이아몬드 곡괭이
            {5, 1, 1},   // 철 곡괭이
            {25, 5, 1}   // 돌 곡괭이
    };

    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        int minFatigue = Integer.MAX_VALUE;

        minFatigue = dfs(picks, minerals, 0, 0, minFatigue);

        return minFatigue;
    }

    private int dfs(int[] picks, String[] minerals, int index, int fatigue, int minFatigue) {
        if (index >= minerals.length || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)) {
            return Math.min(fatigue, minFatigue);
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;

                int currentFatigue = fatigue;
                for (int j = 0; j < 5; j++) {
                    if (index + j < minerals.length) {
                        currentFatigue += cost[i][mineralMap.get(minerals[index + j])];
                    }
                }

                minFatigue = dfs(picks, minerals, index + 5, currentFatigue, minFatigue);

                picks[i]++;
            }
        }

        return minFatigue;
    }
}

