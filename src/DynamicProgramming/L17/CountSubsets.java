package DynamicProgramming.L17;

import java.util.Arrays;

public class CountSubsets {
    // recursion TC-> O(2^n) SC-> O(n)
    public static int count(int[] arr, int ind, int sum){
        if(sum==0){
            return 1;
        }
        if(ind==0){
            if(arr[ind]==sum){
                return 1;
            }
            else{
                return 0;
            }
        }
        int pick=0;
        pick=count(arr, ind-1, sum-arr[ind]);
        int notPick=count(arr, ind-1, sum);
        return pick+notPick;
    }

    // memoization TC-> O(n*sum) SC-> O(n*sum) + O(n)
    public static int count1(int[] arr, int ind, int sum){
        int[][] dp=new int[ind+1][sum+1];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        if(sum==0){
            return 1;
        }
        if(ind==0){
            if(arr[ind]==sum){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[ind][sum]!=-1) return dp[ind][sum];
        int pick=0;
        pick=count(arr, ind-1, sum-arr[ind]);
        int notPick=count(arr, ind-1, sum);
        return dp[ind][sum]=pick+notPick;
    }

    // tabulation TC-> O(n*sum) SC-> O(n*sum)
    public static int count2(int[] arr, int sum){
        int[][] dp=new int[arr.length][sum+1];
        for(int i=0; i<arr.length; i++){
            dp[i][0]=1;
        }
        if(arr[0]<=sum){
            dp[0][arr[0]]=1;
        }
        for(int ind=1; ind<arr.length; ind++){
            for(int target=1; target<=sum; target++){
                int pick=0;
                if(arr[ind]<=target){
                    pick=dp[ind-1][target-arr[ind]];
                }
                int notPick=dp[ind-1][target];
                dp[ind][target]=pick+notPick;
            }
        }
        return dp[arr.length-1][sum];
    }

    // space optimization TC-> O(n*sum) SC-> O(sum)
    public static int count3(int[] arr, int sum){
        int[] prev=new int[sum+1];
        prev[0]=1;
        prev[arr[0]]=1;
        for(int ind=1; ind<arr.length; ind++){
            int[] cur=new int[sum+1];
            for(int target=1; target<=sum; target++){
                int pick=0;
                if(arr[ind]<=target){
                    pick=prev[target-arr[ind]];
                }
                int notPick=prev[target];
                cur[target]=pick+notPick;
            }
            prev=cur;
        }
        return prev[sum];
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1, 3, 2};
        System.out.println(count(arr, arr.length-1, 3));
        System.out.println(count1(arr, arr.length-1, 3));
        System.out.println(count2(arr, 3));
        System.out.println(count3(arr, 3));
    }
}
