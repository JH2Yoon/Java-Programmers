// 39. 최대공약수와 최소공배수

class Solution {
    int gcd(int n, int m) {
        int r;
        while (m > 0) {
            r = n%m;
            n = m;
            m = r;
        }
        
        return n;
    }
    
    public int[] solution(int n, int m) {
        
        int GCD = gcd(n, m);
        int LCM = (n*m)/GCD;
        int[] answer = {GCD, LCM};
        
        return answer;
    }
    
}
