/*
 * This program finds the missing element in an arithmetic progression (AP) sequence. It uses binary search to efficiently locate the missing value. The sequence must contain at least two numbers. If the missing element is identified, it is printed; otherwise, it notifies the user that the sequence is either complete or invalid.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetMissingAPElement {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the size of array: ");
            int size = Integer.parseInt(br.readLine().trim());

            if (size < 2) {
                System.out.println("Array size should be at least 2.");
                return;
            }

            int[] arr = new int[size];

            System.out.println("Enter the elements in array separated by space:");
            String[] num = br.readLine().trim().split("\\s+");
            
            if (num.length != size) {
                System.out.println("Number of elements doesn't match the specified size.");
                return;
            }

            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(num[i]);
            }

            Solution sol = new Solution();
            int missingElement = sol.findMissing(arr);
            
            if (missingElement != -1) {
                System.out.println("The missing element is: " + missingElement);
            } else {
                System.out.println("No missing element found or invalid AP sequence.");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

class Solution {
    int findMissing(int[] arr) {
        int n = arr.length;
        if (n < 2) return -1;

        int d = (arr[n-1] - arr[0]) / n;
        if (d == 0) return -1; // All elements are the same

        int st = 0;
        int end = n - 1;

        while (st < end) {
            int mid = st + (end - st) / 2;
            int valAtMid = arr[0] + d * mid;

            if (arr[mid] == valAtMid) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }

        int expectedValue = arr[0] + d * st;
        return (arr[st] != expectedValue) ? expectedValue : -1;
    }
}
