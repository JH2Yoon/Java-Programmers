// 181. Java Anagrams

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        
        if (a.length() != b.length()) {
            return false;
        }
        
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        
        java.util.Arrays.sort(aArr);
        java.util.Arrays.sort(bArr);
        
        return java.util.Arrays.equals(aArr, bArr);
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
