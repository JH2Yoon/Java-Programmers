//132. 과제 진행하기

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        Stack<String[]> stop = new Stack<>();

        Arrays.sort(plans, (a, b) -> timeToMinutes(a[1]) - timeToMinutes(b[1]));

        int z = 0;
        int idx = 0;
        int currentTime = 0;
        int nextStartTime = 0;

        while (idx < plans.length) {
            String taskName = plans[idx][0];
            int taskStartTime = timeToMinutes(plans[idx][1]);
            int taskDuration = Integer.parseInt(plans[idx][2]);

            currentTime = taskStartTime + taskDuration;

            if (idx < plans.length - 1) {
                nextStartTime = timeToMinutes(plans[idx + 1][1]);
                if (currentTime > nextStartTime) {
                    stop.push(new String[] { taskName, currentTime - nextStartTime + "" });
                    currentTime = nextStartTime;
                    idx++;
                    continue;
                }
            }

            answer[z++] = taskName;

            while (!stop.isEmpty()) {
                int remainingTime = nextStartTime - currentTime;
                String[] pausedTask = stop.pop();

                int pausedTaskDuration = Integer.parseInt(pausedTask[1]);

                if (remainingTime >= pausedTaskDuration) {
                    answer[z++] = pausedTask[0];
                    currentTime += pausedTaskDuration;
                } else {
                    stop.push(new String[] { pausedTask[0], pausedTaskDuration - remainingTime + "" });
                    break;
                }
            }

            idx++;
        }

        while (!stop.isEmpty()) {
            answer[z++] = stop.pop()[0];
        }

        return answer;
    }

    public int timeToMinutes(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]) * 60;
        int m = Integer.parseInt(t[1]);
        return h + m;
    }
}