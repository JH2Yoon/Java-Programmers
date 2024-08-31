// 97. 모음사전

import java.util.*;

class Solution {
    
    // 생성된 모든 단어 저장
    static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        
        dfs("");
        
        // 해당 단어의 인덱스를 반환
        return list.indexOf(word);
    }
    
    public static void dfs(String s) {
        // 단어 길이가 5 이상 이면 dfs 종료
        if (s.length() > 5) return;
        
        // 생성된 단어 저장
        list.add(s);
        
        // 각 모음 'A', 'E', 'I', 'O', 'U'를 붙여 새로운 단어를 생성하고 재귀 호출
        for (int i=0; i<5; i++) {
            dfs(s + "AEIOU".charAt(i));
        }
    }
}