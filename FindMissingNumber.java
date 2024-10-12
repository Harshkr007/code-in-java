//this code is used to find the missing number in the array of number 1 to n

import java.util.Scanner;

public class FindMissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size n (the range is from 1 to n)
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        // Initialize the array with size n-1
        int[] arr = new int[n - 1];

        // Input the array elements
        System.out.print("Enter the values of array separated by space: ");
        sc.nextLine();  // Consume the newline character left by nextInt()
        String[] num = sc.nextLine().trim().split(" ");

        // Fill the array
        for (int i = 0; i < num.length; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }

        // Close the scanner
        sc.close();

        // Find and print the missing number
        Solution sol = new Solution();
        System.out.println("The missing number is: " + sol.missingNumber(n, arr));
    }
}

class Solution {
    public int missingNumber(int n, int[] arr) {
        // Sum of all numbers from 1 to n
        int sum = (n * (n + 1)) / 2;

        // Sum of existing elements in the array
        int sumExist = 0;
        for (int num : arr) {
            sumExist += num;
        }

        // The missing number is the difference
        return sum - sumExist;
    }
}
