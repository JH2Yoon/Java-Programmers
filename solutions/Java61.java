// 61. 로또의 최고 순위와 최저 순위

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> lottoMap = new HashMap<>();
        
        int zeroCnt = 0;
        
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCnt++;
                continue;
            }
            lottoMap.put(lotto, true);
                
        }
        
        int sameCnt = 0;
        for (int win_num : win_nums) {
            if(lottoMap.containsKey(win_num))
                sameCnt++;
        }
        
        int maxRank = (7 - (sameCnt+zeroCnt) > 6) ? 6 : 7 - (sameCnt+zeroCnt);
        int minRank = ((7 - sameCnt) > 6) ? 6 : (7 - sameCnt);
        
        
        int[] answer = {maxRank, minRank};
        return answer;
        
    }
}