//260. 순위 검색

import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String s : info) {
            String[] parts = s.split(" ");
            int score = Integer.parseInt(parts[4]);
            makeCombination(parts, 0, "", score);
        }

        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replaceAll(" and ", " ");
            String[] parts = q.split(" ");
            String key = parts[0] + parts[1] + parts[2] + parts[3];
            int score = Integer.parseInt(parts[4]);

            if (map.containsKey(key)) {
                List<Integer> list = map.get(key);
                int idx = lowerBound(list, score);
                answer[i] = list.size() - idx;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    private void makeCombination(String[] parts, int depth, String key, int score) {
        if (depth == 4) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }

        makeCombination(parts, depth + 1, key + parts[depth], score);
        makeCombination(parts, depth + 1, key + "-", score);
    }

    private int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}