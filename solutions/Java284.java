//284. 표현 가능한 이진트리

class Solution {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);

            int len = binary.length();
            int treeLen = 1;
            while (treeLen < len) {
                treeLen = treeLen * 2 + 1;
            }

            String padded = "0".repeat(treeLen - len) + binary;

            answer[i] = isValid(padded) ? 1 : 0;
        }

        return answer;
    }

    private boolean isValid(String tree) {
        int mid = tree.length() / 2;
        char root = tree.charAt(mid);

        String left = tree.substring(0, mid);
        String right = tree.substring(mid + 1);

        if (root == '0') {
            if (left.contains("1") || right.contains("1")) {
                return false;
            }
        }

        if (tree.length() == 1) return true;

        return isValid(left) && isValid(right);
    }
}