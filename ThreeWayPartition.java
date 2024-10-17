/*
 * This Java program performs three-way partitioning on an array. Given lower (a) and upper (b) limits, it rearranges elements into three sections: elements smaller than a, elements between a and b (inclusive), and elements greater than b. The algorithm uses three pointers to traverse and swap elements efficiently, ensuring the array is partitioned in a single pass.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeWayPartition{
    public static void main(String[] args)throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the size of arrays: ");
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];

        System.out.println("Enter the elements in array separated by space:");
        String[] num = br.readLine().trim().split("\\s+");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }

        System.out.println("Enter the lower and upper limit of partition:");
        num = br.readLine().trim().split("\\s+");
        int low = Integer.parseInt(num[0]);
        int high = Integer.parseInt(num[1]);

        Solution sol = new Solution();
        sol.threeWayPartition(arr,low,high);

        System.out.println("Elements after the modification:");
        for(int val : arr){
            System.out.print(val+" ");
        }
    }
}
class Solution {
    public void threeWayPartition(int array[], int a, int b) {
        int i = 0;                // Pointer for elements < a
        int j = 0;                // Pointer to traverse the array
        int k = array.length - 1; // Pointer for elements > b

        while (j <= k) {
            if (array[j] < a) {  // Case 1: Element < a
                swap(array, i, j);
                i++;
                j++;
            } else if (array[j] > b) {  // Case 2: Element > b
                swap(array, j, k);
                k--;
            } else {  // Case 3: Element in range [a, b]
                j++;
            }
        }
    }

    // Helper function to swap two elements in the array
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
