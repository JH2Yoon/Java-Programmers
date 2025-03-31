// 191. Java List

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(scanner.nextInt());
        }
        
        int q = scanner.nextInt();
        
        for (int i = 0; i < q; i++) {
            String query = scanner.next();
            
            if (query.equals("Insert")) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                list.add(index, value);
            } else if (query.equals("Delete")) {
                int index = scanner.nextInt();
                list.remove(index);
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println(); 
    }
}