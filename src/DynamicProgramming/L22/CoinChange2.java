package DynamicProgramming.L22;

import java.util.Arrays;

public class CoinChange2 {
    // Recursion
    public static int coin(int[] coins, int ind, int amount){
        if(ind==0){
            if(amount%coins[ind]==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        int pick=0;
        if(coins[ind]<=amount){
            pick=coin(coins, ind, amount-coins[ind]);
        }
        int notPick=coin(coins, ind-1, amount);
        return pick+notPick;
    }

    // Memoization
    public static int coin1(int[] coins, int[][] dp, int ind, int amount){
        if(ind==0){
            if(amount%coins[ind]==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[ind][amount]!=-1){
            return dp[ind][amount];
        }
        int pick=0;
        if(coins[ind]<=amount){
            pick=coin1(coins, dp, ind, amount-coins[ind]);
        }
        int notPick=coin1(coins, dp, ind-1, amount);
        return dp[ind][amount]=pick+notPick;
    }

    // Tabulation
    public static int coin2(int[] coins, int amount){
        int[][] dp=new int[coins.length][amount+1];
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0){
                dp[0][i]=1;
            }
        }
        for(int ind=1; ind<coins.length; ind++){
            for(int am=0; am<=amount; am++){
                int pick=0;
                if(coins[ind]<=am){
                    pick=dp[ind][am-coins[ind]];
                }
                int notPick=dp[ind-1][am];
                dp[ind][am]=pick+notPick;
            }
        }
        return dp[coins.length-1][amount];
    }

    // Space Optimization
    public static int coin3(int[] coins, int amount){
        int[] prev=new int[amount+1];
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0){
                prev[i]=1;
            }
        }
        for(int ind=1; ind<coins.length; ind++){
            int[] curr=new int[amount+1];
            for(int am=0; am<=amount; am++){
                int pick=0;
                if(coins[ind]<=am){
                    pick=curr[am-coins[ind]];
                }
                int notPick=prev[am];
                curr[am]=pick+notPick;
            }
            prev=curr;
        }
        return prev[amount];
    }

    // 1D Space Optimization
    public static int coin4(int[] coins, int amount){
        int[] prev=new int[amount+1];
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0){
                prev[i]=1;
            }
        }
        for(int ind=1; ind<coins.length; ind++){
            for(int am=0; am<=amount; am++){
                int pick=0;
                if(coins[ind]<=am){
                    pick=prev[am-coins[ind]];
                }
                int notPick=prev[am];
                prev[am]=pick+notPick;
            }
        }
        return prev[amount];
    }

    public static void main(String[] args) {
        int[] coins=new int[]{1, 2, 5};
        int amount=5;
        System.out.println(coin(coins, coins.length-1, amount));
        int[][] dp=new int[coins.length][amount+1];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(coin1(coins, dp, coins.length-1, amount));
        System.out.println(coin2(coins, amount));
        System.out.println(coin3(coins, amount));
        System.out.println(coin4(coins, amount));
    }
}
