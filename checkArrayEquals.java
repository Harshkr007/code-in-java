//this a java code which can be used to check if two given arrays are equals or not based on  the values in the array 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class checkArrayEquals {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the size of arrays: ");
        int size = Integer.parseInt(br.readLine());

        int[] arr1 = new int[size];
        int[] arr2 = new int[size];

        System.out.println("Enter the elements in 1st array separated by space:");
        String[] num1 = br.readLine().trim().split("\\s+");
        for (int i = 0; i < size; i++) {
            arr1[i] = Integer.parseInt(num1[i]);
        }

        System.out.println("Enter the elements in 2nd array separated by space:");
        String[] num2 = br.readLine().trim().split("\\s+");
        for (int i = 0; i < size; i++) {
            arr2[i] = Integer.parseInt(num2[i]);
        }

        Solution sol = new Solution();

        System.out.println(sol.checkArray(arr1, arr2) ? "Yes, both arrays are equal" : "No, both arrays are not equal");
    }
}

class Solution {
    public boolean checkArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : arr2) {
            int count = map.getOrDefault(num, 0);
            if (count == 0) {
                return false;
            } else {
                map.put(num, count - 1);
            }
        }
        return true;
    }
}