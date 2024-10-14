//this alogrithm is designed to find the total fine colleded on some specific date based on the date is even or odd

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculateFine {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the size of arrays: ");
        int size = Integer.parseInt(br.readLine());

        int[] car = new int[size];
        int[] fine = new int[size];
        int date;

        System.out.println("Enter the car no.  separated by space:");
        String[] num = br.readLine().trim().split("\\s+");
        for (int i = 0; i < size; i++) {
            car[i] = Integer.parseInt(num[i]);
        }

        System.out.println("Enter the fine on cars separated by space:");
         num = br.readLine().trim().split("\\s+");
        for (int i = 0; i < size; i++) {
            fine[i] = Integer.parseInt(num[i]);
        }

        System.out.println("Enter the date: ");
        date = Integer.parseInt(br.readLine());

        Solution sol = new Solution();
        
        System.out.println("Total fine collected on " +date+ " is : "+sol.totalFine(size,date,car,fine));
    }
}
class Solution {
    
    public int totalFine( int n, int date, int car[], int fine[])
    {
        int oddEven = date%2;
        int sum = 0;
        for(int i = 0;i < n;i++){
            int oddEvenTemp = car[i]%2;
            if( oddEvenTemp != oddEven )sum += fine[i];
        }
        return sum;
    }
}
