// 197. Java BitSet

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        BitSet bitSet1 = new BitSet(n);
        BitSet bitSet2 = new BitSet(n);
        
        for (int i = 0; i < m; i++) {
            String operation = sc.next();
            int index1 = sc.nextInt();
            int index2 = sc.nextInt();
            
            switch (operation) {
                case "AND":
                    if (index1 == 1 && index2 == 2) {
                        bitSet1.and(bitSet2);
                    } else if (index1 == 2 && index2 == 1) {
                        bitSet2.and(bitSet1);
                    }
                    break;
                case "OR":
                    if (index1 == 1 && index2 == 2) {
                        bitSet1.or(bitSet2);
                    } else if (index1 == 2 && index2 == 1) {
                        bitSet2.or(bitSet1);
                    }
                    break;
                case "XOR":
                    if (index1 == 1 && index2 == 2) {
                        bitSet1.xor(bitSet2);
                    } else if (index1 == 2 && index2 == 1) {
                        bitSet2.xor(bitSet1);
                    }
                    break;
                case "FLIP":
                    if (index1 == 1) {
                        bitSet1.flip(index2);
                    } else {
                        bitSet2.flip(index2);
                    }
                    break;
                case "SET":
                    if (index1 == 1) {
                        bitSet1.set(index2);
                    } else {
                        bitSet2.set(index2);
                    }
                    break;
            }
            
            System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
        }

        sc.close();
    }
}