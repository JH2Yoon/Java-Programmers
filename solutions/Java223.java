//223. 유연근무제

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;

        for (int i = 0; i < n; i++) {
            boolean isOnTimeAllWeek = true;

            for (int d = 0; d < 7; d++) {
                int dayOfWeek = (startday + d - 1) % 7 + 1;

                if (dayOfWeek == 6 || dayOfWeek == 7) continue;

                int expectTime = toMinutes(schedules[i]);
                int actualTime = toMinutes(timelogs[i][d]);

                if (actualTime > expectTime + 10) {
                    isOnTimeAllWeek = false;
                    break;
                }
            }

            if (isOnTimeAllWeek) answer++;
        }

        return answer;
    }

    private int toMinutes(int time) {
        int hour = time / 100;
        int minute = time % 100;
        return hour * 60 + minute;
    }
}