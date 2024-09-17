// 114. 배달

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] dis = new int[N][N];
        
         for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j) dis[i][j] = 0;
                else dis[i][j] = (int)1e9;
            }
        }
        for(int i=0; i<road.length; i++) {
            dis[road[i][0]-1][road[i][1]-1] = Math.min(road[i][2],dis[road[i][0]-1][road[i][1]-1]);
            dis[road[i][1]-1][road[i][0]-1] = Math.min(road[i][2],dis[road[i][1]-1][road[i][0]-1]);
        }
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(dis[i][j] > dis[i][k] + dis[k][j]){
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            if(dis[i][0] <= K) answer++;
        }

        return answer;
    }
}