// 40. 3진법 뒤집기

import java.lang.*;

class Solution {
    public int solution(int n) {
        
        String trit = Integer.toString(n, 3);
        
        StringBuilder reversed = new StringBuilder(trit).reverse();
        String reversedString = reversed.toString();
        
        int answer = convertTernaryToDecimal(reversedString);
        return answer;
    }
    
    public int convertTernaryToDecimal(String reversedString) {
        int decimalNumber = 0;
        int power = 0;
        
        for (int i = reversedString.length() - 1; i >= 0; i--) {
            char digitChar = reversedString.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            
            decimalNumber += digit * Math.pow(3, power);
            
            power++;
        }
        
        return decimalNumber;
    }
}
