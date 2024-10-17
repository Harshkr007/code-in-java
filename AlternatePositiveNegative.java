/*
 * This program rearranges an array such that positive and negative numbers appear in alternating positions while preserving their original order. If either positive or negative numbers run out, the remaining elements are appended. It uses two auxiliary lists to separate positives and negatives, ensuring an efficient rearrangement in O(n) time complexity.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AlternatePositiveNegative {
   public static void main(String[] args)throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Enter the elements in array separated by space:");
        String[] num = br.readLine().trim().split("\\s+");
        for (int i = 0; i < num.length; i++) {
           list.add(Integer.parseInt(num[i]));
        }

        Solution1 sol = new Solution1();
        sol.rearrange(list);

        System.out.println("Elemnts after modification: ");
        for(int val : list){
            System.out.print(val+" ");
        }
   } 
}
class Solution1 {
    void rearrange(ArrayList<Integer> arr) { 
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        
        for(int num : arr){
            if(num >= 0)positive.add(num);
            else negative.add(num);
        }
        
        int i = 0, p = 0, n = 0;
        int posSize = positive.size(), negSize = negative.size();
        while(p < posSize && n < negSize){
            arr.set(i++,positive.get(p++));
            arr.set(i++,negative.get(n++));
        }
        
        while(p < posSize){
               arr.set(i++,positive.get(p++));
        }
        
        while(n < negSize){
               arr.set(i++,negative.get(n++));
        }
     }
}
