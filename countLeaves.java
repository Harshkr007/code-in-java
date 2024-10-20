import java.util.Scanner;

public class countLeaves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size n (the range is from 1 to n)
        System.out.print("Enter the number of frogs: ");
        int n = sc.nextInt();

        // Initialize the array with size n-1
        int[] frogs = new int[n];

        // Input the array elements
        System.out.println("Enter the jump strength of frogs separated by space: ");
        sc.nextLine();  // Consume the newline character left by nextInt()
        String[] num = sc.nextLine().trim().split(" ");

        // Fill the array
        for (int i = 0; i < frogs.length; i++) {
            frogs[i] = Integer.parseInt(num[i]);
        }

        System.out.println("Enter the number of leaves exist:");
        int leaves = sc.nextInt();

        Solution sol = new Solution();

        int unvisitedLeaves = sol. unvisitedLeaves(n,leaves,frogs) ;
        System.out.println("the count of unvisited leaves are: "+unvisitedLeaves);
        sc.close();

    }
}
class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        boolean[] leaf = new boolean[leaves + 1];
         
        for(int i = 0; i < N ; i++){
           
           if(frogs[i] == 1)return 0;
           int jump = frogs[i];
           
           if(jump <= leaves && !leaf[jump]){
               while(jump <= leaves){
                   leaf[jump] = true;
                   jump += frogs[i];
               }
           }
        }
        int count = 0;
        for(int j = 1; j < leaf.length; j++){
            if(leaf[j] == false)count++;
        }
        return count;
    }
}

