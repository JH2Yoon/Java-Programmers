// 64. 체육복

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reverSet = new HashSet<>();
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int value : reserve) {
            reverSet.add(value);
        }
        
        for (int value : lost) {
            if (reverSet.contains(value))
                reverSet.remove(value);
            else
                lostSet.add(value);
        }
        
        for (int i : lost) {
            if (lostSet.contains(i)) {
                if (reverSet.contains(i-1))
                    reverSet.remove(i-1);
                else if (reverSet.contains(i+1))
                    reverSet.remove(i+1);
                else
                    answer--;
            }
        }
        
        
        return answer;
    }
}