package DynamicProgramming.L41;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lis(int[] nums, int ind, int prevInd){
        if(ind>=nums.length){
            return 0;
        }
        int pick=0, notPick=0;
        if(prevInd==-1 || nums[ind]>=nums[prevInd]){
            pick=1+lis(nums, ind+1, ind);
        }
        notPick=lis(nums, ind+1, prevInd);
        return Math.max(pick, notPick);
    }

    // Memoization
    public static int lis1(int[][] dp, int[] nums, int ind, int prevInd){
        if(ind>=nums.length){
            return 0;
        }
        if(dp[ind][prevInd+1]!=-1){
            return dp[ind][prevInd];
        }
        int pick=0, notPick=0;
        if(prevInd==-1 || nums[ind]>=nums[prevInd]){
            pick=1+lis(nums, ind+1, ind);
        }
        notPick=lis(nums, ind+1, prevInd);
        return dp[ind][prevInd+1]=Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        int[] nums=new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lis(nums, 0, -1));

        int[][] dp=new int[nums.length][nums.length+1];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(lis1(dp, nums, 0, -1));
    }
}
