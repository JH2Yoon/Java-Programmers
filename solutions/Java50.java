// 50. 가장 가까운 같은 글자

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            for (int j=i; j>=0; j--) {
                if (c == s.charAt(j) && answer[i]==0) {
                    answer[i] = i-j;
                }
            }
            
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}