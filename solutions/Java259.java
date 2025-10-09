//259. 파괴되지 않은 건물

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n + 1][m + 1];

        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];

            int value = (type == 1 ? -degree : degree);

            diff[r1][c1] += value;
            diff[r1][c2 + 1] -= value;
            diff[r2 + 1][c1] -= value;
            diff[r2 + 1][c2 + 1] += value;
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        for (int j = 0; j < m + 1; j++) {
            for (int i = 1; i < n + 1; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }


        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + diff[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}