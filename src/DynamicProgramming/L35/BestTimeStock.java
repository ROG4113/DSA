package DynamicProgramming.L35;

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
public class BestTimeStock {
    public static int best(int[] prices){
        int rMax=0, profit=0;
        for(int i=prices.length-1; i>=0; i--){
            if(prices[i]>rMax){
                rMax=prices[i];
            }
            else{
                profit=Math.max(profit, rMax-prices[i]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices=new int[]{7, 1, 4, 2, 6, 3};
        System.out.println(best(prices));
    }
}
