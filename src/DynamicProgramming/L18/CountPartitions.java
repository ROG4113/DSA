package DynamicProgramming.L18;

import java.util.Arrays;

public class CountPartitions {
    public static int count(int[] arr, int ind, int target){
        if(ind==0){
            if(target==0 && arr[0]==0){
                return 2;
            }
            if(target==0 || arr[0]==target){
                return 1;
            }
            return 0;
        }
        int pick=0;
        if(arr[ind]<=target){
            pick=count(arr, ind-1, target-arr[ind]);
        }
        int notPick=count(arr, ind-1, target);
        return pick+notPick;
    }

    public static int count1(int[] arr, int[][] dp, int ind, int sum){
        if(ind==0){
            if(sum==0 && arr[0]==0){
                return 2;
            }
            if(sum==0 || arr[0]==sum){
                return 1;
            }
            return 0;
        }
        if(dp[ind][sum]!=-1) return dp[ind][sum];
        int pick=0;
        if(arr[ind]<=sum){
            pick=count1(arr, dp, ind-1, sum-arr[ind]);
        }
        int notPick=count1(arr, dp, ind-1, sum);
        return dp[ind][sum]=pick+notPick;
    }

    public static int count2(int[] arr, int target){
        int[][] dp=new int[arr.length][target+1];
        if(arr[0]==0){
            dp[0][0]=2;
        }
        else{
            dp[0][0]=1;
        }
        if(arr[0]!=0 && arr[0]<=target){
            dp[0][arr[0]]=1;
        }
        for(int i=1; i<arr.length; i++){
            for(int tar=1; tar<=target; tar++){
                int pick=0;
                if(arr[i]<=tar){
                    pick=dp[i-1][tar-arr[i]];
                }
                int notPick=dp[i-1][tar];
                dp[i][tar]=pick+notPick;
            }
        }
        return dp[arr.length-1][target];
    }

    public static int count3(int[] arr, int target){
        int[] prev=new int[target+1];
        int[] curr=new int[target+1];
        if(arr[0]==0){
            prev[0]=2;
        }
        else{
            prev[0]=1;
        }
        if(arr[0]!=0 && arr[0]<=target){
            prev[arr[0]]=1;
        }
        for(int i=1; i<arr.length; i++){
            for(int tar=1; tar<=target; tar++){
                int pick=0;
                if(arr[i]<=tar){
                    pick=prev[tar-arr[i]];
                }
                int notPick=prev[tar];
                curr[tar]=pick+notPick;
            }
            prev=curr;
        }
        return prev[target];
    }

    public static void main(String[] args) {
        int[] arr=new int[]{5, 2, 6, 4};
        int d=3;
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum=sum+arr[i];
        }
        if((sum+d<0) || (sum+d)%2!=0){
            return;
        }
        int[][] dp=new int[arr.length][sum+1];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(count(arr, arr.length-1, (sum-d)/2));
        System.out.println(count1(arr, dp, arr.length-1, (sum-d)/2));
        System.out.println(count2(arr, (sum-d)/2));
        System.out.println(count3(arr, (sum-d)/2));
    }
}
