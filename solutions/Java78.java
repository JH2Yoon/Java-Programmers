// 78. 피보나치 수

class Solution {
    public int solution(int n) {
        int answer = 1;
        int cnt = 2;  
        int f1 =0, f2 = 1;
        
        while (cnt <= n) {
            answer = (f1 + f2) % 1234567;
            f1 = f2;
            f2 = answer;
            cnt++;
        }
        
        return answer;
    }
}