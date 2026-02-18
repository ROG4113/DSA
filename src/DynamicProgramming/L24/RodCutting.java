package DynamicProgramming.L24;

import java.util.Arrays;

public class RodCutting {
    // Recursion
    public static int cut(int[] costs, int n, int ind){
        if(ind==0){
            if(n>=1){
                return n*costs[0];
            }
            else{
                return 0;
            }
        }
        int pick=0;
        if(n>=ind+1){
            pick=costs[ind]+cut(costs, n-(ind+1), ind);
        }
        int notPick=cut(costs, n, ind-1);
        return Math.max(pick, notPick);
    }

    // Memoization
    public static int cut1(int[] costs, int[][] dp, int n, int ind){
        if(ind==0){
            if(n>=1){
                return n*costs[0];
            }
            else{
                return 0;
            }
        }
        if(dp[ind][n]!=-1){
            return dp[ind][n];
        }
        int pick=0;
        if(n>=ind+1){
            pick=costs[ind]+cut1(costs, dp, n-(ind+1), ind);
        }
        int notPick=cut1(costs, dp, n, ind-1);
        return dp[ind][n]=Math.max(pick, notPick);
    }

    // Tabulation
    public static int cut2(int[] costs, int n){
        int[][] dp=new int[costs.length][n+1];
        for(int i=1; i<=n; i++){
            dp[0][i]=i*costs[0];
        }
        for(int ind=1; ind<costs.length; ind++){
            for(int rod=1; rod<=n; rod++){
                int pick=0;
                if(rod>=ind+1){
                    pick=costs[ind]+dp[ind][rod-(ind+1)];
                }
                int notPick=dp[ind-1][rod];
                dp[ind][rod]=Math.max(pick, notPick);
            }
        }
        return dp[costs.length-1][n];
    }

    // Space Optimization
    public static int cut3(int[] costs, int n){
        int[] prev=new int[n+1];
        for(int i=1; i<=n; i++){
            prev[i]=i*costs[0];
        }
        for(int ind=1; ind<costs.length; ind++){
            int[] curr=new int[n+1];
            for(int rod=1; rod<=n; rod++){
                int pick=0;
                if(rod>=ind+1){
                    pick=costs[ind]+curr[rod-(ind+1)];
                }
                int notPick=prev[rod];
                curr[rod]=Math.max(pick, notPick);
            }
            prev=curr;
        }
        return prev[n];
    }

    // Space Optimization 1D
    public static int cut4(int[] costs, int n){
        int[] prev=new int[n+1];
        for(int i=1; i<=n; i++){
            prev[i]=i*costs[0];
        }
        for(int ind=1; ind<costs.length; ind++){
            for(int rod=1; rod<=n; rod++){
                int pick=0;
                if(rod>=ind+1){
                    pick=costs[ind]+prev[rod-(ind+1)];
                }
                int notPick=prev[rod];
                prev[rod]=Math.max(pick, notPick);
            }
        }
        return prev[n];
    }

    public static void main(String[] args) {
        int[] costs=new int[]{2, 5, 7, 8, 10};
        int n=5;
        System.out.println(cut(costs, n, costs.length-1));
        int[][] dp=new int[costs.length][n+1];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(cut1(costs, dp, n, costs.length-1));
        System.out.println(cut2(costs, n));
        System.out.println(cut3(costs, n));
        System.out.println(cut4(costs, n));
    }
}
