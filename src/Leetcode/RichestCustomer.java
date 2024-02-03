package Leetcode;

public class RichestCustomer {
    public static int maximumWealth(int[][] accounts) {
        int wealth = 0;
        int max = 0;
        for (int[] cus : accounts) {
            for (int i = 0; i < accounts[0].length; i++) {
                wealth += cus[i];
            }
            if(max<wealth){
                max=wealth;
            }
            wealth=0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[][]arr={{1,2,3},{9,2,1}};
        System.out.println(maximumWealth(arr));
    }
}
