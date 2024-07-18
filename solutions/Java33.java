// 33. 약수의 개수와 덧셈

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i=left; i<=right; i++) {
            int sum = 0;
            for (int j=1; j<=i; j++) {
                if (i % j == 0) 
                    sum += 1;
            }
            
            answer += (sum%2==0) ? i : -i;
        }
        
        return answer;
    }
}
