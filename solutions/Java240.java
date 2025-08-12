//240. 괄호 변환

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return "";

        int balance = 0, i = 0;
        do {
            balance += (p.charAt(i) == '(') ? 1 : -1;
            i++;
        } while (balance != 0);
        String u = p.substring(0, i);
        String v = p.substring(i);

        if (isCorrect(u)) return u + solution(v);

        return "(" + solution(v) + ")" + reverse(u.substring(1, u.length() - 1));
    }

    private boolean isCorrect(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            cnt += (c == '(') ? 1 : -1;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) sb.append(c == '(' ? ')' : '(');
        return sb.toString();
    }
}