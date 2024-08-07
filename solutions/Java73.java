// 73. 공원 산책

import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int sx = 0;
        int sy = 0;
        
        char[][] arr = new char[park.length][park[0].length()];
        
        for (int i=0; i<park.length; i++) {
            arr[i] = park[i].toCharArray();
            
            if (park[i].contains("S")) {
                sy = i;
                sx = park[i].indexOf("S");
            }
        }
        
        for (String ro : routes) {
            String[] str = ro.split(" ");
            String way = str[0];
            int len = Integer.parseInt(str[1]);
            
            int nx = sx;
            int ny = sy;
            
            for (int i=0; i<len; i++) {
                if (way.contains("N")) {
                    ny--;
                } else if (way.contains("S")) {
                    ny++;
                } else if (way.contains("W")) {
                    nx--;
                } else if (way.contains("E")) {
                    nx++;
                }
            
                if (nx >=0 && ny >=0 && ny < arr.length && nx < arr[0].length) {
                    if (arr[ny][nx] == 'X')
                        break;
                    
                    if (i == len-1) {
                        sx = nx;
                        sy = ny;
                    }
                
                }
            }
            
        }
    
        int[] answer = {sy, sx};
        return answer;
    }
}