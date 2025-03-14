// 179. Java BigInteger

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String num1 = sc.nextLine();
        String num2 = sc. nextLine();
        
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        
        BigInteger sum = a.add(b);
        BigInteger product = a.multiply(b);
        
        System.out.println(sum);
        System.out.println(product);
        
        sc.close();
    }
}