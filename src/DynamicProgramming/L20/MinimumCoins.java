package DynamicProgramming.L20;

import java.util.Arrays;

public class MinimumCoins {
    // Recursion
    public static int minimum(int[] coins, int amount, int ind){
        if(ind==0){
            if(amount%coins[ind]==0){
                return amount/coins[ind];
            }
            else{
                return (int)1e9;
            }
        }
        int pick=Integer.MAX_VALUE;
        if(coins[ind]<=amount){
            pick=1+minimum(coins, amount-coins[ind], ind);
        }
        int notPick=minimum(coins, amount, ind-1);
        return Math.min(pick, notPick);
    }

    // Memoization
    public static int minimum1(int[] coins, int[][] dp, int amount, int ind){
        if(ind==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            else{
                return (int)1e9;
            }
        }
        if(dp[ind][amount]!=-1){
            return dp[ind][amount];
        }
        int pick=Integer.MAX_VALUE;
        if(coins[ind]<=amount){
            pick=1+minimum1(coins, dp, amount-coins[ind], ind);
        }
        int notPick=minimum1(coins, dp, amount, ind-1);
        return dp[ind][amount]=Math.min(pick, notPick);
    }

    // Tabulation
    public static int minimum2(int[] coins, int amount){
        int[][] dp=new int[coins.length][amount+1];
        // if(ind==0){
        //     if(amount%coins[0]==0){
        //         return amount/coins[0];
        //     }
        //     else{
        //         return (int)1e9;
        //     }
        // }
        for(int i=coins[0]; i<=amount; i++){
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }
            else{
                dp[0][i]=(int)1e9;
            }
        }
        for(int ind=1; ind<coins.length; ind++){
            for(int am=0; am<=amount; am++){
                int pick=Integer.MAX_VALUE;
                if(coins[ind]<=am){
                    pick=1+dp[ind][am-coins[ind]];
                }
                int notPick=dp[ind-1][am];
                dp[ind][am]=Math.min(pick, notPick);
            }
        }
        return dp[coins.length-1][amount];
    }
    // Space optimization
    public static int minimum3(int[] coins, int amount){
        int[] prev=new int[amount+1];
        int[] curr=new int[amount+1];
        for(int i=coins[0]; i<=amount; i++){
            if(i%coins[0]==0){
                prev[i]=i/coins[0];
            }
        }
        for(int ind=1; ind<coins.length; ind++){
            for(int am=0; am<=amount; am++){
                int pick=Integer.MAX_VALUE;
                if(coins[ind]<=am){
                    pick=1+curr[am-coins[ind]];
                }
                int notPick=prev[am];
                curr[am]=Math.min(pick, notPick);
            }
            prev=curr;
        }
        return prev[amount];
    }

    public static void main(String[] args) {
        int[] coins=new int[]{1, 2, 5};
        int amount=11;
        System.out.println(minimum(coins, amount, coins.length-1));
        int[][] dp=new int[coins.length][amount+1];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(minimum1(coins, dp, amount, coins.length-1));
        System.out.println(minimum2(coins, amount));
        System.out.println(minimum3(coins, amount));
    }
}
