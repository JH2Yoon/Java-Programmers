//220. Java Dequeue

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);

            int count = 0;
            if (map.containsKey(num)) {
                count = map.get(num);
            }
            map.put(num, count + 1);

            if (deque.size() > m) {
                int removed = deque.removeFirst();
                int removedCount = map.get(removed);
                if (removedCount == 1) {
                    map.remove(removed);
                } else {
                    map.put(removed, removedCount - 1);
                }
            }

            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, map.size());
            }
        }

        System.out.println(maxUnique);
    }
}