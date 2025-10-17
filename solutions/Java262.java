//262. 표 편집

import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = (i == n - 1) ? -1 : i + 1;
        }

        boolean[] removed = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = k;

        for (String command : cmd) {
            char op = command.charAt(0);

            switch (op) {
                case 'U' -> {
                    int x = Integer.parseInt(command.substring(2));
                    while (x-- > 0) cur = prev[cur];
                }
                case 'D' -> {
                    int x = Integer.parseInt(command.substring(2));
                    while (x-- > 0) cur = next[cur];
                }
                case 'C' -> {
                    stack.push(cur);
                    removed[cur] = true;

                    int p = prev[cur];
                    int nidx = next[cur];

                    if (p != -1) next[p] = nidx;
                    if (nidx != -1) prev[nidx] = p;

                    cur = (nidx != -1) ? nidx : p;
                }
                case 'Z' -> {
                    int restore = stack.pop();
                    removed[restore] = false;

                    int p = prev[restore];
                    int nidx = next[restore];

                    if (p != -1) next[p] = restore;
                    if (nidx != -1) prev[nidx] = restore;
                }
            }
        }

        StringBuilder result = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            result.append(removed[i] ? 'X' : 'O');
        }

        return result.toString();
    }
}