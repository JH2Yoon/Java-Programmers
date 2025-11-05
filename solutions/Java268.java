//268. 경주로 건설

import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int INF = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4];
        for (int[][] arr : cost)
            for (int[] c : arr)
                Arrays.fill(c, INF);

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, -1, 0));
        for (int i = 0; i < 4; i++) cost[0][0][i] = 0;

        int answer = INF;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == n - 1 && cur.y == n - 1) {
                answer = Math.min(answer, cur.cost);
                continue;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) continue;

                int newCost = cur.cost + (cur.dir == -1 || cur.dir == dir ? 100 : 600);
                if (cost[nx][ny][dir] > newCost) {
                    cost[nx][ny][dir] = newCost;
                    q.offer(new Node(nx, ny, dir, newCost));
                }
            }
        }
        return answer;
    }

    static class Node {
        int x, y, dir, cost;
        Node(int x, int y, int dir, int cost) {
            this.x = x; this.y = y; this.dir = dir; this.cost = cost;
        }
    }
}