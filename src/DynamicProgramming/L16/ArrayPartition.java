package DynamicProgramming.L16;

import java.util.Arrays;

public class ArrayPartition {
    public static int partition(int[] nums){
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        boolean[][] dp=new boolean[nums.length][sum+1];
        for(int i=0; i<nums.length; i++){
            dp[i][0]=true;
        }
        if(nums[0]<=sum){
            dp[0][nums[0]]=true;
        }
        for(int i=1; i<nums.length; i++){
            for(int target=1; target<=sum; target++){
                boolean take=false;
                if(nums[i]<=target){
                    take=dp[i-1][target-nums[i]];
                }
                boolean notTake=dp[i-1][target];
                dp[i][target]=take||notTake;
            }
        }
        System.out.println(Arrays.toString(dp[nums.length-1]));

        int min=Integer.MAX_VALUE;
        for(int i=0; i<=sum/2; i++){
            if(dp[nums.length-1][i]==true){
                int s1=i;
                int s2=sum-i;
                min=Math.min(min, Math.abs(s2-s1));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2, 3, 7}; // 2, 3, 7  -36,36
        System.out.println(partition(nums));
    }
}
