// 17. 자연수 뒤집어 배열로 만들기

class Solution {
    public int[] solution(long n) {
        String[] str = Long.toString(n).split("");
        
        int[] answer = new int[str.length];
        
        for (int i = str.length - 1, j = 0; i >= 0; i--, j++) {
            answer[j] = Integer.parseInt(str[i]);
        }
        
        return answer;
    }
}

import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        String s = "" + n;
        int[] answer = new int[s.length()];
        
        int cnt=0;
        while (n > 0) {
            answer[cnt++] = (int)(n%10);
            n /= 10;
        }
        
        return answer;
    }
}
