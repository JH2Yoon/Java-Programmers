// 159. 110 옮기기

import java.util.Stack;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            Stack<Character> stack = new Stack<>();
            int count110 = 0; 

            for (int j = 0; j < str.length(); j++) {
                stack.push(str.charAt(j));
                
                if (stack.size() >= 3 &&
                    stack.get(stack.size() - 1) == '0' &&
                    stack.get(stack.size() - 2) == '1' &&
                    stack.get(stack.size() - 3) == '1') {
                    stack.pop();  
                    stack.pop(); 
                    stack.pop();  
                    count110++;
                }
            }

            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.insert(0, stack.pop());
            }

            StringBuilder finalResult = new StringBuilder();
            if (result.indexOf("0") != -1) {
                int insertPos = result.lastIndexOf("0") + 1;
                finalResult.append(result.substring(0, insertPos));
                for (int j = 0; j < count110; j++) {
                    finalResult.append("110");
                }
                finalResult.append(result.substring(insertPos));
            } else {
                for (int j = 0; j < count110; j++) {
                    finalResult.append("110");
                }
                finalResult.append(result);
            }

            answer[i] = finalResult.toString();
        }
        
        return answer;
    }
}
