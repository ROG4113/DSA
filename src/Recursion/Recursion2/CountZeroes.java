package Recursion.Recursion2;

public class CountZeroes {
    static int count=0;
    static void zeroes(int n){
        if(n==0){
            return;
        }
        if(n%10==0){
            count++;
        }
        zeroes(n/10);
    }
    //    <OTHER WAY>
    static int zeroes1(int n){
        return helper(n, 0);
    }
    static int helper(int n, int counts){
        if(n==0){
            return counts;
        }
        if(n%10==0){
            return helper(n/10, counts+1);
        }
        return helper(n/10, counts);
    }

    public static void main(String[] args) {
        // zeroes(302040305);
        // System.out.println(count);
        int ans=zeroes1(302040305);
        System.out.println(ans);
    }
}
