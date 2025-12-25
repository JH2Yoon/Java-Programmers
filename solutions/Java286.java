//286. 등산코스 정하기

import java.util.*;

class Solution {

    static class Node {
        int v, w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] p : paths) {
            graph[p[0]].add(new Node(p[1], p[2]));
            graph[p[1]].add(new Node(p[0], p[2]));
        }

        Set<Integer> gateSet = new HashSet<>();
        for (int g : gates) gateSet.add(g);

        Set<Integer> summitSet = new HashSet<>();
        for (int s : summits) summitSet.add(s);

        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.w - b.w
        );

        for (int g : gates) {
            intensity[g] = 0;
            pq.offer(new Node(g, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.w > intensity[cur.v]) continue;
            if (summitSet.contains(cur.v)) continue;

            for (Node next : graph[cur.v]) {

                if (gateSet.contains(next.v)) continue;

                int nextIntensity = Math.max(cur.w, next.w);

                if (intensity[next.v] > nextIntensity) {
                    intensity[next.v] = nextIntensity;
                    pq.offer(new Node(next.v, nextIntensity));
                }
            }
        }

        Arrays.sort(summits);

        int bestSummit = 0;
        int bestIntensity = Integer.MAX_VALUE;

        for (int s : summits) {
            if (intensity[s] < bestIntensity) {
                bestIntensity = intensity[s];
                bestSummit = s;
            }
        }

        return new int[]{bestSummit, bestIntensity};
    }
}