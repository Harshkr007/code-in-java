//this code is used to ratoate the array elemnts by 1 position;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateArrayByOne {
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

            if (size <= 1) {
                System.out.println("Rotated array is : " + arr[0]);
                return;
            }

            Solution sol = new Solution();
            sol.rotate(arr);
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
    public void rotate(int[] arr) {
        int n = arr.length;

        int temp = arr[0];
        arr[0] = arr[n - 1];

        int i = 1;
        while (i < n) {
            // swap
            arr[i] = arr[i] ^ temp;
            temp = arr[i] ^ temp;
            arr[i] = arr[i] ^ temp;

            i++;
        }
        return;
    }

}
