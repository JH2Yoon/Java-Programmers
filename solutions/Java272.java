//272. 숫자 게임

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;
        int score = 0;

        while (i < A.length && j < B.length) {
            if (B[j] > A[i]) {
                score++;
                i++;
                j++;
            } else j++;
        }

        return score;
    }
}