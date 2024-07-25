// 60. 기사단원의 무기

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] knights = new int[number+1];
        
        for (int i=1; i<=number; i++) {
            for (int j=1; j<=number/i; j++) {
                    knights[i*j]++;
            }
        }
        
        
        for (int i=1; i<=number; i++) {
            if (knights[i] > limit)
                answer += power;
            else
                answer += knights[i];
        }
        
        return answer;
    }
    
}