// 188. Prime Checker

import java.io.*;

class Prime {
    static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void checkPrime(int... nums) {
        boolean foundPrime = false;

        for (int num : nums) {
            if (isPrime(num)) {
                if (foundPrime) {
                    System.out.print(" ");
                }
                System.out.print(num);
                foundPrime = true;
            }
        }

        if (foundPrime) {
            System.out.println();
        } else {
            System.out.println();
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int num3 = Integer.parseInt(br.readLine());
        int num4 = Integer.parseInt(br.readLine());
        int num5 = Integer.parseInt(br.readLine());

        Prime.checkPrime(num1);
        Prime.checkPrime(num1, num2);
        Prime.checkPrime(num1, num2, num3);
        Prime.checkPrime(num1, num2, num3, num4, num5);
    }
}