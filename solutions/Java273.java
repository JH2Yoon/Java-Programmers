//273. [3차] 방금그곡

import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = convert(m);

        String answer = "(None)";
        int maxPlayTime = -1;

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            String start = parts[0];
            String end = parts[1];
            String title = parts[2];
            String melody = parts[3];

            int playTime = getPlayTime(start, end);

            melody = convert(melody);

            String played = buildPlayedMelody(melody, playTime);

            if (played.contains(m)) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }

    private String convert(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }

    private String buildPlayedMelody(String melody, int playTime) {
        StringBuilder sb = new StringBuilder();
        int len = melody.length();

        for (int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % len));
        }
        return sb.toString();
    }

    private int getPlayTime(String start, String end) {
        int startMin = parseTime(start);
        int endMin = parseTime(end);
        return endMin - startMin;
    }

    private int parseTime(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}