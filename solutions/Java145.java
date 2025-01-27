// 145. 단어 변환

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        
        if (!wordSet.contains(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                
                for (String word : wordSet) {
                    if (!visited.contains(word) && isOneLetterDifferent(currentWord, word)) {
                        if (word.equals(target)) return level;
                        visited.add(word);
                        queue.offer(word);
                    }
                }
            }
            level++;
        }

        return 0;
    }

    private boolean isOneLetterDifferent(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i) && ++diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;
    }
}
