//282. 도넛과 막대 그래프

import java.util.*;

class Solution {

    public int[] solution(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indeg = new HashMap<>();
        Map<Integer, Integer> outdeg = new HashMap<>();

        for (int[] e : edges) {
            int a = e[0], b = e[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);

            outdeg.put(a, outdeg.getOrDefault(a, 0) + 1);
            indeg.put(b, indeg.getOrDefault(b, 0) + 1);

            indeg.putIfAbsent(a, indeg.getOrDefault(a, 0));
            outdeg.putIfAbsent(b, outdeg.getOrDefault(b, 0));
        }

        int generated = -1;
        for (int node : outdeg.keySet()) {
            if (outdeg.get(node) >= 2 && indeg.getOrDefault(node, 0) == 0) {
                generated = node;
                break;
            }
        }

        int donut = 0, stick = 0, eight = 0;

        for (int start : graph.get(generated)) {

            Set<Integer> visited = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited.add(start);

            int outTwoCount = 0;
            int endPointCount = 0;
            boolean hasCycle = false;

            while (!q.isEmpty()) {
                int cur = q.poll();

                int od = outdeg.getOrDefault(cur, 0);
                if (od == 2) outTwoCount++;
                if (od == 0) endPointCount++;

                if (graph.containsKey(cur)) {
                    for (int nxt : graph.get(cur)) {
                        if (!visited.add(nxt))
                            hasCycle = true;
                        else
                            q.add(nxt);
                    }
                }
            }

            if (outTwoCount >= 1) eight++;
            else if (endPointCount == 1) stick++;
            else donut++;
        }

        return new int[]{generated, donut, stick, eight};
    }
}