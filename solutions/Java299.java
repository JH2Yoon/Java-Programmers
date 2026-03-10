//299. [3차] 자동완성

class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int count;
    }

    TrieNode root = new TrieNode();

    public int solution(String[] words) {

        for (String word : words)insert(word);

        int answer = 0;

        for (String word : words) answer += countInput(word);

        return answer;
    }

    private void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (node.child[idx] == null) {
                node.child[idx] = new TrieNode();
            }

            node = node.child[idx];
            node.count++;
        }
    }

    private int countInput(String word) {
        TrieNode node = root;
        int input = 0;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            node = node.child[idx];
            input++;

            if (node.count == 1) break;
        }

        return input;
    }
}