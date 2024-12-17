//131. N-Queen

class Solution {
    static int count;

    public int solution(int n) {
        int[] board = new int[n];
        solve(board, 0, n);
        return count;
    }

    private void solve(int[] board, int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col=0; col<n; col++) {
            if(isSafe(board, row, col)) {
                board[row] = col;
                solve(board, row + 1, n);
                board[row] = 0;
            }
        }
    }

    private boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}