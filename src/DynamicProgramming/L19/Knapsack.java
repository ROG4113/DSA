package DynamicProgramming.L19;

import java.util.Arrays;

public class Knapsack {
    // Recursion TC-> O(2^N) SC-> O(N)
    public static int max(int[] val, int[] wt, int ind, int w){
        if(ind==0){
            if(wt[0]<=w){
                return val[0];
            }
            else{
                return 0;
            }
        }
        int pick=0;
        if(wt[ind]<=w){
            pick=val[ind]+max(val, wt, ind-1, w-wt[ind]);
        }
        int notPick=max(val, wt, ind-1, w);
        return Math.max(pick, notPick);
    }

    // Memoization TC-> O(N) SC-> O(N)+O(N*W)
    public static int max1(int[] val, int[] wt, int[][] dp, int ind, int w){
        if(ind==0){
            if(wt[0]<=w){
                return val[0];
            }
            else{
                return 0;
            }
        }
        if(dp[ind][w]!=-1){
            return dp[ind][w];
        }
        int pick=Integer.MIN_VALUE;
        if(wt[ind]<=w){
            pick=max1(val, wt, dp, ind-1, w-wt[ind]);
        }
        int notPick=max1(val, wt, dp, ind-1, w);
        return dp[ind][w]=Math.max(pick, notPick);
    }

    // Tabulation TC-> O(N*W) SC->O(N*W)
    public static int max2(int[] val, int[] wt, int w){
        int[][] dp=new int[val.length][w+1];
        // base cases
        // if(ind==0){
        //     if(wt[0]<=w){
        //         return val[0];
        //     }
        //     else{
        //         return 0;
        //     }
        // }
        for(int i=wt[0]; i<=w; i++){
            dp[0][i]=val[0];
        }
        for(int ind=1; ind<val.length; ind++){
            for(int weight=0; weight<=w; weight++){
                int pick=Integer.MIN_VALUE;
                if(wt[ind]<=weight){
                    pick=val[ind]+dp[ind-1][weight-wt[ind]];
                }
                int notPick=dp[ind-1][weight];
                dp[ind][weight]=Math.max(pick, notPick);
            }
        }
        return dp[val.length-1][w];
    }

    // Space optimization TC-> O(N*W) SC->O(W)
    public static int max3(int[] val, int[] wt, int w){
        int[] prev=new int[w+1];
        int[] curr=new int[w+1];
        for(int i=wt[0]; i<=w; i++){
            prev[i]=val[0];
        }
        for(int ind=1; ind<val.length; ind++){
            for(int weight=0; weight<=w; weight++){
                int pick=Integer.MIN_VALUE;
                if(wt[ind]<=weight){
                    pick=val[ind]+prev[weight-wt[ind]];
                }
                int notPick=prev[weight];
                curr[weight]=Math.max(pick, notPick);
            }
            prev=curr;
        }
        return prev[w];
    }

    // Space optimization(single row)
    // when filling the curr we are always using left of the prev i.e. prev[weight-wt[ind]] which is first half of prev array,
    // we can take advantage of that and start filling curr from right(w-1) also. If we can fill the curr from right also why don't
    // fill(actually update) the prev array itself from right as we are only using left half of prev and get rid of curr totally
    public static int max4(int[] val, int[] wt, int w){
        int[] prev=new int[w+1];
        for(int i=wt[0]; i<=w; i++){
            prev[i]=val[0];
        }
        for(int ind=1; ind<val.length; ind++){
            for(int weight=w; weight>=1; weight--){
                int pick=Integer.MIN_VALUE;
                if(wt[ind]<=weight){
                    pick=val[ind]+prev[weight-wt[ind]];
                }
                int notPick=prev[weight];
                prev[weight]=Math.max(pick, notPick);
            }
        }
        return prev[w];
    }

    public static void main(String[] args) {
        int[] val=new int[]{30, 40, 60};
        int[] wt=new int[]{3, 2, 5};
        int ind=val.length-1;
        int w=5;
        System.out.println(max(val, wt, ind, w));
        int[][] dp=new int[val.length][w+1];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(max1(val, wt, dp, ind, w));
        System.out.println(max2(val, wt, w));
        System.out.println(max3(val, wt, w));
        System.out.println(max4(val, wt, w));
    }
}
