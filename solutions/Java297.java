//297. 쿠키 구입

class Solution {
    public int solution(int[] cookie) {
        int N = cookie.length;
        int answer = 0;

        for (int m = 0; m < N - 1; m++) {
            int left = m;
            int right = m + 1;

            int sumL = cookie[left];
            int sumR = cookie[right];

            while (true) {
                if (sumL == sumR) {
                    answer = Math.max(answer, sumL);
                }

                if (sumL <= sumR) {
                    left--;
                    if (left < 0) break;
                    sumL += cookie[left];
                } else {
                    right++;
                    if (right >= N) break;
                    sumR += cookie[right];
                }
            }
        }
        return answer;
    }
}