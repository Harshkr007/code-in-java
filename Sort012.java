/*
    *This program sorts an array consisting of only 0s, 1s, and 2s using the Dutch National Flag algorithm. It efficiently rearranges the elements in a single pass with three pointers: one for 0s, one for 1s, and another for 2s. The result is a sorted array printed to the console.
 */

 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort012 {
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

        Solution sol = new Solution();
        sol.sort012(arr);

        System.out.println("Elements after the sorting:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }    
    }
}
class Solution {
  
    public void sort012(int[] arr) {
        int n = arr.length;
        int zeroIdx = 0; 
        int oneIdx = 0; 
        int twoIdx = n - 1; 

       
        while (oneIdx <= twoIdx) {
            if (arr[oneIdx] == 0) {
               
                swap(arr, zeroIdx, oneIdx);
                zeroIdx++;
                oneIdx++;
            } else if (arr[oneIdx] == 1) {
                oneIdx++;
            } else { 
                swap(arr, oneIdx, twoIdx);
                twoIdx--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
