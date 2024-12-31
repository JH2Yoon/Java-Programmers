//140. 유사 칸토어 비트열

class Solution {
    public int solution(int n, long l, long r) {
        return (int)(getOnesCount(n, r) - getOnesCount(n, l - 1));
    }

    private long getOnesCount(int n, long k) {
        if (n == 0) {
            return 1;
        }

        long divisor = (long) Math.pow(5, n - 1);
        long onesInPrevious = (long) Math.pow(4, n - 1);

        long zone = k / divisor;

        if (k % divisor == 0) {
            zone--;
        }

        if (zone == 2) {
            return onesInPrevious * zone;
        } else if (zone < 2) {
            return onesInPrevious * zone + getOnesCount(n - 1, k - (divisor * zone));
        } else {
            return onesInPrevious * (zone - 1) + getOnesCount(n - 1, k - (divisor * zone));
        }
    }
}
