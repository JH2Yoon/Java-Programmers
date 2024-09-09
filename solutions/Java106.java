// 106. 택배상자

import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // 컨테이너 벨트 초기화
        for (int i = 1; i <= order.length; i++) {
            queue.add(i);
        }
        
        int index = 0; // 현재 트럭에 실어야 할 상자의 인덱스
        int answer = 0;
        
        while (!queue.isEmpty()) {
            int currentBox = queue.poll();
            
            // 현재 상자를 트럭에 실어야 할 순서와 비교
            while (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop(); // 보조 벨트에서 상자를 꺼내어 트럭에 실기
                index++;
                answer++;
                if (index >= order.length) {
                    return answer; // 모든 상자를 실었다면 반환
                }
            }
            
            if (currentBox == order[index]) {
                answer++;
                index++;
                // 현재 상자가 트럭에 실어야 할 상자라면 트럭에 실기
            } else {
                stack.push(currentBox); // 보조 벨트에 상자 저장
            }
        
        
        }
        
        // 남아있는 보조 벨트의 상자를 확인
        while (!stack.isEmpty() && stack.peek() == order[index]) {
            stack.pop();
            index++;
            answer++;
            if (index >= order.length) {
                break;
            }
        }
        
        return answer;
    }
}