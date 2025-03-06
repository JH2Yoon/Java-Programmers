// 173. Java String Reverse

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        
        String reverseString = new StringBuilder(A).reverse().toString();
        
        if (A.equals(reverseString)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}