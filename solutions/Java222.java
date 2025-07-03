//222. 외톨이 알파벳

import java.util.*;

class Solution {
    public String solution(String input_string) {
        HashMap<Character, Integer> countAlphabet = new HashMap<>();
        char prev = 0;

        for (int i = 0; i < input_string.length(); i++) {
            char curr = input_string.charAt(i);
            if (curr != prev) {
                countAlphabet.put(curr, countAlphabet.getOrDefault(curr, 0) + 1);
            }
            prev = curr;
        }


        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : countAlphabet.entrySet()) {
            if (entry.getValue() >= 2) {
                result.add(entry.getKey());
            }
        }

        if (result.isEmpty()) return "N";

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) sb.append(c);
        return sb.toString();
    }
}