// 158. 인사고과

import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int attitude = scores[0][0];
        int evaluation = scores[0][1];
        int totalScore = attitude + evaluation;
        
        Arrays.sort(scores, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
        
        int highestEvaluation = 0;
        int rank = 1;
        
        for (int[] score : scores) {
            if (attitude < score[0] && evaluation < score[1]) {
                return -1;
            }
            
            if (highestEvaluation <= score[1]) {
                highestEvaluation = score[1];
                if (score[0] + score[1] > totalScore) {
                    rank++;
                }
            }
        }
        
        return rank;
    }
}
