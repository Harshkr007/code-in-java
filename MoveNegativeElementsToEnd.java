/*
 * This program rearranges an array by moving all negative elements to the end while maintaining the order of positive elements. It reads the size and elements of the array from user input, then uses the segregateElements method to swap positive elements to the front using two pointers. Finally, it prints the modified array.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveNegativeElementsToEnd {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the size of arrays: ");
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];

        System.out.println("Enter the elements in array separated by space:");
        String[] num = br.readLine().trim().split("\\s+");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }

        Solution sol = new Solution();

        sol.segregateElements(arr);

        System.out.println("Elements after the modification:");

        for(int number : arr){
            System.out.print(number+" ");
        }
    }
}
class Solution {
    public void segregateElements(int[] arr) {
        int n = arr.length;
        int i = 0, j = 0;

        while (j < n) {
            if (arr[j] >= 0) { // Swap positive element to the correct position
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }
    }
}