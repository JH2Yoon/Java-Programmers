// 143. 이중우선순위큐

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] op = operation.split(" ");
            String command = op[0];
            int number = Integer.parseInt(op[1]);

            if (command.equals("I")) {
                minHeap.offer(number);
                maxHeap.offer(number);
            } else if (command.equals("D")) {
                if (number == 1) {
                    if (!maxHeap.isEmpty()) {
                        int maxVal = maxHeap.poll();
                        minHeap.remove(maxVal);
                    }
                } else if (number == -1) {
                    if (!minHeap.isEmpty()) {
                        int minVal = minHeap.poll();
                        maxHeap.remove(minVal);
                    }
                }
            }
        }

        if (minHeap.isEmpty()) {
            return new int[] {0, 0};
        } else {
            int max = maxHeap.peek();
            int min = minHeap.peek();
            return new int[] {max, min};
        }
    }
}