package Leetcode;

public class PowerOfTwoRec {
    public static boolean isPowerOfTwo(int n) {
        if(n==1){
            return true;
        }
        if(n==0 || n%2!=0){
            return false;
        }
        return isPowerOfTwo(n/2);
    }
    public static boolean isPowerOfThree(int n) {
        if(n==1){
            return true;
        }
        if(n==0 || n%2==0){
            return false;
        }
        return isPowerOfThree(n/3);
    }
    //
    public static boolean isPowerOfThree1(int n) {
        if (n == 1){return true;}
        if (n%3 != 0 || n == 0) {
            return false;
        }
        return isPowerOfThree(n/3);
    }
    public static void main(String[] args) {
        // System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfThree(45));
        // System.out.println(isPowerOfThree1(45));
    }
}
