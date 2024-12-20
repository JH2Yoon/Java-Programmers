//134. 혼자서 하는 틱택토

public class Solution {
    public int solution(String[] board) {
        int oCount = 0, xCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') {
                    oCount++;
                } else if (board[i].charAt(j) == 'X') {
                    xCount++;
                }
            }
        }

        if (oCount != xCount && oCount != xCount + 1) {
            return 0;
        }

        boolean oWon = false;
        boolean xWon = false;

        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                if (board[i].charAt(0) == 'O') oWon = true;
                if (board[i].charAt(0) == 'X') xWon = true;
            }
            if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
                if (board[0].charAt(i) == 'O') oWon = true;
                if (board[0].charAt(i) == 'X') xWon = true;
            }
        }

        if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
            if (board[0].charAt(0) == 'O') oWon = true;
            if (board[0].charAt(0) == 'X') xWon = true;
        }
        if (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) {
            if (board[0].charAt(2) == 'O') oWon = true;
            if (board[0].charAt(2) == 'X') xWon = true;
        }

        if (oWon && xWon) {
            return 0;
        }
        if (oWon && oCount != xCount + 1) {
            return 0;
        }
        if (xWon && oCount != xCount) {
            return 0;
        }

        return 1;
    }
}
