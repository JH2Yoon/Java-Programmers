//224.택배 상자 꺼내기

class Solution {
    public int solution(int n, int w, int num) {
        int level = (num - 1) / w;
        int pos   = (num - 1) % w;
        int count = 0;

        while (true) {
            int value = w * level + pos + 1;
            if (value > n) break;
            count++;

            level++;
            pos = w - pos - 1;
        }
        return count;
    }
}