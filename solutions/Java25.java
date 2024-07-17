// 25. 나누어 떨어지는 숫자

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> intList = new ArrayList<>();
        
        for (int element : arr) {
            if (element % divisor == 0)
                intList.add(element);
        }
        
       Collections.sort(intList);
        int[] answer = {};

        
        if (intList.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[intList.size()];
            for (int i=0; i<intList.size(); i++) {
                answer[i] = intList.get(i);
            }
               
        }
                
        return answer;
    }
}