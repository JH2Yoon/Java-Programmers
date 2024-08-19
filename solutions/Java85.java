// 85. 연속 부분 수열 합의 개수

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i=0; i<2; i++) {
            for(int element : elements) {
                list.add(element);
            }   
        }
        
        for (int i=0; i<elements.length; i++) {
            for (int j=1; j<=elements.length; j++) {
                List<Integer> subList = list.subList(i, i+j);
                int sum =0;
                for (int n : subList)
                    sum += n;
                set.add(sum);
            }
        }
        
        int answer = set.size();
        return answer;
    }
}