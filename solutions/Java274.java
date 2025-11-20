//274. 기지국 설치

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2 * w + 1;
        int pos = 1;

        for (int station : stations) {
            int left = station - w;
            int right = station + w;

            if (pos < left) {
                int gap = left - pos;
                answer += (gap + range - 1) / range;
            }

            pos = right + 1;
        }

        if (pos <= n) {
            int gap = n - pos + 1;
            answer += (gap + range - 1) / range;
        }

        return answer;
    }
}