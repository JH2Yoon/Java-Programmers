// 28. 없는 숫자 더하기

import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
        
        List<Integer> list = new ArrayList<>();
        
        for (int j : numbers)
        {
            list.add(j);
        }
        for (int i=0; i<10; i++)
        {
            if(!(list.contains(i)))
                answer += i;
        }
        return answer;
    }
}