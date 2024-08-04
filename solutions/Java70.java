// 70. 바탕화면 정리

import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int top = Integer.MAX_VALUE;       
        int left = Integer.MAX_VALUE;        
        int bottom = Integer.MIN_VALUE;        
        int right = Integer.MIN_VALUE;
        
        for (int i=0; i<wallpaper.length; i++) {
            for (int j=0; j<wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    top = Math.min(i, top);
                    bottom = Math.max(i+1, bottom);
                    left = Math.min(j, left);
                    right=  Math.max(j+1, right);
                    
                }
            }
        }
        
        int[] answer = {top, left, bottom, right};
        
        return answer;
    }
}