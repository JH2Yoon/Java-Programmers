//257. 숫자 블록

class Solution {
    public int[] solution(long begin, long end) {
        int size = (int)(end - begin + 1);
        int[] answer = new int[size];

        for (long i = begin; i <= end; i++) {
            answer[(int)(i - begin)] = getBlockNumber(i);
        }

        return answer;
    }

    private int getBlockNumber(long n) {
        if (n == 1) return 0;

        int maxDivisor = 1;
        long sqrt = (long)Math.sqrt(n);

        for (long d = 2; d <= sqrt; d++) {
            if (n % d == 0) {
                long pair = n / d;

                if (pair <= 10_000_000) {
                    return (int)pair;
                }
                if (d <= 10_000_000) {
                    maxDivisor = (int)d;
                }
            }
        }
        return maxDivisor;
    }
}