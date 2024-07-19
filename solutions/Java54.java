// 54. 2016년

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"}; 
        int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 30};
        
        int days = 0;
        for (int i=0; i<a-1; i++) {
            days += day[i];
        }
        
        days += b-1;
        return week[days % 7];
    }
}