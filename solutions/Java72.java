// 72. 달리기 경주

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> ranking = new HashMap<>();
        
        int numOfLength = players.length;
        for (int i=0; i<numOfLength; i++) {
            ranking.put(players[i], i);
        }
        
        for (int i=0; i<callings.length; i++) {
        
            int playerRanking = ranking.get(callings[i]);
            
            String frontPlayer = players[playerRanking-1];
            
            ranking.replace(frontPlayer, playerRanking);
            players[playerRanking] = frontPlayer;

            ranking.replace(callings[i], playerRanking-1);
            players[playerRanking-1] = callings[i]; 
        }
        
        
        return players;
    }
}