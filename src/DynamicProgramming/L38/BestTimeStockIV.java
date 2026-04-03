package DynamicProgramming.L38;

import java.util.Arrays;

// You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
// Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

public class BestTimeStockIV {
    // recursion
    public static int best(int[] prices, int ind, boolean alreadyBought, int transactions){
        if(ind==prices.length || transactions==0){
            return 0;
        }
        int profit=0;
        if(!alreadyBought){
            profit=Math.max(-prices[ind]+best(prices, ind+1, true, transactions),
                0+best(prices, ind+1, false, transactions)
            );
        }
        else{
            profit=Math.max(prices[ind]+best(prices, ind+1, false, transactions-1),
                0+best(prices, ind+1, true, transactions)
            );
        }
        return profit;
    }

    // memoization
    public static int best1(int[][][] dp, int[] prices, int ind, int alreadyBought, int transactions){
        if(ind==prices.length || transactions==0){
            return 0;
        }
        if(dp[ind][alreadyBought][transactions]!=-1){
            return dp[ind][alreadyBought][transactions];
        }
        int profit=0;
        if(alreadyBought==0){
            profit=Math.max(-prices[ind]+best1(dp, prices, ind+1, 1, transactions),
                0+best1(dp, prices, ind+1, 0, transactions)
            );
        }
        else{
            profit=Math.max(prices[ind]+best1(dp, prices, ind+1, 0, transactions-1),
                0+best1(dp, prices, ind+1, 1, transactions)
            );
        }
        return dp[ind][alreadyBought][transactions]=profit;
    }

    // tabulation
    public static int best2(int[] prices, int k){
        int[][][] dp=new int[prices.length+1][2][k+1];
        for(int ind=prices.length-1; ind>=0; ind--){
            for(int alreadyBought=0; alreadyBought<=1; alreadyBought++){
                // starting from 1 because at trancactions0=0 we can't get profit
                for(int transactions=1; transactions<=k; transactions++){
                    int profit=0;
                    if(alreadyBought==0){
                        profit=Math.max(-prices[ind]+dp[ind+1][1][transactions], dp[ind+1][0][transactions]);
                    }
                    else{
                        profit=Math.max(prices[ind]+dp[ind+1][0][transactions-1], dp[ind+1][1][transactions]);
                    }
                    dp[ind][alreadyBought][transactions]=profit;
                }
            }
        }
        return dp[0][0][k];
    }

    // space optimization
    public static int best3(int[] prices, int k){
        int[][] prev=new int[2][k+1];
        for(int ind=prices.length-1; ind>=0; ind--){
            int[][] curr=new int[2][k+1];
            for(int alreadyBought=0; alreadyBought<=1; alreadyBought++){
                // starting from 1 because at trancactions0=0 we can't get profit
                for(int transactions=1; transactions<=k; transactions++){
                    int profit=0;
                    if(alreadyBought==0){
                        profit=Math.max(-prices[ind]+prev[1][transactions], prev[0][transactions]);
                    }
                    else{
                        profit=Math.max(prices[ind]+prev[0][transactions-1], prev[1][transactions]);
                    }
                    curr[alreadyBought][transactions]=profit;
                }
            }
            prev=curr;
        }
        return prev[0][k];
    }

    public static void main(String[] args) {
        int[] prices=new int[]{1,2,4,2,5,7,2,4,9,0};
        int k=4;
        System.out.println(best(prices, 0, false, k));

        int[][][] dp=new int[prices.length][2][k+1];
        for(int[][] twoD:dp){
            for(int[] oneD:twoD){
                Arrays.fill(oneD, -1);
            }
        }
        System.out.println(best1(dp, prices, 0, 0, k));

        System.out.println(best2(prices, k));

        System.out.println(best3(prices, k));
    }
}
