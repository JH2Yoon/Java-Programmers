// 69. 성격 유형 검사하기

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] category = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
            
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : category) {
            map.put(c, 0);
        }
        
        
        for (int i=0; i<survey.length; i++) {
            char[] c = survey[i].toCharArray();
            if (choices[i] > 4) {
                int currentValue = map.get(c[1]);
                map.put(c[1], currentValue + choices[i]-4);
            } else if (choices[i]<4) {
                int[] value = {0,3,2,1};
                int currentValue = map.get(c[0]);
                map.put(c[0], currentValue + value[choices[i]]);
            }
        }
        
        for (int i = 0; i<category.length; i+=2) {
            if (map.get(category[i]) > map.get(category[i+1])) {
                answer += category[i];
            } else if (map.get(category[i]) < map.get(category[i+1])) {
                answer += category[i+1];
            } else {
                answer += category[i];
            }
            
        }
        return answer;
    }
}