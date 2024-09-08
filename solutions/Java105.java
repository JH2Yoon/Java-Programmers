// 105. 쿼드압축 후 개수 세기

class Solution {
    int[] answer;
    
    public int[] solution(int[][] arr) {
        answer = new int[2];
        compress(arr, 0, 0, arr.length);
    
        return answer;
    }
    public void compress(int[][] arr, int x, int y, int size) {
        if (isUniform(arr, x, y, size)) {
            answer[arr[x][y]]++;
        } else {
            int newSize = size / 2;
            compress(arr, x, y, newSize);       // 위-왼쪽
            compress(arr, x, y + newSize, newSize);     // 위-오른쪽
            compress(arr, x + newSize, y, newSize);     // 아래-왼쪽
            compress(arr, x + newSize, y + newSize, newSize);       // 아래-오른쪽
        }
    }

    private boolean isUniform(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}