// 22. 두 정수 사이의 합

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if (a<b) {
            for (int i=a; i<=b; i++) {
                answer += i;
            }
        } else {
            for (int i=a; i>=b; i--) {
                answer += i;
            }
        }
        
        return answer;
    }
}



class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        
        for (int i=min; i<=max; i++) {
            answer += i;
        }
        return answer;
    }
}
