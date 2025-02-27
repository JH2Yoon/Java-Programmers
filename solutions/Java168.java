// 168. Java Currency Formatter

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        Locale us = Locale.US;
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(us);
        
        Locale india = new Locale("en", "IN");
        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(india);
        
        Locale china = Locale.CHINA;
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(china);
        
        Locale france = Locale.FRANCE;
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(france);
        
        System.out.println("US: " + usFormat.format(payment));
        System.out.println("India: " + indiaFormat.format(payment));
        System.out.println("China: " + chinaFormat.format(payment));
        System.out.println("France: " + franceFormat.format(payment));
    }
}