//254. [PCCP 기출문제] 2번 / 석유 시추

import java.util.*;

class Solution {
    int n, m;
    int[][] id;
    int[] size;
    int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

    public int solution(int[][] land) {
        n = land.length; m = land[0].length;
        id = new int[n][m];
        List<Integer> sizes = new ArrayList<>();
        sizes.add(0);

        int g = 1;
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                if (land[i][j]==1 && id[i][j]==0) {
                    sizes.add(dfs(land,i,j,g));
                    g++;
                }
        size = sizes.stream().mapToInt(Integer::intValue).toArray();

        int ans = 0;
        for (int col=0; col<m; col++) {
            Set<Integer> seen = new HashSet<>();
            int sum=0;
            for (int row=0; row<n; row++) {
                int gid = id[row][col];
                if (gid>0 && seen.add(gid)) sum+=size[gid];
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }

    int dfs(int[][] land, int x, int y, int g) {
        id[x][y]=g; int s=1;
        for (int d=0;d<4;d++) {
            int nx=x+dx[d], ny=y+dy[d];
            if (0<=nx&&nx<n&&0<=ny&&ny<m && land[nx][ny]==1 && id[nx][ny]==0)
                s+=dfs(land,nx,ny,g);
        }
        return s;
    }
}