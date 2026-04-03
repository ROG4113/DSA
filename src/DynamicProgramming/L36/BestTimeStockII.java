package DynamicProgramming.L36;

import java.util.Arrays;

public class BestTimeStockII {
    // recursion
    public static int best(int[] prices, int ind, boolean alreadyBought){
        if(ind==prices.length){
            return 0;
        }
        int profit=0;
        // take notTake logic
        if(!alreadyBought){
            //                                          buying                                  not buying
            profit=Math.max(-prices[ind]+best(prices, ind+1, true), 0+best(prices, ind+1, false));
        }
        else{
            //                                  selling                                         not selling
            profit=Math.max(prices[ind]+best(prices, ind+1, false), 0+best(prices, ind+1, true));
        }
        return profit;
    }
    
    // memoization
    public static int best1(int[][] dp, int[] prices, int ind, int alreadyBought){
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
            profit=Math.max(-prices[ind]+best1(dp, prices, ind+1, 1), 0+best1(dp, prices, ind+1, 0));
        }
        else{
            //                                  selling                                         not selling
            profit=Math.max(prices[ind]+best1(dp, prices, ind+1, 0), 0+best1(dp, prices, ind+1, 1));
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
                    profit=Math.max(-prices[ind]+dp[ind+1][1], 0+dp[ind+1][0]);
                }
                else{
                    profit=Math.max(prices[ind]+dp[ind+1][0], 0+dp[ind+1][1]);
                }
                dp[ind][alreadyBought]=profit;
            }
        }
        return dp[0][0];
    }

    // space optimization
    public static int best3(int[] prices){
        int[] prev=new int[2];
        for(int ind=prices.length-1; ind>=0; ind--){
            int[] curr=new int[2];
            for(int alreadyBought=0; alreadyBought<=1; alreadyBought++){
                int profit=0;
                if(alreadyBought==0){
                    profit=Math.max(-prices[ind]+prev[1], 0+prev[0]);
                }
                else{
                    profit=Math.max(prices[ind]+prev[0], 0+prev[1]);
                }
                curr[alreadyBought]=profit;
            }
            prev=curr;
        }
        return prev[0];
    }

    public static void main(String[] args) {
        int[] prices=new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(best(prices, 0, false));
        
        int[][] dp=new int[prices.length][2];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(best1(dp, prices, 0, 0));
        
        System.out.println(best2(prices));

        System.out.println(best3(prices));

        System.out.println(bestt(prices, prices.length-1, false));
    }
}
