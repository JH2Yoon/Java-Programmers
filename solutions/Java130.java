//130. 두 원 사이의 정수 쌍

class Solution {
    public long solution(int r1, int r2) {
        long result = 0;
        for(int x = 1; x < r2; x++) {
            double inner = Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2));
            double outer = Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));

            long cnt = (long) outer - (long) inner;
            if(isInteger(inner)) cnt++;
            result += cnt * 4;
        }
        return result + (r2 - r1) * 4;
    }
    private boolean isInteger(double val) {
        return val == (long) val;
    }
}