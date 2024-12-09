// 123. 하노이의 탑

import java.util.*;

class Solution {
    public int[][] solution(int n) {
        ArrayList<int[]> moves = new ArrayList<>();
        hanoi(n, 1, 3, 2, moves);

        int[][] answer = new int[moves.size()][2];
        for (int i = 0; i < moves.size(); i++) {
            answer[i] = moves.get(i);
        }

        return answer;
    }

    private void hanoi(int n, int source, int target,
                       int auxiliary, ArrayList<int[]> moves) {
        if (n == 1) {
            moves.add(new int[]{source, target});
            return;
        }
        hanoi(n - 1, source, auxiliary, target, moves);
        moves.add(new int[]{source, target});
        hanoi(n - 1, auxiliary, target, source, moves);
    }
}