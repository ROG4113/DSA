package DynamicProgramming.L44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        int[] dp=new int[nums.length];
        int[] hash=new int[nums.length];
        int max=1, lastInd=0;
        Arrays.fill(dp, 1);
        for(int ind=0; ind<nums.length; ind++){
            hash[ind]=ind;
            for(int prevInd=0; prevInd<ind; prevInd++){
                if(nums[ind]%nums[prevInd]==0 && dp[ind]<dp[prevInd]+1){
                    dp[ind]=dp[prevInd]+1;
                    hash[ind]=prevInd;
                }
            }
            if(dp[ind]>max){
                max=dp[ind];
                lastInd=ind;
            }
        }
        list.add(nums[lastInd]);
        while(hash[lastInd]!=lastInd){
            lastInd=hash[lastInd];
            list.add(nums[lastInd]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,4,8};
        System.out.println(largestDivisibleSubset(nums));
    }
}
