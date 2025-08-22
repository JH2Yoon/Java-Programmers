//244. 메뉴 리뉴얼

import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int c : course) {
            Map<String, Integer> map = new HashMap<>();
            int max = 0;

            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                dfs(arr, c, 0, new StringBuilder(), map);
            }

            for (int v : map.values()) if (v >= 2) max = Math.max(max, v);
            for (String k : map.keySet()) if (map.get(k) == max && max >= 2) result.add(k);
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void dfs(char[] arr, int len, int idx, StringBuilder sb, Map<String,Integer> map) {
        if (sb.length() == len) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            sb.append(arr[i]);
            dfs(arr, len, i+1, sb, map);
            sb.setLength(sb.length()-1);
        }
    }
}