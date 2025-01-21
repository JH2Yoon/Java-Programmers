//141. 당구 연습

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int minDistanceSquared = Integer.MAX_VALUE;

            if (!(startY == targetY && startX >= targetX)) {
                int reflectedX = targetX * -1;
                minDistanceSquared = Math.min(minDistanceSquared, getDistanceSquared(startX, startY, reflectedX, targetY));
            }

            if (!(startY == targetY && startX <= targetX)) {
                int reflectedX = m + (m - targetX);
                minDistanceSquared = Math.min(minDistanceSquared, getDistanceSquared(startX, startY, reflectedX, targetY));
            }

            if (!(startX == targetX && startY <= targetY)) {
                int reflectedY = n + (n - targetY);
                minDistanceSquared = Math.min(minDistanceSquared, getDistanceSquared(startX, startY, targetX, reflectedY));
            }

            if (!(startX == targetX && startY >= targetY)) {
                int reflectedY = targetY * -1;
                minDistanceSquared = Math.min(minDistanceSquared, getDistanceSquared(startX, startY, targetX, reflectedY));
            }

            answer[i] = minDistanceSquared;
        }

        return answer;
    }

    private int getDistanceSquared(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}