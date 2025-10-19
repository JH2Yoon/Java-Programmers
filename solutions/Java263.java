//263. 불량 사용자

import java.util.*;

class Solution {
    Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(user_id, banned_id, new HashSet<>(), 0);
        return result.size();
    }

    private void dfs(String[] user_id, String[] banned_id, Set<String> selected, int idx) {
        if (idx == banned_id.length) {
            result.add(new HashSet<>(selected));
            return;
        }

        for (String user : user_id) {
            if (selected.contains(user)) continue;
            if (match(user, banned_id[idx])) {
                selected.add(user);
                dfs(user_id, banned_id, selected, idx + 1);
                selected.remove(user);
            }
        }
    }

    private boolean match(String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (user.charAt(i) != banned.charAt(i)) return false;
        }
        return true;
    }
}