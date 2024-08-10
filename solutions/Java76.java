// 76. JadenCase 문자열 만들기

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] sSplit = s.split("(?<=\\s)|(?=\\s)");
        
        for (String word : sSplit) {
            if (word.trim().length() > 0) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                answer += firstChar + word.substring(1).toLowerCase();
            } else {
                answer += word;
            }
        }
        return answer;
    }
}