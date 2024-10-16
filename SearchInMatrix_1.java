/*
 * This Java program searches for a target element in a 2D matrix using an optimized binary search approach. After accepting the matrix dimensions and its elements, it employs binary search on the last column to identify the appropriate row, followed by another binary search within that row to locate the target, returning true or false accordingly.
 */

import java.util.*;

public class SearchInMatrix_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row, column;

        // Input row and column size
        System.out.print("Enter the row size: ");
        row = sc.nextInt();

        System.out.print("Enter the column size: ");
        column = sc.nextInt();
        sc.nextLine();  // Consume the leftover newline

        int[][] matrix = new int[row][column];

        // Input matrix elements row-wise
        for (int i = 0; i < row; i++) {
            System.out.println("Enter the elements of row " + (i + 1) + ":");
            String[] num = sc.nextLine().trim().split(" ");
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Integer.parseInt(num[j]);
            }
        }

        // Input target element
        System.out.print("Enter the target element: ");
        int target = sc.nextInt();

        Solution sol = new Solution();

        // Check if target exists in the matrix
        if (sol.searchMatrix(matrix, target)) {
            System.out.println("Element exists in the matrix.");
        } else {
            System.out.println("Element doesn't exist in the matrix.");
        }
        sc.close();
    }
}


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
            int rowLength = matrix.length;
            int columnLength = matrix[0].length;

            int row = -1;
            int column = columnLength - 1;

            int st = 0; 
            int end = rowLength - 1; 

            while(st < end){
                int mid = st + (end - st)/2;

                if(matrix[mid][column] == target) return true;
                else if(matrix[mid][column] > target) end = mid;
                else st = mid + 1;
            }
            row = end;

            st = 0;
            end = columnLength - 1;

            while(st <= end){
                int mid =  st + (end - st)/2;

                if(matrix[row][mid] == target)return true;
                else if(matrix[row][mid] > target)end = mid -1;
                else st = mid + 1;
            }
            return false;
    }
}
