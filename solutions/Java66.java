// 66. 대충 만든 자판

import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> keypad = new HashMap<>();

        for (int i=0; i<keymap.length; i++) {
            for (int j=0; j<keymap[i].length(); j++) {
                char keymapCh = keymap[i].charAt(j);
                if (keypad.containsKey(keymapCh)) {
                    int idx = keypad.get(keymapCh);
                    keypad.put(keymapCh, Math.min(idx, j + 1));
                } else {
                    keypad.put(keymapCh, j+1);
                }
            }
        }
        
        for (int i=0; i<targets.length; i++) {
            String target = targets[i];
            int count = 0;
            boolean flag = true;
            for(char targetCh : target.toCharArray()) {
                if(keypad.containsKey(targetCh)){
                    count += keypad.get(targetCh);
                }
                else{
                    flag = false;
                    break;
                }
            }
            
            answer[i] = flag == false ? -1 : count;

            
        }
        
        return answer;
        
        
    }
}