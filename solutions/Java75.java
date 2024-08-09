// 75. 최댓값과 최솟값

class Solution {
    public String solution(String s) {
        String answer =  minValue(s) + " " + maxValue(s);
        
        
        return answer;
    }
    
    public static String minValue(String a) {
        String str;
        
        String[] a_split = a.split(" ");
        int min = Integer.parseInt(a_split[0]);
                                
        for (int i=1; i<a_split.length; i++) {
            if (min > Integer.parseInt(a_split[i])) {
                min = Integer.parseInt(a_split[i]);
            }
        }
        
        return Integer.toString(min);
        
    }
    
    public static String maxValue(String a) {
        String str;
        
        String[] a_split = a.split(" ");
        int max = Integer.parseInt(a_split[0]);
                                
        for (int i=1; i<a_split.length; i++) {
            if (max < Integer.parseInt(a_split[i])) {
                max = Integer.parseInt(a_split[i]);
            }
        }
        
        return Integer.toString(max);
        
    }
}