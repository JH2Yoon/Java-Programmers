// 53. 명예의 전당 (1)


import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];       // 발표 점수
        List<Integer> k_score = new ArrayList<>();  // 명예의 전당
        
        for (int i=0; i<score.length; i++)
        {       
            if (k_score.size() < k)
            {
                k_score.add(score[i]);
            }
            else
            {
                if (k_score.get(0) < score[i])
                {
                    k_score.set(0, score[i]);
                }
            }
            Collections.sort(k_score);
            answer[i] = k_score.get(0);
        }
        
        
        return answer;
    }
}