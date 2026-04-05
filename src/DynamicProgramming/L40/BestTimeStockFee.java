package DynamicProgramming.L40;

import java.util.Arrays;

// You are given an array prices where prices[i] is the price of a given stock on the ith day,
// and an integer fee representing a transaction fee.
// Find the maximum profit you can achieve. You may complete as many transactions as you like,
// but you need to pay the transaction fee for each transaction.
// Note:
// You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
// The transaction fee is only charged once for each stock purchase and sale.


public class BestTimeStockFee {
    // recursion
    public static int best(int[] prices, int ind, boolean alreadyBought, int fee){
        if(ind==prices.length){
            return 0;
        }
        int profit=0;
        // take notTake logic
        if(!alreadyBought){
            //                                          buying                                          not buying
            profit=Math.max(-prices[ind]+best(prices, ind+1, true, fee), 0+best(prices, ind+1, false, fee));
        }
        else{
            //                                              selling                                         not selling
            profit=Math.max(prices[ind]-fee+best(prices, ind+1, false, fee), 0+best(prices, ind+1, true, fee));
        }
        return profit;
    }
    
    // memoization
    public static int best1(int[][] dp, int[] prices, int ind, int alreadyBought, int fee){
        if(ind==prices.length){
            return 0;
        }
        if(dp[ind][alreadyBought]!=-1){
            return dp[ind][alreadyBought];
        }
        int profit=0;
        // take notTake logic
        if(alreadyBought==0){
            //                                          buying                                  not buying
            profit=Math.max(-prices[ind]+best1(dp, prices, ind+1, 1, fee), 0+best1(dp, prices, ind+1, 0, fee));
        }
        else{
            //                                      selling                                                     not selling
            profit=Math.max(prices[ind]-fee+best1(dp, prices, ind+1, 0, fee), 0+best1(dp, prices, ind+1, 1, fee));
        }
        return dp[ind][alreadyBought]=profit;
    }

    // tabulation
    public static int best2(int[] prices, int fee){
        int[][] dp=new int[prices.length+1][2];
        for(int ind=prices.length-1; ind>=0; ind--){
            for(int alreadyBought=0; alreadyBought<=1; alreadyBought++){
                int profit=0;
                if(alreadyBought==0){
                    profit=Math.max(-prices[ind]+dp[ind+1][1], 0+dp[ind+1][0]);
                }
                else{
                    profit=Math.max(prices[ind]-fee+dp[ind+1][0], 0+dp[ind+1][1]);
                }
                dp[ind][alreadyBought]=profit;
            }
        }
        return dp[0][0];
    }

    // space optimization
    public static int best3(int[] prices, int fee){
        int[] prev=new int[2];
        for(int ind=prices.length-1; ind>=0; ind--){
            int[] curr=new int[2];
            for(int alreadyBought=0; alreadyBought<=1; alreadyBought++){
                int profit=0;
                if(alreadyBought==0){
                    profit=Math.max(-prices[ind]+prev[1], 0+prev[0]);
                }
                else{
                    profit=Math.max(prices[ind]-fee+prev[0], 0+prev[1]);
                }
                curr[alreadyBought]=profit;
            }
            prev=curr;
        }
        return prev[0];
    }

    public static void main(String[] args) {
        int[] prices=new int[]{1,3,2,8,4,9};
        int fee=2;
        System.out.println(best(prices, 0, false, fee));
        
        int[][] dp=new int[prices.length][2];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(best1(dp, prices, 0, 0, fee));
        
        System.out.println(best2(prices, fee));

        System.out.println(best3(prices, fee));
    }
}
