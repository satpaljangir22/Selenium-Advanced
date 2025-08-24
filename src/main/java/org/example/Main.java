package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
            //reverseString("Satpal");
        secondLargestInArray(new int[]{ -3, -3, -3 });
    }

    public static void reverseString(String input){
         int length = input.length();
         char[] chars = input.toCharArray();
         StringBuilder reverse = new StringBuilder();
         for(int i = length-1; i>=0; i--){
             reverse.append(chars[i]);
         }
         System.out.println(reverse);
    }

    public static void secondLargestInArray(int[] intArray) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int j : intArray) {
            if (j > largest) {
                secondLargest = largest;
                largest = j;
            }
            else if (j > secondLargest && j < largest){
                secondLargest = j;
            }
        }
        if (secondLargest == Integer.MIN_VALUE){
            System.out.println("All the numbers might be same...");
        }
        else {
            System.out.print("Second largest number is: " + secondLargest);
        }
    }
}