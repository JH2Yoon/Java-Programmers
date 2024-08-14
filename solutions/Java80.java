// 80. 예상 대진표

import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        List<Integer> rounds = new ArrayList<>();
        
        for (int i=1; i<=n; i++) {
            rounds.add(i);
        }
        
       while(true) {
           
           int indexA = rounds.indexOf(a);
           int indexB = rounds.indexOf(b);
           
           if (Math.abs(indexA - indexB) == 1 && Math.min(indexA, indexB) % 2 == 0) {
                break;
            }
           
           List<Integer> nextRound = new ArrayList<>();
           for (int i=0; i<rounds.size(); i+=2) {
               int first = rounds.get(i);
               int second = rounds.get(i + 1);
               
               if (first == a || first == b) {
                   nextRound.add(first);
               } else {
                   nextRound.add(second);
               }
               
           }
           
           rounds = nextRound;
           answer++;
       }
        return answer;
    }
}