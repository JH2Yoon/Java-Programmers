// 195. Java Generics

import java.io.*;
import java.util.*;

public class Solution {

    public static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] strArray = {"Hello", "World"};

        printArray(intArray);
        printArray(strArray);
    }
}
