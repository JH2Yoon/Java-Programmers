// 125. 혼자 놀기의 달인

import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> groupSizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int groupSize = 0;
                int current = i;

                while (!visited[current]) {
                    visited[current] = true;
                    current = cards[current] - 1;
                    groupSize++;
                }

                groupSizes.add(groupSize);
            }
        }

        if (groupSizes.size() == 1) {
            return 0;
        }

        Collections.sort(groupSizes, Collections.reverseOrder());
        return groupSizes.get(0) * groupSizes.get(1);
    }
}