// 119. 숫자 카드 나누기

import java.util.*;

class Solution {
    static List<Integer> list;
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        list = new ArrayList<>();
        int a = getNum(arrayA, arrayB);
        list.clear();
        int b = getNum(arrayB, arrayA);

        answer = Math.max(a, b);


        return answer;
    }
    
    static int getNum(int[] arr, int[] arr2) {
        int ans = 0;
        for(int i=1; i<=arr[arr.length-1]; i++) {
            int cnt = 0;
            for(int j=0; j<arr.length; j++) {
                if(arr[j] % i == 0) {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == arr.length) {
                list.add(i);
            }
        }

        for(int i=0; i<list.size(); i++) {
            int cnt = 0;
            for(int j=0; j<arr2.length; j++) {
                if(arr2[j] % list.get(i) != 0) {
                    cnt++;
                } else {
                    break;
                }
            }
            if(cnt == arr2.length) {
                ans = list.get(i);
            }
        }
        return ans;
    }
}