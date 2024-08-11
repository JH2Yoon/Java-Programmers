// 77. 이진 변환 반복하기

class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0, cnt = 0;
        
        while (s.length() > 1) {
            String removeZero = "";
            
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == '1') {
                    removeZero += "1";
                } else {
                    zeroCnt++;
                }
            }
            
            
            int removeZeroLen = removeZero.length();
            s = Integer.toBinaryString(removeZeroLen);
            
            cnt++;
            
        }
        
        int[] answer = {cnt, zeroCnt};
        return answer;
    }
}