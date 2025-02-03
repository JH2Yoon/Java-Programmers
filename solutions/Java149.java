// 149. 여행경로

import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).offer(ticket[1]);
        }
        
        List<String> route = new ArrayList<>();
        
        dfs("ICN", graph, route);
        
        Collections.reverse(route);
        return route.toArray(new String[0]);
    }
    
    private void dfs(String start, Map<String, PriorityQueue<String>> graph, List<String> route) {
        while (graph.containsKey(start) && !graph.get(start).isEmpty()) {
            String nextStop = graph.get(start).poll();
            dfs(nextStop, graph, route);
        }
        
        route.add(start);
    }
}

