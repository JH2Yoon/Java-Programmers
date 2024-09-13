// 110. 두 큐 합 같게 만들기

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int n : queue1){
            q1.add(n);
            sum1 += n;
        }
        
        for(int n : queue2){
            q2.add(n);
            sum2 += n;
        }

        int cnt = 0;
        
        while (cnt <= queue1.length * 4) {
            if (sum1 > sum2) {
                int poll = q1.poll();
                sum1 -= poll;
                sum2 += poll;
                q2.add(poll);
            } else if (sum1 < sum2) {
                int poll = q2.poll();
                sum1 += poll;
                sum2 -= poll;
                q1.add(poll);
            } else if (sum1 == sum2) {
                answer = cnt;
                break;
            }
            cnt++;
        }
        
        return answer;
    }
}