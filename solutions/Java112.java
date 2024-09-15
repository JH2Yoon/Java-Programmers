// 112. 행렬 테두리 회전하기

import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] resultArr = new int[rows][columns];
        int[][] copyArr = new int[rows][columns];
        
        int cnt = 1;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                int n = cnt++;
                resultArr[i][j] = n;
                copyArr[i][j] = n;
            }
        }
        
        for(int i = 0; i<queries.length; i++){
            int preX = queries[i][0] - 1;
            int preY = queries[i][1] - 1;
            int postX = queries[i][2] - 1;
            int postY = queries[i][3] - 1;
            
            answer[i] = rollingArray(resultArr, copyArr, preX, preY, postX, postY);
        }
        
        return answer;
    }
    
    public int rollingArray(int[][] resultArr, int[][] copyArr, int preX, int preY, int postX, int postY){
        
        int dir = 0; // 0 - 우, 1 - 하, 2 - 좌, 3 - 상
        int x = preX;   // 세로
        int y = preY;   // 가로
        int result = 10001;
        int tmp = 0;
            
        while(true){
            if(dir == 0 && y == postY){
                dir = 1;
            }else if(dir == 1 && x == postX){
                dir = 2;
            }else if(dir == 2 && y == preY){
                dir = 3;
            }else if(dir == 3 && x == preX){
                resultArr[preX][preY] = copyArr[preX+1][preY];
                result = Math.min(result, resultArr[preX][preY]);
                break;
            }
            
            tmp = copyArr[x][y];
            
            if(dir == 0){
                y++;
            }else if(dir == 1){
                x++;
            }else if(dir == 2){
                y--;
            }else if(dir == 3){
                x--;
            }
            
            resultArr[x][y] = tmp;
            result = Math.min(result, resultArr[x][y]);
        }
        
        for(int i = 0; i<resultArr.length; i++){
            for(int j = 0; j<resultArr[i].length; j++){
                copyArr[i][j] = resultArr[i][j];
            }
        }
        
        return result;
    }
}