// 83. 귤 고르기

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
         PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i=0; i<priorities.length; i++) {
            queue.offer(priorities[i]);
        }
        
        while (!queue.isEmpty()) 
        {
             for (int i=0; i<priorities.length; i++) 
             {
                 if (queue.peek() == priorities[i]) 
                 {
                     queue.poll();
                     answer++;
                     
                     if (location == i)
                         return answer;
                 }
             }
        }
        return answer;
    }
}