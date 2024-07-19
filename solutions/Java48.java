// 48. K번째수정렬

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list = new ArrayList<>();
        
        int idx=0;
        for (int[] command : commands) {
            
            for (int i=command[0]-1; i < command[1]; i++) {
                list.add(array[i]);
            }
            
            Collections.sort(list);
            
            answer[idx++] = list.get(command[2]-1);
            list.clear();
        }
        
        return answer;
    }
}