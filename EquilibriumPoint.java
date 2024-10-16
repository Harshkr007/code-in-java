/*
    *This program identifies the equilibrium point in an array, where the sum of elements to the left equals the sum of elements to the right. It reads the array size and elements from user input, then uses an optimized approach to find the equilibrium point. If found, the program displays elements before and after it; otherwise, it indicates no such point exists.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EquilibriumPoint {
    public static void main(String[] args)throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the size of arrays: ");
        int size = Integer.parseInt(br.readLine());

        long[] arr = new long[size];

        System.out.println("Enter the elements in array separated by space:");
        String[] num = br.readLine().trim().split("\\s+");
        for (int i = 0; i < size; i++) {
            arr[i] = Long.parseLong(num[i]);
        }

        Solution2 sol = new Solution2();
        int idx = sol.equilibriumPoint(arr);

        if(idx == -1){
            System.out.println("No Equilibrium point exist");
        }else{
            System.out.print("Elemnts before equilibriumPoint:  ");
            for (int i = 0; i < idx; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            System.out.print("Elemnts after the equilibriumPoint:  ");
            for (int i = idx; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
        }
    }
}
class Solution2 {
    public int equilibriumPoint(long arr[]) {
        int n = arr.length;
        
        if(n == 1)return 1;
        
        long bigSum = 0;
        
        for(int i = 0; i < n ; i++){
            bigSum += arr[i];
        }
        
        long currSum = 0;
        
        for(int j = 0; j < n;j++){
            if(currSum == (bigSum - arr[j]-currSum))return j+1;
            currSum += arr[j];
        }
        return -1;
    }
}

