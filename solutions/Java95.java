// 95. k진수에서 소수 개수 구하기

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] s = Integer.toString(n, k).split("0");
        
        for (String num : s) {
            if (num.length() < 1)
                continue;
            if (isPrime(Long.parseLong(num))) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(Long n) {
        if (n == 1) return false;
        
        long a = (long) Math.sqrt(n) + 1L;
        for(int i = 2; i < a; i++) {
            if(n % i == 0) return false;
        }
        
        return true;
    }
}