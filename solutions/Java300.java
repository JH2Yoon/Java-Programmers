//300. 비밀 코드 해독

class Solution {

    int answer = 0;
    int[] comb = new int[5];

    public int solution(int n, int[][] q, int[] ans) {
        dfs(1, 0, n, q, ans);
        return answer;
    }

    void dfs(int start, int depth, int n, int[][] q, int[] ans) {

        if (depth == 5) {
            if (check(q, ans)) answer++;
            return;
        }

        for (int i = start; i <= n; i++) {
            comb[depth] = i;
            dfs(i + 1, depth + 1, n, q, ans);
        }
    }

    boolean check(int[][] q, int[] ans) {

        for (int i = 0; i < q.length; i++) {

            int count = 0;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++)if (q[i][j] == comb[k]) count++;
            }

            if (count != ans[i]) return false;
        }

        return true;
    }
}