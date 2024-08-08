// 74. 신고 결과 받기

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[][] board = new int[id_list.length+1][id_list.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i=0; i<id_list.length; i++) {
            map.put(id_list[i], i);
        }
        
        for (int i=0; i<report.length; i++) {
            String[] str = report[i].split(" ");
            String sender = str[0];
            String receiver = str[1];
            
            if (board[map.get(sender)][map.get(receiver)] == 0) {
                board[map.get(sender)][map.get(receiver)]++;
                board[id_list.length][map.get(receiver)]++;
            }
        }
        
        for(int i=0; i<id_list.length; i++)
        {
            if(board[id_list.length][i] >= k)
            {
                for(int j=0; j<id_list.length; j++)
                {
                    if(board[j][i] >= 1) answer[j]++;
                }
            }
        }

        return answer;
    }
}