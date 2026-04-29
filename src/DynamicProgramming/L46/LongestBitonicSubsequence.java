package DynamicProgramming.L46;

import java.util.Arrays;

// Given an array arr of n integers, the task is to find the length of the longest bitonic sequence.
// A sequence is considered bitonic if it first increases, then decreases. The sequence does not have to be contiguous.

public class LongestBitonicSubsequence {
    public static int lbs(int[] nums){
        // two LIS one ffrom front one from back dp1[i]+dp2[i]-1, -1 because middle one will be common
        int[] dp1=new int[nums.length];
        Arrays.fill(dp1, 1);
        for(int ind=0; ind<nums.length; ind++){
            for(int prevInd=0; prevInd<ind; prevInd++){
                if(nums[prevInd]<nums[ind] && dp1[ind]<dp1[prevInd]+1){
                    dp1[ind]=dp1[prevInd]+1;
                }
            }
        }
        // from back
        int[] dp2=new int[nums.length];
        Arrays.fill(dp2, 1);
        for(int ind=nums.length-1; ind>=0; ind--){
            for(int prevInd=nums.length-1; prevInd>ind; prevInd--){
                if(nums[prevInd]<nums[ind] && dp2[ind]<dp2[prevInd]+1){
                    dp2[ind]=dp2[prevInd]+1;
                }
            }
        }

        int max=1;
        for(int i=0; i<nums.length; i++){
            max=Math.max(max, dp1[i]+dp2[i]-1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{5, 1, 4, 2, 3, 6, 8, 7};
        System.out.println(lbs(nums));
    }
}
