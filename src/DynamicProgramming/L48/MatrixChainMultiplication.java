package DynamicProgramming.L48;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static int minOperations(int[] nums, int i, int j){
        if(i==j){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int steps=(nums[i-1]*nums[k]*nums[j])
                +(minOperations(nums, i, k)+minOperations(nums, k+1, j));

            min=Math.min(min, steps);
        }
        return min;
    }

    // Memoization
    public static int minOperations1(int[] nums, int[][] dp, int i, int j){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int steps=(nums[i-1]*nums[k]*nums[j])
                +(minOperations1(nums, dp, i, k)+minOperations1(nums, dp, k+1, j));

            min=Math.min(min, steps);
        }
        return dp[i][j]=min;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{10, 20, 30, 40, 50};
        
        System.out.println(minOperations(nums, 1, nums.length-1));
        
        int[][] dp=new int[nums.length][nums.length];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(minOperations1(nums, dp, 1, nums.length-1));
    }
}
