// 175. Java String Tokens

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        
        String[] outStrings = s.split("[^a-zA-Z]+");
        
        int count = 0;
        for (String word : outStrings) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        
        System.out.println(count);
        
        for (String word : outStrings) {
            if (!word.isEmpty()) { 
                System.out.println(word);
            }
        }
        
        scan.close();
    }
}