// 87. n^2 배열 자르기

import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);
        int[] answer = new int[size];
        
        int idx=0;
        for (long i=left; i<right+1; i++) {
            
            answer[idx++] = (int)(Math.max(i/n,i%n) + 1);
        }
        return answer;
    }
}