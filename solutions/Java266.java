//266. [3차] 파일명 정렬

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String[] file1 = splitFileName(o1);
            String[] file2 = splitFileName(o2);

            String head1 = file1[0].toLowerCase();
            String head2 = file2[0].toLowerCase();

            int headCompare = head1.compareTo(head2);
            if (headCompare != 0) return headCompare;

            int num1 = Integer.parseInt(file1[1]);
            int num2 = Integer.parseInt(file2[1]);

            return Integer.compare(num1, num2);
        });

        return files;
    }

    private String[] splitFileName(String file) {
        String head = "";
        String number = "";
        String tail = "";

        int i = 0;
        int len = file.length();

        while (i < len && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i);
            i++;
        }

        while (i < len && Character.isDigit(file.charAt(i)) && number.length() < 5) {
            number += file.charAt(i);
            i++;
        }

        if (i < len) {
            tail = file.substring(i);
        }

        return new String[]{head, number, tail};
    }
}
