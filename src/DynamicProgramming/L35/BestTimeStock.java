package DynamicProgramming.L35;

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
