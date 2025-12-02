//278. 광고 삽입

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {

        int playSec = toSeconds(play_time);
        int advSec = toSeconds(adv_time);

        long[] viewers = new long[playSec + 1];

        for (String log : logs) {
            String[] parts = log.split("-");
            int s = toSeconds(parts[0]);
            int e = toSeconds(parts[1]);
            viewers[s] += 1;
            if (e <= playSec) viewers[e] -= 1;
        }

        for (int i = 1; i <= playSec; i++) {
            viewers[i] += viewers[i - 1];
        }

        long[] acc = new long[playSec + 1];
        acc[0] = viewers[0];
        for (int i = 1; i < playSec; i++) {
            acc[i] = acc[i - 1] + viewers[i];
        }

        long maxSum = -1;
        int bestStart = 0;

        if (advSec == playSec) return toTimeString(0);

        for (int start = 0; start <= playSec - advSec; start++) {
            int end = start + advSec - 1;
            long sum = acc[end] - (start > 0 ? acc[start - 1] : 0L);

            if (sum > maxSum) {
                maxSum = sum;
                bestStart = start;
            }
        }

        return toTimeString(bestStart);
    }

    private int toSeconds(String time) {
        String[] p = time.split(":");
        int h = Integer.parseInt(p[0]);
        int m = Integer.parseInt(p[1]);
        int s = Integer.parseInt(p[2]);
        return h * 3600 + m * 60 + s;
    }

    private String toTimeString(int sec) {
        int h = sec / 3600;
        sec %= 3600;
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}