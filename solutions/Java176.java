// 176. Java End-of-file

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineNumber = 1;
        
        while (scanner.hasNext()) {
            System.out.println(lineNumber + " " + scanner.nextLine());
            lineNumber++;
        }
        scanner.close();
    }
}