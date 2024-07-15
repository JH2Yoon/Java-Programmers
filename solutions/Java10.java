// 10. 배열의 평균값


class Solution {
    public double solution(int[] numbers) {
        
        double answer = 0;
        
        for (Integer i : numbers)
        {
            answer += i;
        }    
        
        answer = answer / numbers.length;
        
        return answer;
    }
}

class Solution {
    public double solution(int[] numbers) {
        
        int sum = 0;
        double answer = 0;
        
        for (Integer i : numbers)
        {
            sum += i;
        }    
        
        answer = (double)sum / numbers.length;
        
        return answer;
    }
}
