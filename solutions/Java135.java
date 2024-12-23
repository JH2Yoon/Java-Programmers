//135. 이모티콘 할인행사

import java.util.*;

class Solution {
    static int[] discounts = {10, 20, 30, 40};

    int maxSubscribers = 0;
    int maxRevenue = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        int m = emoticons.length;
        int[] discountCombination = new int[m];

        findMaxSubscribersAndRevenue(0, discountCombination, users, emoticons);

        return new int[] {maxSubscribers, maxRevenue};
    }

    private void findMaxSubscribersAndRevenue(int idx, int[] discountCombination, int[][] users, int[] emoticons) {
        if (idx == emoticons.length) {
            int[] result = calculateSubscribersAndRevenue(users, emoticons, discountCombination);
            int subscribers = result[0];
            int revenue = result[1];

            if (subscribers > maxSubscribers || (subscribers == maxSubscribers && revenue > maxRevenue)) {
                maxSubscribers = subscribers;
                maxRevenue = revenue;
            }
            return;
        }

        for (int discount : discounts) {
            discountCombination[idx] = discount;
            findMaxSubscribersAndRevenue(idx + 1, discountCombination, users, emoticons);
        }
    }

    private int[] calculateSubscribersAndRevenue(int[][] users, int[] emoticons, int[] discountCombination) {
        int totalRevenue = 0;
        int totalSubscribers = 0;

        for (int[] user : users) {
            int minDiscount = user[0];
            int budget = user[1];
            int totalCost = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discountCombination[i] >= minDiscount) {
                    totalCost += emoticons[i] * (100 - discountCombination[i]) / 100;
                }
            }

            if (totalCost >= budget) {
                totalSubscribers++;
            } else {
                totalRevenue += totalCost;
            }
        }

        return new int[] {totalSubscribers, totalRevenue};
    }
}
