/*
    This program removes duplicate elements from a sorted array, ensuring that only unique elements remain. It reads the array size and elements from user input, stores them in a list, and uses a two-pointer approach to overwrite duplicates. The program outputs the unique elements while maintaining the original order.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UniqueArrayElement {
   public static void main(String[] args)throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the size of arrays: ");
        int size = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Enter the elements in array separated by space:");
        String[] num = br.readLine().trim().split("\\s+");
        for (int i = 0; i < size; i++) {
           list.add( Integer.parseInt(num[i]));
        }

        Solution sol = new Solution();

        int idx = sol.remove_duplicate(list);

        System.out.println("Unique Elements are:");
        for (int i = 0; i < idx; i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
class Solution {
   
    public int remove_duplicate(ArrayList<Integer> arr) {
        int n = arr.size();
        if (n <= 1) return n; 

        int idx = 0; 
        
        for (int i = 1; i < n; i++) {
            if (!arr.get(i).equals(arr.get(idx))) { 
                idx++;
                arr.set(idx, arr.get(i)); 
            }
        }
       
        return idx + 1;
    }
}

