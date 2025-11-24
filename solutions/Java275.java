//275. 무지의 먹방 라이브

import java.util.*;

class Solution {

    static class Food {
        int time;
        int index;

        Food(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }

    public int solution(int[] food_times, long k) {
        long total = 0;
        for (int t : food_times) total += t;

        if (total <= k) return -1;

        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < food_times.length; i++) {
            foods.add(new Food(food_times[i], i + 1));
        }

        foods.sort((a, b) -> a.time - b.time);

        long previous = 0;
        int idx = 0;
        int remainCount = foods.size();

        while (idx < foods.size()) {
            long current = foods.get(idx).time;
            long diff = current - previous;

            if (diff > 0) {
                long cost = diff * remainCount;

                if (k < cost) break;

                k -= cost;
                previous = current;
            }

            idx++;
            remainCount--;
        }

        List<Food> remainFoods = foods.subList(idx, foods.size());
        remainFoods.sort((a, b) -> a.index - b.index);

        return remainFoods.get((int) (k % remainCount)).index;
    }
}