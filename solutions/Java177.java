// 177. Java SHA-256

import java.io.*;
import java.security.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            
            System.out.println(hexString.toString());
        } catch(NoSuchAlgorithmException e) {
            System.out.println("Error: SHA-256 algorithm not found");
        }
    }
}