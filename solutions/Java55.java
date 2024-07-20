// 55. 카드 뭉치

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int one=0, two=0;
        
        for (int i=0; i<goal.length; i++) {
            if (one< cards1.length && cards1[one].equals(goal[i])) {
                one++;
            }
            else if (two<cards2.length && cards2[two].equals(goal[i])) {
                two++;
            }
            else
            {
                answer = "No";
                break;
            }
        }
        
        
        return answer;
    }
}