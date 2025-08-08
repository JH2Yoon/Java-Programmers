//239. 영어 끝말잇기

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> usedWords = new ArrayList<>();
        int[] answer = {0, 0};

        usedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];

            if (usedWords.contains(curr)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }

            if (prev.charAt(prev.length() - 1) != curr.charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }

            usedWords.add(curr);
        }

        return answer;
    }
}