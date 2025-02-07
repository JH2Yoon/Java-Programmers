// 153. 연속 펄스 부분 수열의 합

class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        
        long[] pulse1 = new long[n];
        long[] pulse2 = new long[n];
        
        for (int i = 0; i < n; i++) {
            pulse1[i] = (i % 2 == 0) ? 1 : -1;
            pulse2[i] = (i % 2 == 0) ? -1 : 1;
        }
        
        long[] seq1 = new long[n];
        long[] seq2 = new long[n];
        for (int i = 0; i < n; i++) {
            seq1[i] = sequence[i] * pulse1[i];
            seq2[i] = sequence[i] * pulse2[i];
        }

        long maxSum1 = getMaxSubArraySum(seq1);
        long maxSum2 = getMaxSubArraySum(seq2);

        return Math.max(maxSum1, maxSum2);
    }
    
    private long getMaxSubArraySum(long[] arr) {
        long maxSum = arr[0];
        long currentSum = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
