// 67. 둘만의 암호


import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            for (int j=0; j<index; j++) {
                ch += 1;
                if (ch > 'z') {
                    ch = 'a';
                }
                if (skip.contains(Character.toString(ch))) {
                    j--;
                }
            }
            answer += ch;
        }
        
        return answer;
    }
}