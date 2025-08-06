//238. 문자열 압축

class Solution {
    public int solution(String s) {
        int minLength = s.length();

        for (int unit = 1; unit <= s.length() / 2; unit++) {
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, unit);
            int count = 1;

            for (int j = unit; j <= s.length(); j += unit) {
                String current;

                if (j + unit <= s.length()) {
                    current = s.substring(j, j + unit);
                } else {
                    current = s.substring(j);
                }

                if (prev.equals(current)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(prev);
                    prev = current;
                    count = 1;
                }
            }

            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(prev);

            minLength = Math.min(minLength, compressed.length());
        }

        return minLength;
    }
}