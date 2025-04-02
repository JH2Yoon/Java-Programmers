// 194. Java Subarray

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int negativeCount = 0;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                
                if (currentSum < 0) {
                    negativeCount++;
                }
            }
        }
        System.out.println(negativeCount);
        
        scanner.close();
    }
}