//221. 지폐 접기

import java.util.Arrays;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        return foldBanknote(wallet, bill);
    }

    private int foldBanknote(int[] wallet, int[] bill) {
        Arrays.sort(wallet);
        int answer = 0;

        while (true) {
            Arrays.sort(bill);

            if (bill[0] <= wallet[0] && bill[1] <= wallet[1]) {
                break;
            }

            if (bill[1] >= bill[0]) {
                bill[1] /= 2;
            } else {
                bill[0] /= 2;
            }
            answer++;
        }
        return answer;
    }
}