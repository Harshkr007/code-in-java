import java.util.Arrays;
import java.util.Scanner;

public class getTotalConsecutiveSubset {

 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size n (the range is from 1 to n)
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        // Initialize the array with size n-1
        int[] arr = new int[n];

        // Input the array elements
        System.out.print("Enter the values of array separated by space: ");
        sc.nextLine();  // Consume the newline character left by nextInt()
        String[] num = sc.nextLine().trim().split(" ");

        // Fill the array
        for (int i = 0; i < num.length; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }
        
        Solution sol = new Solution();
        int count = sol.numOfSubset(arr);
        System.out.println("the count of consecutive Subset is : "+count);

        sc.close();
    }
}
class Solution {
    public int numOfSubset(int[] arr) {
        // Your code goes here
        int n = arr.length;
        
        Arrays.sort(arr);
        int cntSeq = 0;
    
        
        for(int i = 1; i < n; i++){
            if(arr[i] != (arr[i-1] + 1))cntSeq++;
        }
        return cntSeq+1;
    }
}
