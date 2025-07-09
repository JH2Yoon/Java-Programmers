//225. 공원

import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int rows = park.length, cols = park[0].length;

        for (int k = mats.length - 1; k >= 0; k--) {
            int mat = mats[k];
            for (int i = 0; i <= rows - mat; i++) {
                for (int j = 0; j <= cols - mat; j++) {
                    boolean canPlace = true;
                    for (int x = i; x < i + mat && canPlace; x++) {
                        for (int y = j; y < j + mat; y++) {
                            if (!park[x][y].equals("-1")) {
                                canPlace = false;
                                break;
                            }
                        }
                    }
                    if (canPlace) return mat;
                }
            }
        }
        return -1;
    }
}