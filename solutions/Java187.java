// 187. Java Arraylist

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int k = Integer.parseInt(parts[0]);

            ArrayList<Integer> currentLine = new ArrayList<>();
            for (int j = 1; j <= k; j++) {
                currentLine.add(Integer.parseInt(parts[j]));
            }

            lines.add(currentLine);
        }

        int q = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt(); 
            scanner.nextLine();

            if (x > 0 && x <= lines.size()) {
                ArrayList<Integer> line = lines.get(x - 1);
                if (y > 0 && y <= line.size()) {
                    System.out.println(line.get(y - 1));
                } else {
                    System.out.println("ERROR!");
                }
            } else {
                System.out.println("ERROR!");
            }
        }

        scanner.close();
    }
}