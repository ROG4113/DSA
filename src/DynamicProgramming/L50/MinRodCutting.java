package DynamicProgramming.L50;

import java.util.Arrays;

// Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:
// Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
// You should perform the cuts in order, you can change the order of the cuts as you wish.
// The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick,
// it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut).
// Return the minimum total cost of the cuts.

public class MinRodCutting {
    // Recursion
    public static int cut(int[] cuts,int i, int j){
        if(i>j){
            return 0;
        }
        int cost=Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            int cut=(cuts[j+1]-cuts[i-1])+(cut(cuts, i, k-1)+cut(cuts, k+1, j));
            cost=Math.min(cost, cut);
        }
        return cost;
    }

    // Memoization
    public static int cut1(int[][] dp, int[] cuts,int i, int j){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int cost=Integer.MAX_VALUE;
        for(int k=i; k<=j; k++){
            int cut=(cuts[j+1]-cuts[i-1])+(cut1(dp, cuts, i, k-1)+cut1(dp, cuts, k+1, j));
            cost=Math.min(cost, cut);
        }
        return dp[i][j]=cost;
    }
    
    // Tabulation
    public static int cut2(int[] cuts, int n){
        int[] nums=new int[cuts.length+2];
        nums[0]=0;
        nums[nums.length-1]=n;
        for(int i=0; i<cuts.length; i++){
            nums[i+1]=cuts[i];
        }
        Arrays.sort(nums);
        int[][] dp=new int[cuts.length+2][cuts.length+2];
        for(int i=cuts.length; i>=1; i--){
            for(int j=1; j<=cuts.length; j++){
                if(i>j){
                    continue;
                }
                int cost=Integer.MAX_VALUE;
                for(int k=i; k<=j; k++){
                    int cut=(nums[j+1]-nums[i-1])+(dp[i][k-1]+dp[k+1][j]);
                    cost=Math.min(cost, cut);
                }
                dp[i][j]=cost;
            }
        }
        return dp[1][cuts.length];
    }
    public static void main(String[] args) {
        int[] cuts=new int[]{1, 3, 4, 5};
        int n=7;
        int[] nums=new int[cuts.length+2];
        nums[0]=0;
        nums[nums.length-1]=n;
        for(int i=0; i<cuts.length; i++){
            nums[i+1]=cuts[i];
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(cut(nums, 1, nums.length-2));

        int[][] dp=new int[cuts.length+1][cuts.length+1];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(cut1(dp, nums, 1, nums.length-2));

        System.out.println(cut2(cuts, n));
    }

}
