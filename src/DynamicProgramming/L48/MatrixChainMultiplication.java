package DynamicProgramming.L48;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static int minOperations(int[] nums, int[] min, int i, int j){
        if(i==j){
            return 0;
        }
        for(int k=i; k<j; k++){
            int steps=(nums[i-1]*nums[k]*nums[j])
                +(minOperations(nums, min, i, k)+minOperations(nums, min, k+1, j));

            min[0]=Math.min(min[0], steps);
        }
        return min[0];
    }

    // Memoization
    public static int minOperations1(int[] nums, int[][] dp, int[] min, int i, int j){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        for(int k=i; k<j; k++){
            int steps=(nums[i-1]*nums[k]*nums[j])
                +(minOperations1(nums, dp, min, i, k)+minOperations1(nums, dp, min, k+1, j));

            min[0]=Math.min(min[0], steps);
        }
        return min[0];
    }

    public static void main(String[] args) {
        int[] nums=new int[]{10, 20, 30, 40, 50};
        int[] min=new int[]{Integer.MAX_VALUE};
        
        System.out.println(minOperations(nums, min, 1, nums.length-1));
        
        int[][] dp=new int[nums.length][nums.length];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(minOperations1(nums, dp, min, 1, nums.length-1));
    }
}
