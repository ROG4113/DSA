package Recursion.Recursion1;

public class Fibonacci {
    static int fibo(int n){
        if(n<2){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }

    static int fiboFormula(int n){
        return (int) (((Math.pow(((1+Math.sqrt(5))/2),n))-(Math.pow(((1-Math.sqrt(5))/2),n)))/Math.sqrt(5));
    }

    public static void main(String[] args){
        int ans=fibo(4);
        int ans2=fiboFormula(50);
        System.out.println(ans);
        System.out.println(ans2);
    }
}
