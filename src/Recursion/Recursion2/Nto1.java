package Recursion.Recursion2;

public class Nto1 {
    public static void print(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        print(n-1);
    }
    public static void printRev(int n){
        if(n==0){
            return;
        }
        printRev(n-1);
        System.out.println(n);
    }
    public static void print1(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        print1(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        // print(5);
        // printRev(5);
        print1(5);
    }
}
