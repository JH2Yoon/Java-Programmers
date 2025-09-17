//252. 보석 쇼핑

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemKinds = new HashSet<>(Arrays.asList(gems));
        int totalKinds = gemKinds.size();

        Map<String, Integer> countMap = new HashMap<>();
        int left = 0, right = 0;
        int bestLeft = 0, bestRight = gems.length - 1;
        int minLength = gems.length;

        while (true) {
            if (countMap.size() == totalKinds) {
                if (right - left < minLength) {
                    minLength = right - left;
                    bestLeft = left;
                    bestRight = right - 1;
                }
                String leftGem = gems[left];
                countMap.put(leftGem, countMap.get(leftGem) - 1);
                if (countMap.get(leftGem) == 0) {
                    countMap.remove(leftGem);
                }
                left++;
            } else if (right == gems.length) {
                break;
            } else {
                String rightGem = gems[right];
                countMap.put(rightGem, countMap.getOrDefault(rightGem, 0) + 1);
                right++;
            }
        }

        return new int[]{bestLeft + 1, bestRight + 1};
    }
}