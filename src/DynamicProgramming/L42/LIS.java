package DynamicProgramming.L42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LIS {
    // tabulation
    public static int lis(int[] nums){
        int[][] dp=new int[nums.length+1][nums.length+1];
        for(int ind=nums.length-1; ind>=0; ind--){
            // for(int prevInd=-1; prevInd<ind; prevInd++){
            for(int prevInd=ind-1; prevInd>=-1; prevInd--){
                int pick=0, notPick=0;
                if(prevInd==-1 || nums[ind]>=nums[prevInd]){
                    pick=1+dp[ind+1][ind+1];
                }
                notPick=dp[ind+1][prevInd+1];
                dp[ind][prevInd+1]=Math.max(pick, notPick);
            }
        }
        return dp[0][0];
    }

    // space optimization
    public static int lis1(int[] nums){
        int[] prev=new int[nums.length+1];
        int[] curr=new int[nums.length+1];
        for(int ind=nums.length-1; ind>=0; ind--){
            // for(int prevInd=-1; prevInd<ind; prevInd++){
            for(int prevInd=ind-1; prevInd>=-1; prevInd--){
                int pick=0, notPick=0;
                if(prevInd==-1 || nums[ind]>=nums[prevInd]){
                    pick=1+prev[ind+1];
                }
                notPick=prev[prevInd+1];
                curr[prevInd+1]=Math.max(pick, notPick);
            }
            prev=curr;
        }
        return prev[0];
    }

    public static int lis2(int[] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp, 1);
        int max=1;
        for(int ind=0; ind<nums.length; ind++){
            for(int prevInd=0; prevInd<ind; prevInd++){
                if(nums[ind]>=nums[prevInd]){
                    dp[ind]=Math.max(dp[ind], dp[prevInd]+1);
                }
            }
            max=Math.max(max, dp[ind]);
        }
        return max;
    }

    // print LIS
    public static int printLIS(int[] nums){
        int[] dp=new int[nums.length];
        int[] hash=new int[nums.length];
        Arrays.fill(dp, 1);
        int max=1, lastIndex=0;
        for(int ind=0; ind<nums.length; ind++){
            hash[ind]=ind;
            for(int prevInd=0; prevInd<ind; prevInd++){
                if(nums[ind]>=nums[prevInd] && dp[prevInd]+1>dp[ind]){
                    dp[ind]=dp[prevInd]+1;
                    hash[ind]=prevInd;
                }
            }
            if(dp[ind]>max){
                max=dp[ind];
                lastIndex=ind;
            }
        }
        List<Integer> lis=new ArrayList<>();
        lis.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            lis.add(nums[lastIndex]);
        }
        Collections.reverse(lis);
        System.out.println(lis);
        return max;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lis(nums));

        System.out.println(lis1(nums));

        System.out.println(lis2(nums));

        System.out.println(printLIS(nums));
    }
}
