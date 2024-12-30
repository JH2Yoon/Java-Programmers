//139. 택배 배달과 수거하기

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int maxDelivery = n - 1;
        int maxPickup = n - 1;

        if (isAllZero(deliveries) && isAllZero(pickups)) {
            return 0;
        }

        while (maxDelivery >= 0 || maxPickup >= 0) {
            int distance = Math.max(maxDelivery, maxPickup) + 1;
            answer += 2 * distance;

            int deliveryLoad = cap;
            for (int i = maxDelivery; i >= 0; i--) {
                if (deliveries[i] > 0) {
                    if (deliveries[i] <= deliveryLoad) {
                        deliveryLoad -= deliveries[i];
                        deliveries[i] = 0;
                    } else {
                        deliveries[i] -= deliveryLoad;
                        break;
                    }
                }
            }

            int pickupLoad = cap;
            for (int i = maxPickup; i >= 0; i--) {
                if (pickups[i] > 0) {
                    if (pickups[i] <= pickupLoad) {
                        pickupLoad -= pickups[i];
                        pickups[i] = 0;
                    } else {
                        pickups[i] -= pickupLoad;
                        break;
                    }
                }
            }

            while (maxDelivery >= 0 && deliveries[maxDelivery] == 0) {
                maxDelivery--;
            }
            while (maxPickup >= 0 && pickups[maxPickup] == 0) {
                maxPickup--;
            }
        }

        return answer;
    }

    private boolean isAllZero(int[] array) {
        for (int value : array) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}