import java.util.Scanner;

public class AlternateMaxMinRearrangment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size n (the range is from 1 to n)
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        // Initialize the array with size n-1
        long[] arr = new long[n];

        // Input the array elements
        System.out.print("Enter the values of array separated by space: ");
        sc.nextLine();  // Consume the newline character left by nextInt()
        String[] num = sc.nextLine().trim().split(" ");

        // Fill the array
        for (int i = 0; i < num.length; i++) {
            arr[i] = Long.parseLong(num[i]);
        }

        Solution sol = new Solution();

        sol.rearrange(arr,n);

        System.out.println("The values of Array after rearrangment: ");
        for(long val : arr){
            System.out.print(val+" ");
        }
        sc.close();

    }
}
class Solution {
    
    // Function to rearrange the array elements alternately.
    public  void rearrange(long arr[], int n) {
        
        // Handle to store both new and original values without conflict.
        long handle = arr[n - 1] + 1; // Largest element + 1
        
        int maxIdx = n - 1;  // Index for max elements
        int minIdx = 0;      // Index for min elements

        //  Modify the array to store both original and new values.
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) { //Store max element
                arr[i] += (arr[maxIdx] % handle) * handle;
                maxIdx--;
            } else { // Store min element
                arr[i] += (arr[minIdx] % handle) * handle;
                minIdx++;
            }
        }

       
        for (int i = 0; i < n; i++) {
            arr[i] /= handle;
        }
    }
}

