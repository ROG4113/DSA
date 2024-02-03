package Recursion.Recursion2;

public class Factorial {
    public static int fac(int n){
        if(n<2){
            return n;
        }
        return n*fac(n-1);
    }

    public static void main(String[] args) {
        int ans=fac(5);
        System.out.println(ans);
    }
}
