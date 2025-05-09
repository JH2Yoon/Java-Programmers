//219. Java 1D Array (Part 2)

import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        return isWinnable(0, leap, game);
    }

    private static boolean isWinnable(int i, int leap, int[] game) {
        int n = game.length;

        if (i >= n) return true;

        if (i < 0 || game[i] == 1) return false;

        game[i] = 1;

        return isWinnable(i + leap, leap, game) ||
                isWinnable(i + 1, leap, game) ||
                isWinnable(i - 1, leap, game);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
