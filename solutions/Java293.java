//293.호텔방 배정

import java.util.*;

class Solution {
    Map<Long, Long> parent = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            long want = room_number[i];
            long assigned = find(want);
            answer[i] = assigned;

            parent.put(assigned, assigned + 1);
        }

        return answer;
    }

    private long find(long room) {
        if (!parent.containsKey(room)) {
            return room;
        }

        long next = find(parent.get(room));
        parent.put(room, next);
        return next;
    }
}