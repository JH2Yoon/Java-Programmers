// 150. 디스크 컨트롤러

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        
        int currentTime = 0;
        int totalTime = 0; 
        int jobIndex = 0;
        int jobCount = jobs.length;
        
        while (jobIndex < jobCount || !pq.isEmpty()) {
            while (jobIndex < jobCount && jobs[jobIndex][0] <= currentTime) {
                pq.offer(jobs[jobIndex]);
                jobIndex++;
            }
            
            if (!pq.isEmpty()) {
                int[] currentJob = pq.poll();
                int requestTime = currentJob[0];
                int jobTime = currentJob[1];
                
                currentTime += jobTime;
                totalTime += (currentTime - requestTime);
            } else {
                currentTime++;
            }
        }
        
        answer = totalTime / jobCount;
        return answer;
    }
}
