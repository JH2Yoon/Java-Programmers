// 155. 다단계 칫솔 판매

import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] profit = new int[n];

        HashMap<String, Integer> nameToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nameToIndex.put(enroll[i], i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int amountSold = amount[i];
            int index = nameToIndex.get(name);
            
            distributeProfit(index, amountSold * 100, referral, profit, nameToIndex);
        }
        
        return profit;
    }

    private void distributeProfit(int index, int money, String[] referral, int[] profit, HashMap<String, Integer> nameToIndex) {
        if (money < 10) {
            profit[index] += money;
            return;
        }
        
        int selfProfit = money - (money / 10);
        profit[index] += selfProfit;
        
        String referrer = referral[index];
        
        if (referrer.equals("-")) {
            return;
        }
        
        int referrerIndex = nameToIndex.get(referrer);
        distributeProfit(referrerIndex, money / 10, referral, profit, nameToIndex);
    }
}