// 65. 문자열 나누기

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        
        int xCnt= 0;
        int otherCnt = 1;
        
        char x = s.charAt(0);
        
        
        for (int i=1; i<s.length(); i++) {
            
            if (x == ' ') {
                x= s.charAt(i);
                continue;
            }
            
            if (s.charAt(i)==x)
                otherCnt++;
            else
                xCnt++;
            
            if (otherCnt == xCnt) {
                answer++;
                x=' ';
                otherCnt = 1;
                xCnt=0;
            }
        }
        
        if (x != ' ')
            answer++;
        
        return answer;
    }
}