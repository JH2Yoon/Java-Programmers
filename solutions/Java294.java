//294. 가사 검색

import java.util.*;

class Solution {

    Map<Integer, List<String>> words = new HashMap<>();
    Map<Integer, List<String>> reversed = new HashMap<>();

    public int[] solution(String[] wordsArr, String[] queries) {

        for (String w : wordsArr) {
            int len = w.length();
            words.computeIfAbsent(len, k -> new ArrayList<>()).add(w);
            reversed.computeIfAbsent(len, k -> new ArrayList<>())
                    .add(new StringBuilder(w).reverse().toString());
        }

        for (int len : words.keySet()) {
            Collections.sort(words.get(len));
            Collections.sort(reversed.get(len));
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int len = q.length();

            if (!words.containsKey(len)) {
                answer[i] = 0;
                continue;
            }

            if (q.charAt(0) != '?') {
                answer[i] = countByRange(
                        words.get(len),
                        q.replace('?', 'a'),
                        q.replace('?', 'z')
                );
            } else {
                String rq = new StringBuilder(q).reverse().toString();
                answer[i] = countByRange(
                        reversed.get(len),
                        rq.replace('?', 'a'),
                        rq.replace('?', 'z')
                );
            }
        }

        return answer;
    }

    private int countByRange(List<String> list, String left, String right) {
        return upperBound(list, right) - lowerBound(list, left);
    }

    private int lowerBound(List<String> list, String target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid).compareTo(target) >= 0) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private int upperBound(List<String> list, String target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid).compareTo(target) > 0) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}