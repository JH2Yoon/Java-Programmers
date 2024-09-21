// 118. 거리두기 확인하기


import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int idx = 0;
        
        for (String[] place : places) {
            boolean check = false;
            
            for (int i=0; i<5; i++) {
                for (int j=0; j<5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        if(bfs(i, j, place)) {
                            check = true;
                        }
                    }
                }
            }
            answer[idx++] = check ? 0 : 1;
        }
        return answer;
    }
    
    static boolean bfs(int x, int y, String[] p) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if ((nx < 0 || ny < 0 || nx >= 5 || ny >= 5) || (nx == x && ny == y)) {
                    continue;
                }

                int m = Math.abs(x - nx) + Math.abs(y - ny);

                if (p[nx].charAt(ny) == 'P' && m <= 2) {
                    return true;
                } else if (p[nx].charAt(ny) == 'O' && m < 2) {
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
    
    
}