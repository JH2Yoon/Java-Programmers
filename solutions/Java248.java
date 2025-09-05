//248. 최고의 집합

import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};

        int base = s / n;
        int remainder = s % n;

        int[] answer = new int[n];
        Arrays.fill(answer, base);

        for (int i = 0; i < remainder; i++) {
            answer[i] += 1;
        }

        Arrays.sort(answer);
        return answer;
    }
}