//133. 조이스틱

class Solution {

    public int solution(String name) {
        int n = name.length();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            int moveUp = c - 'A';
            int moveDown = 'Z' - c + 1;
            answer += Math.min(moveUp, moveDown);
        }

        int minMove = n - 1;

        for (int i = 0; i < n; i++) {
            int nextIdx = i + 1;
            while (nextIdx < n && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }

            minMove = Math.min(minMove, Math.min(i * 2 + n - nextIdx, (n - nextIdx) * 2 + i));
        }

        return answer + minMove;
    }
}
