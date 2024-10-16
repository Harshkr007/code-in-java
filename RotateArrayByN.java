/*
 * This program rotates an integer array by a specified number of positions. It reads the array size and elements from user input, then uses a three-step reversal technique to efficiently perform the rotation, outputting the modified array after the operation. The solution runs in O(n) time complexity
 */

 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArrayByN {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter the size of arrays: ");
            int size = Integer.parseInt(br.readLine());

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

            System.out.println("Enter the value to which array should rotate:");

            int rotate = Integer.parseInt(br.readLine().trim());

            if (size <= 1) {
                System.out.println("Rotated array is : " + arr[0]);
                return;
            }

            Solution sol = new Solution();
            sol.rotateArray(arr, rotate);
            System.out.print("Elemnts of the array after rotate:  " );
            for(int ele : arr){
                System.out.print(ele+" ");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

class Solution {
    public int[] rotateArray(int[] arr, int rotate) {
        int n = arr.length;
        rotate %= n;
        
        if (rotate == 0) {
            return arr;
        }
        
        reverse(arr, 0, n - 1);
        reverse(arr, 0, rotate - 1);
        reverse(arr, rotate, n - 1);
        
        return arr;
    }
    
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
