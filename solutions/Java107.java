// 107. 큰 수 만들기

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int toRemove = k;
        
        for (char digit : number.toCharArray()) {
            while (!stack.isEmpty() && toRemove > 0 && stack.peek() < digit) {
                stack.pop();
                toRemove--;
            }
            stack.push(digit);
        }
        
        while (toRemove > 0) {
            stack.pop();
            toRemove--;
        }
        
        StringBuilder answer = new StringBuilder();
        for (char c : stack) {
            answer.append(c);
        }
        
        return answer.toString();
    }
}