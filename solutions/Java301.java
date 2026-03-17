//301. n + 1 카드게임

import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {

        int n = cards.length;
        int target = n + 1;

        Set<Integer> hand = new HashSet<>();
        Set<Integer> pool = new HashSet<>();

        int idx = n / 3;

        for (int i = 0; i < idx; i++) {
            hand.add(cards[i]);
        }

        int round = 1;

        while (true) {

            if (idx >= n) break;

            pool.add(cards[idx++]);
            pool.add(cards[idx++]);

            boolean progressed = false;

            for (int a : hand) {
                int b = target - a;
                if (hand.contains(b) && a != b) {
                    hand.remove(a);
                    hand.remove(b);
                    progressed = true;
                    break;
                }
            }

            if (progressed) {
                round++;
                continue;
            }

            if (coin >= 1) {
                for (int a : hand) {
                    int b = target - a;
                    if (pool.contains(b)) {
                        coin--;
                        hand.remove(a);
                        pool.remove(b);
                        progressed = true;
                        break;
                    }
                }
            }

            if (progressed) {
                round++;
                continue;
            }

            if (coin >= 2) {
                for (int a : pool) {
                    int b = target - a;
                    if (pool.contains(b) && a != b) {
                        coin -= 2;
                        pool.remove(a);
                        pool.remove(b);
                        progressed = true;
                        break;
                    }
                }
            }

            if (progressed) {
                round++;
                continue;
            }

            break;
        }

        return round;
    }
}