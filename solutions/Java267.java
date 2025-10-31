//267. 자물쇠와 열쇠

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length, n = lock.length;
        int size = n * 3;
        int[][] board = new int[size][size];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i + n][j + n] = lock[i][j];

        for (int r = 0; r < 4; r++) {
            key = rotate(key);
            for (int x = 0; x <= size - m; x++) {
                for (int y = 0; y <= size - m; y++) {
                    add(board, key, x, y, 1);
                    if (isUnlocked(board, n)) return true;
                    add(board, key, x, y, -1);
                }
            }
        }
        return false;
    }

    private int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] res = new int[m][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                res[j][m - 1 - i] = key[i][j];
        return res;
    }

    private void add(int[][] board, int[][] key, int x, int y, int delta) {
        int m = key.length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                board[x + i][y + j] += key[i][j] * delta;
    }

    private boolean isUnlocked(int[][] board, int n) {
        for (int i = n; i < n * 2; i++)
            for (int j = n; j < n * 2; j++)
                if (board[i][j] != 1) return false;
        return true;
    }
}