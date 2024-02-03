package Recursion.Recursion1;

public class Intro {
    static void print(int n){
        System.out.println(n);
        if(n==5){
            return;
        }
        print(n+1);//Tail recursion: This is the last function call.
    }

    public static void main(String[] args) {
        print(0);
    }
}
