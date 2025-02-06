// 152. 가장 긴 팰린드롬

class Solution
{
    public int solution(String s) {
        int answer = longestPalindromeLength(s);
        return answer;
    }
    
    private int longestPalindromeLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int n = str.length();
        int maxLength = 1;
        
        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(str, i, i);
            int len2 = expandAroundCenter(str, i, i + 1);
            
            int currentMax = Math.max(len1, len2);
            maxLength = Math.max(maxLength, currentMax);
        }
        
        return maxLength;
    }
    
    private int expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}