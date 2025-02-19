// 162. 억억단을 외우자

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] count = new int[e + 1];
        
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                count[j]++;
            }
        }
        
        int[] maxCount = new int[e + 1];
        int max = 0;
        int bestNum = 0;
        
        for (int i = e; i >= 1; i--) {
            if (count[i] >= max) {
                max = count[i];
                bestNum = i;
            }
            maxCount[i] = bestNum;
        }

        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = maxCount[starts[i]];
        }
        
        return answer;
    }
}
