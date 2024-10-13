import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveNegativeElementsToEnd {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the size of arrays: ");
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];

        System.out.println("Enter the elements in array separated by space:");
        String[] num = br.readLine().trim().split("\\s+");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }

        Solution5 sol = new Solution5();

        sol.segregateElements(arr);

        System.out.println("Elements after the modification:");

        for(int number : arr){
            System.out.print(number+" ");
        }
    }
}
class Solution5 {
    public void segregateElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        
        int idx = 0; // Start from the beginning of 'ans' for positive numbers

        // First, add all positive elements
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                ans[idx++] = arr[i];
            }
        }

        // Then, add all negative elements
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                ans[idx++] = arr[i];
            }
        }

        // Copy elements from 'ans' back to 'arr'
        for (int i = 0; i < n; i++) {
            arr[i] = ans[i];
        }
    }
}