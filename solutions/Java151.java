// 151. 입국심사이분탐색

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) n * (long) times[0];
        
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long peopleProcessed = 0;
            for (int time : times) {
                peopleProcessed += mid / time;
            }
            
            if (peopleProcessed >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}
