package DynamicProgramming.L5;

import java.util.Arrays;

public class HouseRobber {

    // memoization TC->O(2^n) SC->O(n)+O(n)
    public static int dp(int[] arr, int n){
        if(n==0){
            return arr[n];
        }
        if(n<0){
            return 0;
        }
        int pick=arr[n]+dp(arr, n-2);
        int notPick=0+dp(arr, n-1);
        return Integer.max(pick, notPick);
    }

    // memoization TC->O(n) SC->O(n)+O(n)
    public static int dp1(int[] arr, int[]dp, int n){
        if(n==0){
            return arr[n];
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int pick=arr[n]+dp1(arr, dp, n-2);
        int notPick=0+dp1(arr, dp, n-1);
        return dp[n]=Integer.max(pick, notPick);
    }

    // tabulation TC->O(n) SC->O(1)
    public static int dp2(int[] arr, int[] dp, int n){
        dp[0]=arr[n];
        for(int i=1; i<=n; i++){
            int take=arr[i];
            if(i>1) take+=dp[i-2];
            int notTake=dp[i-1];
            dp[i]=Math.max(take, notTake);
        }
        return dp[n];
    }
    // tabulation(space optimized) TC->O(n) SC->O(1)
    public static int dp3(int[] arr, int n){
        int prev=arr[0];
        int prev2=0;
        for(int i=1; i<=n; i++){
            int take=arr[i];
            if(i>1) take+=prev2;
            int notTake=prev;
            prev2=prev;
            prev=Math.max(take, notTake);
        }
        return prev;
    }

    public static void main(String[] args){
        int n=4;
        int[] arr=new int[]{1, 2, 3, 1};
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        // int ans=dp(arr, n-1);
        // int ans=dp1(arr, dp, n-1);
        // int ans=dp2(arr, dp, n-1);
        int ans=dp3(arr, n-1);
        System.out.println(ans);
    }
}
