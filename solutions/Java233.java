//233. [1차] 뉴스 클러스터링

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        List<String> multiSet1 = createMultiset(str1);
        List<String> multiSet2 = createMultiset(str2);


        List<String> intersection = new ArrayList<>();
        List<String> copy = new ArrayList<>(multiSet2);

        for (String s : multiSet1) {
            if (copy.contains(s)) {
                intersection.add(s);
                copy.remove(s);
            }
        }

        int unionSize = multiSet1.size() + multiSet2.size() - intersection.size();

        if (unionSize == 0) {
            return 65536;
        }

        double jaccard = (double) intersection.size() / unionSize;
        return (int) (jaccard * 65536);
    }

    private List<String> createMultiset(String str) {
        List<String> multiset = new ArrayList<>();
        str = str.toLowerCase();

        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);

            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                multiset.add(str.substring(i, i + 2));
            }
        }
        return multiset;
    }
}