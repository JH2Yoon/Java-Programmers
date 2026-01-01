//288. [1차] 추석 트래픽

import java.util.*;

class Solution {

    static class Log {
        long start;
        long end;
        Log(long s, long e) {
            start = s;
            end = e;
        }
    }

    public int solution(String[] lines) {

        List<Log> logs = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(" ");

            String[] time = parts[1].split(":");
            long h = Long.parseLong(time[0]) * 3600 * 1000;
            long m = Long.parseLong(time[1]) * 60 * 1000;
            double sec = Double.parseDouble(time[2]) * 1000;

            long end = h + m + (long) sec;

            double duration = Double.parseDouble(
                    parts[2].substring(0, parts[2].length() - 1)
            ) * 1000;

            long start = end - (long) duration + 1;

            logs.add(new Log(start, end));
        }

        int answer = 0;

        for (Log 기준 : logs) {

            long[] checkTimes = { 기준.start, 기준.end };

            for (long t : checkTimes) {
                long windowStart = t;
                long windowEnd = t + 999;

                int count = 0;

                for (Log log : logs) {
                    if (log.end >= windowStart && log.start <= windowEnd) {
                        count++;
                    }
                }

                answer = Math.max(answer, count);
            }
        }

        return answer;
    }
}