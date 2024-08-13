// 79. 카펫

class Solution {
    public int[] solution(int brown, int yellow) {
        // 최소 높이는 3 이상 이어야 함
        int w = 0, h = 3;
        
        // 전체 면적
        int area = brown + yellow;
        
        while (true) {
            if (area % h != 0) {
                h++;
                continue;
            }
            
            w = area / h;
            
            if ((w-2)*(h-2) == yellow) {
                break;
            }
            
            h++;
        }
        
        int[] answer = {w, h};
        return answer;
    }
}