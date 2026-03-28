package DynamicProgramming.L15;

import java.util.Arrays;

public class EqualPartitionSum {
    // recursion
    public static boolean sum(int[] arr, int ind, int sum,  int target){
        if(sum==target){
            return true;
        }
        if(ind==arr.length){
            return false;
        }
        boolean pick=sum(arr, ind+1, sum+arr[ind], target);
        boolean notPick=sum(arr, ind+1, sum, target);
        return pick || notPick;
    }

    // recursion
    public static boolean sum1(int[] arr, int ind, int target){
        if(target==0){
            return true;
        }
        if(ind==0){
            return arr[0]==target?true:false;
        }
        boolean pick=false;
        if(arr[ind]<=target){
            pick=sum1(arr, ind-1, target-arr[ind]);
        }
        boolean notPick=sum1(arr, ind-1, target);
        return pick || notPick;
    }

    // memoization TC-> O(n*target) SC-> O(n*target)+O(n)
    public static boolean sum2(int[][] dp, int[] arr, int ind, int target){
        if(target==0){
            return true;
        }
        if(ind==0){
            return arr[0]==target?true:false;
        }
        if(dp[ind][target]!=-1){
            return dp[ind][target]==1?true:false;
        }
        boolean pick=false;
        if(arr[ind]<=target){
            pick=sum1(arr, ind-1, target-arr[ind]);
        }
        boolean notPick=sum1(arr, ind-1, target);
        if(pick || notPick){
            dp[ind][target]=1;
        }else{
            dp[ind][target]=0;
        }
        return (pick || notPick);
    }

    // tabulation TC-> O(n*target) SC-> O(n*target)
    public static boolean sum3(int[] arr){
        int t=0;
        for(int i=0; i<arr.length; i++){
            t+=arr[i];
        }
        if(t%2!=0){
            return false;
        }
        t=t/2;
        boolean[][] dp=new boolean[arr.length][t+1];
        for(int i=0; i<arr.length; i++){
            dp[i][0]=true;
        }
        dp[0][arr[0]]=true;
        for(int ind=1; ind<arr.length; ind++){
            for(int target=1; target<=t; target++){
                boolean pick=false;
                if(arr[ind]<=target){
                    pick=dp[ind-1][target-arr[ind]];
                }
                boolean notPick=dp[ind-1][target];
                dp[ind][target]=pick || notPick;
            }
        }
        return  dp[arr.length-1][t];
    }

    // space optimization TC-> O(n*target) SC-> O(target)
    public static boolean sum4(int[] arr){
        int t=0;
        for(int i=0; i<arr.length; i++){
            t+=arr[i];
        }
        if(t%2!=0){
            return false;
        }
        t=t/2;
        boolean[] prev=new boolean[t+1];
        prev[0]=true;
        if(arr[0]<=t){
            prev[arr[0]]=true;
        }
        for(int ind=1; ind<arr.length; ind++){
            boolean[] cur=new boolean[t+1];
            cur[0]=true;
            for(int target=1; target<=t; target++){
                boolean pick=false;
                if(arr[ind]<=target){
                    pick=prev[target-arr[ind]];
                }
                boolean notPick=prev[target];
                cur[target]=pick || notPick;
            }
            prev=cur;
        }
        return  prev[t];
    }

    public static void main(String[] args){
        int[] arr=new int[]{2, 2, 3, 5}; // 1, 5, 11, 5
        int target=0;
        for(int i=0; i<arr.length; i++){
            target+=arr[i];
        }
        target=target/2;
        boolean ans=sum(arr, 0, 0, target);
        
        boolean ans1=sum1(arr, arr.length-1, target);

        int[][] dp=new int[arr.length][target+1];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        boolean ans2=sum2(dp, arr, arr.length-1, target);
        
        boolean ans3=sum3(arr);

        boolean ans4=sum4(arr);
        
        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);
    }
}
