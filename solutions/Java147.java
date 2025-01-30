// 147. 가장 먼 노드

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1); 
        distance[1] = 0;

        queue.add(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        int maxDistance = 0;
        for (int dist : distance) {
            if (dist > maxDistance) {
                maxDistance = dist;
            }
        }

        int count = 0;
        for (int dist : distance) {
            if (dist == maxDistance) {
                count++;
            }
        }

        return count;
    }
}
