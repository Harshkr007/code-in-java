/*
  *This algorithm replaces every element in an array with the greatest element found to its right side. It starts from the end of the array, keeping track of the maximum value seen so far. As it moves left, it updates elements accordingly, ensuring efficient transformation.
 */


import java.util.*;
public class GreaterOnRightSide {
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

        ArrayList<Integer> list  = sol.nextGreatest(arr);

        System.out.print("Elements after modifications :");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }

        sc.close();
    }
}
class Solution {
    public  ArrayList<Integer> nextGreatest(int arr[]) {
        // code here
        int n = arr.length;
        int maxVal = -1;  
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
           
            list.add(0, maxVal);

           
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        return list;
       
    }
}
