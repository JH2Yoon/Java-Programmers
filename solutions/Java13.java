// 13. 자릿수 더하기


import java.util.*;
class Solution {
    public int solution(int n) {
        
        int answer = 0;
        
        String str = Integer.toString(n);
        
        for (String a : str.split(""))
        {
            answer += Integer.parseInt(a);
        }

        return answer;
    }
}

import java.util.*;
class Solution {
    
    public int solution(int n) {
        
        int answer = 0;
        
        ArrayList<Integer> addSum = new ArrayList<>();
        
        while (n > 0)
        {
            addSum.add(n % 10);
            n /= 10;
        }
        
        for (Integer i : addSum)
        {
            answer += i;
        }
        return answer;
    }
}
