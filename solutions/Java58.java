// 58. 소수 만들기

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    int sum = nums[i]+ nums[j] + nums[k];
                    int result = isPrime(sum);
                    
                    if (result == 1)
                        answer++;
                    
                }
            }
        }

        return answer;
    }
    
    public int isPrime(int n) {
        int answer = 1;
        
        for (int i=2; i<n; i++) {
            if (n % i == 0)
                answer++;
        }
        
        if (answer == 1)
            return 1;
        else {
            return 0;
        }
    }
}