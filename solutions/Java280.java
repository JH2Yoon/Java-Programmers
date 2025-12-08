//280. 단체사진 찍기

import java.util.*;

class Solution {

    static final char[] FRIENDS = {'A','C','F','J','M','N','R','T'};
    static boolean[] visited = new boolean[8];
    static int answer;

    public int solution(int n, String[] data) {
        answer = 0;
        dfs("", data);
        return answer;
    }

    private void dfs(String line, String[] data) {
        if (line.length() == 8) {
            if (check(line, data)) answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(line + FRIENDS[i], data);
                visited[i] = false;
            }
        }
    }

    private boolean check(String line, String[] data) {
        for (String cond : data) {
            char a = cond.charAt(0);
            char b = cond.charAt(2);
            char op = cond.charAt(3);
            int required = cond.charAt(4) - '0';

            int posA = line.indexOf(a);
            int posB = line.indexOf(b);

            int dist = Math.abs(posA - posB) - 1;

            switch(op) {
                case '=':
                    if (dist != required) return false;
                    break;
                case '<':
                    if (dist >= required) return false;
                    break;
                case '>':
                    if (dist <= required) return false;
                    break;
            }
        }
        return true;
    }
}