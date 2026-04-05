package DynamicProgramming.L39;

import java.util.Arrays;

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete as many transactions as you like
// (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
// After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

public class BestTimeStockCooldown {
    // recursion
    public static int best(int[] prices, int ind, boolean alreadyBought){
        if(ind>=prices.length){
            return 0;
        }
        int profit=0;
        // buy or not buy
        if(!alreadyBought){
            profit=Math.max(-prices[ind]+best(prices, ind+1, true),
                0+best(prices, ind+1, false)
            );
        }
        // sell or not sell
        else{
            profit=Math.max(prices[ind]+best(prices, ind+2, false),
                0+best(prices, ind+1, true)
            );
        }
        return profit;
    }

    // memoization
    public static int best1(int[][] dp, int[] prices, int ind, int alreadyBought){
        if(ind>=prices.length){
            return 0;
        }
        if(dp[ind][alreadyBought]!=-1){
            return dp[ind][alreadyBought];
        }
        int profit=0;
        if(alreadyBought==0){
            profit=Math.max(-prices[ind]+best1(dp, prices, ind+1, 1),
                0+best1(dp, prices, ind+1, 0)
            );
        }
        else{
            profit=Math.max(prices[ind]+best1(dp, prices, ind+2, 0),
                0+best1(dp, prices, ind+1, 1)
            );
        }
        return dp[ind][alreadyBought]=profit;
    }

    // tabulation
    public static int best2(int[] prices){
        int[][] dp=new int[prices.length+1][2];
        for(int ind=prices.length-1; ind>=0; ind--){
            for(int alreadyBought=0; alreadyBought<=1; alreadyBought++){
                int profit=0;
                if(alreadyBought==0){
                    profit=Math.max(-prices[ind]+dp[ind+1][1], dp[ind+1][0]);
                }
                else{
                    int sell=0, notSell=0;
                    sell=sell+prices[ind];
                    if(ind<prices.length-2){
                        sell=sell+dp[ind+2][0];
                    }
                    notSell=notSell+dp[ind+1][1];
                    profit=Math.max(sell, notSell);
                }
                dp[ind][alreadyBought]=profit;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] prices=new int[]{1,2,3,0,2};
        System.out.println(best(prices, 0, false));

        int[][] dp=new int[prices.length][2];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(best1(dp, prices, 0, 0));

        System.out.println(best2(prices));
    }
}
