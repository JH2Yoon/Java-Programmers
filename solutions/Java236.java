//236. 튜플

import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] parts = s.split("\\},\\{");

        List<List<Integer>> list = new ArrayList<>();
        for (String part : parts) {
            String[] nums = part.split(",");
            List<Integer> temp = new ArrayList<>();
            for (String num : nums) {
                temp.add(Integer.parseInt(num));
            }
            list.add(temp);
        }

        list.sort(Comparator.comparingInt(List::size));

        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (List<Integer> l : list) {
            for (int num : l) {
                if (!seen.contains(num)) {
                    result.add(num);
                    seen.add(num);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}