// 144. 네트워크

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        // DFS 탐색
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}
