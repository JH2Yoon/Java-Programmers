//306. 주사위 고르기

import java.util.*;

class Solution {
    int n;
    int[][] dice;
    int maxWin = -1;
    int[] answer;

    public int[] solution(int[][] dice) {
        this.dice = dice;
        this.n = dice.length;

        comb(0, 0, new ArrayList<>());

        return answer;
    }

    void comb(int idx, int cnt, List<Integer> selected) {
        if (cnt == n / 2) {
            solve(selected);
            return;
        }
        if (idx == n) return;

        selected.add(idx);
        comb(idx + 1, cnt + 1, selected);
        selected.remove(selected.size() - 1);

        comb(idx + 1, cnt, selected);
    }

    void solve(List<Integer> Aidx) {
        boolean[] picked = new boolean[n];
        for (int i : Aidx) picked[i] = true;

        List<Integer> Bidx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!picked[i]) Bidx.add(i);
        }

        int[] A = buildDP(Aidx);
        int[] B = buildDP(Bidx);

        int[] prefix = new int[1001];
        prefix[0] = B[0];
        for (int i = 1; i < 1001; i++) {
            prefix[i] = prefix[i - 1] + B[i];
        }

        int win = 0;

        for (int s = 1; s < 1001; s++) {
            if (A[s] == 0) continue;
            win += A[s] * prefix[s - 1];
        }

        if (win > maxWin) {
            maxWin = win;
            answer = Aidx.stream().mapToInt(i -> i + 1).toArray();
        }
    }

    int[] buildDP(List<Integer> idxs) {
        int[] dp = new int[1001];
        dp[0] = 1;

        for (int idx : idxs) {
            int[] next = new int[1001];
            for (int s = 0; s <= 1000; s++) {
                if (dp[s] == 0) continue;
                for (int v : dice[idx]) {
                    next[s + v] += dp[s];
                }
            }
            dp = next;
        }
        return dp;
    }
}