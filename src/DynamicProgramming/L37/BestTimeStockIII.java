package DynamicProgramming.L37;

import java.util.Arrays;

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete at most two transactions.
// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

public class BestTimeStockIII {
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
    public static int best2(int[] prices){
        int[][][] dp=new int[prices.length+1][2][3];
        for(int ind=prices.length-1; ind>=0; ind--){
            for(int alreadyBought=0; alreadyBought<=1; alreadyBought++){
                // starting from 1 because at trancactions0=0 we can't get profit
                for(int transactions=1; transactions<=2; transactions++){
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
        return dp[0][0][2];
    }

    // space optimization
    public static int best3(int[] prices){
        int[][] prev=new int[2][3];
        for(int ind=prices.length-1; ind>=0; ind--){
            int[][] curr=new int[2][3];
            for(int alreadyBought=0; alreadyBought<=1; alreadyBought++){
                // starting from 1 because at trancactions0=0 we can't get profit
                for(int transactions=1; transactions<=2; transactions++){
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
        return prev[0][2];
    }

    public static void main(String[] args) {
        int[] prices=new int[]{2,1,4,5,2,9,7};
        System.out.println(best(prices, 0, false, 2));

        int[][][] dp=new int[prices.length][2][3];
        for(int[][] twoD:dp){
            for(int[] oneD:twoD){
                Arrays.fill(oneD, -1);
            }
        }
        System.out.println(best1(dp, prices, 0, 0, 2));

        System.out.println(best2(prices));

        System.out.println(best3(prices));
    }
}
