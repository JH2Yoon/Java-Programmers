// 174. Java Substring

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        
        StringBuilder sb = new StringBuilder(S);
        String sub = sb.toString().substring(start, end);
        
        System.out.println(sub);
    }
}