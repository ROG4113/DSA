package DynamicProgramming.L23;

import java.util.Arrays;

public class UnboundedKnapSack {
    // Recursion
    public static int knapSack(int[] val, int[] wt, int ind, int w){
        if(ind==0){
            if(wt[0]<=w){
                return ((int)w/wt[0])*val[0];
            }
            else{
                return 0;
            }
        }
        int pick=0;
        if(wt[ind]<=w){
            pick=val[ind]+knapSack(val, wt, ind, w-wt[ind]);
        }
        int notPick=knapSack(val, wt, ind-1, w);
        return Math.max(pick, notPick);
    }

    // Memoization
    public static int knapSack1(int[] val, int[] wt, int[][] dp, int ind, int w){
        if(ind==0){
            if(wt[0]<=w){
                return ((int)w/wt[0])*val[0];
            }
            else{
                return 0;
            }
        }
        if(dp[ind][w]!=-1){
            return dp[ind][w];
        }
        int pick=0;
        if(wt[ind]<=w){
            pick=val[ind]+knapSack1(val, wt, dp, ind, w-wt[ind]);
        }
        int notPick=knapSack1(val, wt, dp, ind-1, w);
        return dp[ind][w]=Math.max(pick, notPick);
    }

    // Tabulation
    public static int knapSack2(int[] val, int[] wt, int w){
        int[][] dp=new int[val.length][w+1];
        for(int i=wt[0]; i<=w; i++){
            dp[0][i]=((int)i/wt[0])*val[0];
        }
        for(int ind=1; ind<val.length; ind++){
            for(int weight=1; weight<=w; weight++){
                int pick=0;
                if(wt[ind]<=weight){
                    pick=val[ind]+dp[ind][weight-wt[ind]];
                }
                int notPick=dp[ind-1][weight];
                dp[ind][weight]=Math.max(pick, notPick);
            }
        }
        return dp[val.length-1][w];
    }

    // Space Optimization
    public static int knapSack3(int[] val, int[] wt, int w){
        int[] prev=new int[w+1];
        for(int i=wt[0]; i<=w; i++){
            prev[i]=((int)i/wt[0])*val[0];
        }
        for(int ind=1; ind<val.length; ind++){
            int[] curr=new int[w+1];
            for(int weight=1; weight<=w; weight++){
                int pick=0;
                if(wt[ind]<=weight){
                    pick=val[ind]+curr[weight-wt[ind]];
                }
                int notPick=prev[weight];
                curr[weight]=Math.max(pick, notPick);
            }
            prev=curr;
        }
        return prev[w];
    }

    // Space Optimization 1D
    public static int knapSack4(int[] val, int[] wt, int w){
        int[] prev=new int[w+1];
        for(int i=wt[0]; i<=w; i++){
            prev[i]=((int)i/wt[0])*val[0];
        }
        for(int ind=1; ind<val.length; ind++){
            for(int weight=1; weight<=w; weight++){
                int pick=0;
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
        int[] wt=new int[]{2, 4, 6};
        int[] val=new int[]{5, 11, 13};
        int w=10;
        System.out.println(knapSack(val, wt, val.length-1, w));
        int[][] dp=new int[val.length][w+1];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(knapSack1(val, wt, dp, val.length-1, w));
        System.out.println(knapSack2(val, wt, w));
        System.out.println(knapSack3(val, wt, w));
        System.out.println(knapSack4(val, wt, w));
    }
}
