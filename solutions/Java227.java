//227. 크레인 인형뽑기 게임

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            int col = move - 1;

            for (int row = 0; row < board.length; row++) {
                int doll = board[row][col];
                if (doll != 0) {
                    board[row][col] = 0;
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(doll);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}