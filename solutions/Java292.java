//292. [PCCP 기출문제] 4번 / 수식 복원하기

import java.util.*;

class Solution {

    public String[] solution(String[] expressions) {
        List<String> unknowns = new ArrayList<>();
        List<String[]> parsed = new ArrayList<>();

        int maxDigit = 0;

        for (String exp : expressions) {
            String[] parts = exp.split(" ");
            parsed.add(parts);

            for (String p : new String[]{parts[0], parts[2], parts[4]}) {
                if (!p.equals("X")) {
                    for (char c : p.toCharArray()) {
                        maxDigit = Math.max(maxDigit, c - '0');
                    }
                }
            }

            if (parts[4].equals("X")) {
                unknowns.add(exp);
            }
        }

        List<Integer> bases = new ArrayList<>();
        for (int b = maxDigit + 1; b <= 9; b++) {
            if (isValidBase(parsed, b)) {
                bases.add(b);
            }
        }

        List<String> answer = new ArrayList<>();

        for (String exp : unknowns) {
            String[] parts = exp.split(" ");
            String A = parts[0];
            String op = parts[1];
            String B = parts[2];

            Set<String> results = new HashSet<>();

            for (int base : bases) {
                int a = parse(A, base);
                int b = parse(B, base);
                int res = op.equals("+") ? a + b : a - b;
                results.add(toBase(res, base));
            }

            String value = results.size() == 1 ? results.iterator().next() : "?";
            answer.add(A + " " + op + " " + B + " = " + value);
        }

        return answer.toArray(new String[0]);
    }

    private boolean isValidBase(List<String[]> parsed, int base) {
        try {
            for (String[] p : parsed) {
                if (p[4].equals("X")) continue;

                int a = parse(p[0], base);
                int b = parse(p[2], base);
                int c = parse(p[4], base);

                int calc = p[1].equals("+") ? a + b : a - b;
                if (calc != c) return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private int parse(String s, int base) {
        int val = 0;
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (d >= base) throw new RuntimeException();
            val = val * base + d;
        }
        return val;
    }

    private String toBase(int num, int base) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % base);
            num /= base;
        }
        return sb.reverse().toString();
    }
}