// 41. 이상한 문자 만들기

import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int idx = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                answer += ch;
                idx=0;
            }
            else {
                if (idx % 2 == 0) {
                    answer += Character.toUpperCase(ch);
                } else {
                    answer += Character.toLowerCase(ch);
                }
                idx++;
            }
        }
        
        return answer;
    }
}