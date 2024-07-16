// 18. 문자열을 정수로 바꾸기


class Solution {
    public int solution(String s) {
        int answer = 0;
        
        answer = Integer.parseInt(s);
        return answer;
    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        answer = Integer.valueOf(s);
        return answer;
    }
}
