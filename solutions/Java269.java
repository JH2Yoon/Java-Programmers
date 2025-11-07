//269. 징검다리 건너기

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1, right = 200_000_000, answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else right = mid - 1;
        }

        return answer;
    }

    private boolean canCross(int[] stones, int k, int friends) {
        int skip = 0;
        for (int stone : stones) {
            if (stone - friends < 0) skip++;
            else skip = 0;
            if (skip >= k) return false;
        }
        return true;
    }
}