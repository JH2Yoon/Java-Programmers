// 84. 괄호 회전하기

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        
        for (int i=0; i<length; i++) {
            String str = leftShift(s, i);
            
            if(isValidPatterns(str)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static String leftShift(String str, int shiftCount) {
        int length = str.length();
       
        return str.substring(shiftCount) + str.substring(0, shiftCount);
    }
    
    public static boolean isValidPatterns(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            switch(ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                default:
                    return false;
            }
        }
        
        return stack.isEmpty();
    }
    
}