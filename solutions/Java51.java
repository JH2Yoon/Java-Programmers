// 51. 푸드 파이트 대회

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for (int i=1; i<food.length; i++) {
            int foods = food[i]/2;
            for (int j=0; j<foods; j++) {
                answer += Integer.toString(i);
            }
        }
        
        answer += "0";
        
        for (int i=food.length-1; i>=1; i--) {
            int foods = food[i]/2;
            for (int j=0; j<foods; j++) {
                answer += Integer.toString(i);
            }
        }
        
        
        return answer;
    }
}