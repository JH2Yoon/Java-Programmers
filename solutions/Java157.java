// 157. 부대복귀

import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[destination] = 0; 

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }

        return answer;
    }
}
