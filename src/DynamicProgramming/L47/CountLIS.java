package DynamicProgramming.L47;

import java.util.Arrays;

public class CountLIS {
    public static int count(int[] nums){
        int[] dp=new int[nums.length];
        int[] count=new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max=1, cnt=0;
        for(int ind=0; ind<nums.length; ind++){
            for(int prevInd=0; prevInd<ind; prevInd++){
                if(nums[ind]>nums[prevInd] && dp[prevInd]+1>dp[ind]){
                    dp[ind]=dp[prevInd]+1;
                    count[ind]=count[prevInd];
                }
                else if(nums[ind]>nums[prevInd] && dp[prevInd]+1==dp[ind]){
                    count[ind]+=count[prevInd];
                }
            }
            max=Math.max(max, dp[ind]);
        }
        for(int i=0; i<nums.length; i++){
            if(dp[i]==max){
                cnt+=count[i];
            }
        }
        System.out.println(Arrays.toString(count) + Arrays.toString(dp));
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3};
        System.out.println(count(nums));
    }
}
