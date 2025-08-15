//241. [1차] 프렌즈4블록

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) map[i] = board[i].toCharArray();
        int answer = 0;

        while (true) {
            boolean[][] del = new boolean[m][n];
            boolean found = false;

            for (int i = 0; i < m - 1; i++)
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];
                    if (c != ' ' && c == map[i][j+1] && c == map[i+1][j] && c == map[i+1][j+1]) {
                        del[i][j] = del[i][j+1] = del[i+1][j] = del[i+1][j+1] = true;
                        found = true;
                    }
                }

            if (!found) break;

            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (del[i][j]) { map[i][j] = ' '; answer++; }

            for (int j = 0; j < n; j++) {
                int k = m - 1;
                for (int i = m - 1; i >= 0; i--)
                    if (map[i][j] != ' ') map[k--][j] = map[i][j];
                for (int i = k; i >= 0; i--) map[i][j] = ' ';
            }
        }
        return answer;
    }
}
