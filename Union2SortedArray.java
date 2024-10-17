/*
 * This Java program finds the union of two sorted arrays while ensuring the result contains only unique elements. It uses two pointers to traverse both arrays simultaneously, adding elements to the result in sorted order. Duplicate values are skipped using the pushForward method, which advances the pointer past identical elements. This approach efficiently merges the arrays with a time complexity of O(n + m).
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Union2SortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // first Array
        System.out.print("Enter the size of array1: ");
        int size1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[size1];

        System.out.println("Enter the elements in 1st array separated by space:");
        String[] num = br.readLine().trim().split("\\s+");
        for (int i = 0; i < size1; i++) {
            arr1[i] = Integer.parseInt(num[i]);
        }

        // Second Array
        System.out.print("Enter the size of array2: ");
        int size2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[size2];

        System.out.println("Enter the elements in 2nd array separated by space:");
        num = br.readLine().trim().split("\\s+");
        for (int i = 0; i < size2; i++) {
            arr2[i] = Integer.parseInt(num[i]);
        }

        Solution sol = new Solution();
        ArrayList<Integer> list = sol.findUnion(arr1, arr2, size1, size2);

        System.out.println("Unique Elemnts in sorted order: ");
        for (int val : list) {
            System.out.print(val + " ");
        }

    }
}

class Solution {
    // Function to return a list containing the union of the two arrays.
    public ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        int idx1 = 0, idx2 = 0;

        // Traverse both arrays simultaneously
        while (idx1 < n && idx2 < m) {
            // If both elements are the same, add it to the list
            if (arr1[idx1] == arr2[idx2]) {
                list.add(arr1[idx1]);
                idx1 = pushForward(arr1, idx1);
                idx2 = pushForward(arr2, idx2);
            }
            // If element in arr1 is smaller, add it and move forward
            else if (arr1[idx1] < arr2[idx2]) {
                list.add(arr1[idx1]);
                idx1 = pushForward(arr1, idx1);
            }
            // If element in arr2 is smaller, add it and move forward
            else {

                list.add(arr2[idx2]);
                idx2 = pushForward(arr2, idx2);
            }
        }

        // Add remaining elements from arr1 (if any)
        while (idx1 < n) {

            list.add(arr1[idx1]);
            idx1 = pushForward(arr1, idx1);
        }

        // Add remaining elements from arr2 (if any)
        while (idx2 < m) {

            list.add(arr2[idx2]);
            idx2 = pushForward(arr2, idx2);
        }

        return list;
    }

    private static int pushForward(int[] arr, int idx) {
        int num = arr[idx];
        while (idx < arr.length && arr[idx] == num) {
            idx++;
        }
        return idx;
    }
}
