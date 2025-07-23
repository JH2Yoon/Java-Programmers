//232. [3차] 압축

import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        int dictIndex = 27;
        int i = 0;

        while (i < msg.length()) {
            String w = String.valueOf(msg.charAt(i));
            int j = i + 1;

            while (j <= msg.length() && dict.containsKey(msg.substring(i, j))) {
                w = msg.substring(i, j);
                j++;
            }

            result.add(dict.get(w));

            if (j <= msg.length()) {
                String wc = msg.substring(i, j);
                dict.put(wc, dictIndex++);
            }

            i += w.length();
        }

        return result;
    }
}
