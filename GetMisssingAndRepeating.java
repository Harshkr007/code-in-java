import java.util.Scanner;

public class GetMisssingAndRepeating {
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

        int[] ans = sol.findTwoElement(arr);

        System.out.println("The repeating value is : "+ans[0]);
        System.out.println("The missing value is : "+ans[1]);

        sc.close();
    }
}
class Solution {
    int[] findTwoElement(int arr[]) {
    
        int n = arr.length;
        int[] result = new int[2];
      
      for(int i = 0; i < n; i++){
          int idx = Math.abs(arr[i]) - 1; // here we subtract one to avoid arrayOutOfBound Exception
          if(arr[idx] > 0){
              arr[idx] = - arr[idx];
          }else{
              result[0] = Math.abs(arr[i]);     //make the value positive first
          }
        }
        
        for(int j = 0; j < n; j++){
            if(arr[j] > 0){
                result[1] = j + 1;
                break;
            }
        }
         return result;
    }

}
