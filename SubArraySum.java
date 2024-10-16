/*
    This program identifies a continuous subarray within a given array whose elements sum up to a specified target. It reads the array size and elements from user input and utilizes an optimized sliding window approach to find the subarray. If the sum is found, the program prints the subarray, else it indicates that no such sum exists.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SubArraySum {
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

        System.out.println("Enter the sum needs to search for:");
        int sum = Integer.parseInt(br.readLine());

        Solution sol = new Solution();

        ArrayList<Integer> list = sol.subarraySum(arr,size,sum);

        if(list.get(0) == -1){System.out.println("The sum is not available");}else{
            System.out.println("The Elements in sequence is:");
            for (int i = list.get(0)-1; i < list.get(1); i++) {
                System.out.print(arr[i]+" ");
            }
        }
    }
}
class Solution {
    public  ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int max = 0, start = 0;
        
        for(int i=0; i<arr.length; i++){
         max = max + arr[i];
         
         if(max == s){
             res.add(start+1);//add starting point
             res.add(i+1);   //add ending point
             break;
         }
         else if(max > s){
             while(max>s){
                 max = max - arr[start];
                 start++;
             }
             if(max == s && i>=start){
                res.add(start+1); //add starting point
                res.add(i+1);    //add ending point
                break;
             }
         }
        }
        
        if(res.size() == 0)
            res.add(-1);  // sum not found
        
        return res;
    }
}
