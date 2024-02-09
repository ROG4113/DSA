package Leetcode;

public class ArrangingCoins {
    public static int arrangeCoins(int n) {
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                n--;
            }
            count++;
        }
        return count;
    }
    //optimized
    public static int arrangeCoins1(int n) {
        int count=0;
        for (int i = 1; i <= n; i++) {
            n=n-i;
            if(n>=0){
                count++;
            }
            else break;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(15));
        System.out.println(arrangeCoins1(15));
    }
}
