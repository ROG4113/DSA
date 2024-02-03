package Leetcode;

public class ReduceToZero {
    public static int noOfSteps(int num){
        return helper(num, 0);
    }
    private static int helper(int num, int steps){
        if(num==0){
            return steps;
        }
        if(num%2==0){
            return helper(num/2, steps+1);
        }
        return helper(num-1, steps+1);
    }

    public static void main(String[] args) {
        int ans=noOfSteps(14);
        System.out.println(ans);
    }
}
