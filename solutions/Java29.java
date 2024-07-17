// 29. 제일 작은 수 제거하기

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
    
        List<Integer> list = new ArrayList<>();
        
        int min = arr[0];
        
        if (arr.length == 1)
        {
            list.add(-1);
        }
        else
        {
            for (int i=1; i<arr.length; i++)
            {
                if (min > arr[i])
                {
                    min = arr[i];
                }
            }
            
            for (int j=0; j<arr.length; j++)
            {
                if (arr[j] != min)
                {
                    list.add(arr[j]);
                }
            }
        }
    
        int[] answer = new int[list.size()];
        
        for (int i=0; i<list.size(); i++)
        {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}