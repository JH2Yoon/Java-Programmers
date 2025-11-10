//270. 후보키

import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int row = relation.length, col = relation[0].length;
        List<Integer> candidateKeys = new ArrayList<>();

        for (int bit = 1; bit < (1 << col); bit++) {
            Set<String> set = new HashSet<>();
            for (String[] tuple : relation) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < col; i++)
                    if ((bit & (1 << i)) != 0) sb.append(tuple[i]).append(",");
                set.add(sb.toString());
            }
            if (set.size() != row) continue;

            boolean minimal = true;
            for (int key : candidateKeys)
                if ((key & bit) == key) { minimal = false; break; }

            if (minimal) candidateKeys.add(bit);
        }

        return candidateKeys.size();
    }
}