//237. 오픈채팅방

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        List<String[]> messages = new ArrayList<>();

        for (String rec : record) {
            String[] parts = rec.split(" ");
            String command = parts[0];
            String uid = parts[1];


            if (command.equals("Enter") || command.equals("Change")) {
                String nickname = parts[2];
                userMap.put(uid, nickname);
            }

            if (command.equals("Enter") || command.equals("Leave")) {
                messages.add(new String[] {command, uid});
            }
        }

        List<String> result = new ArrayList<>();
        for (String[] msg : messages) {
            String command = msg[0];
            String uid = msg[1];
            String nickname = userMap.get(uid);

            if (command.equals("Enter")) {
                result.add(nickname + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                result.add(nickname + "님이 나갔습니다.");
            }
        }

        return result.toArray(new String[0]);
    }
}