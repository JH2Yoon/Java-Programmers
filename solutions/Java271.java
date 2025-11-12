//271. 셔틀버스

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] times = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            String[] parts = timetable[i].split(":");
            times[i] = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }
        Arrays.sort(times);

        int shuttleTime = 540;
        int idx = 0;
        int lastCrew = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            while (idx < times.length && times[idx] <= shuttleTime && count < m) {
                lastCrew = times[idx];
                idx++;
                count++;
            }

            if (i == n - 1) {
                if (count < m) {
                    return toTime(shuttleTime);
                } else return toTime(lastCrew - 1);
            }

            shuttleTime += t;
        }

        return "";
    }

    private String toTime(int minute) {
        int h = minute / 60;
        int m = minute % 60;
        return String.format("%02d:%02d", h, m);
    }
}