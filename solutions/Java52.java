// 52. 콜라 문제

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int empty_bottle = 0;
        int left_empty_bottle = 0;
        
        while (n>=a) {
            empty_bottle = (n/a) * b;
            n = n - ((n/a)*a) + empty_bottle;
            answer += empty_bottle;
        }
        
        return answer;
    }
}