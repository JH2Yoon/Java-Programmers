//253. [PCCP 기출문제] 2번 / 퍼즐 게임 챌린지

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canSolve(mid, diffs, times, limit)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canSolve(int level, int[] diffs, int[] times, long limit) {
        long totalTime = 0;
        totalTime += times[0];

        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                totalTime += times[i];
            } else {
                int failCount = diffs[i] - level;
                totalTime += (long)(times[i] + times[i - 1]) * failCount + times[i];
            }
            if (totalTime > limit) return false;
        }

        return totalTime <= limit;
    }
}