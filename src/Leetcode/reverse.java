package Leetcode;

public class reverse {
    public static int Reverse(int x) {
        long y=0;
        boolean negative=false;
        if(x<0){
            x=Math.abs(x);
            negative=true;
        }
        while(x!=0){
            y=y*10+(x%10);
            x=x/10;
        }
        if(y>Integer.MAX_VALUE || y<Integer.MIN_VALUE){
            return 0;
        }
        if(negative){
            return (int)y*-1;
        }
        return (int)y;
    }
    public static void main(String[] args) {
        System.out.println(Reverse(120));
    }
}
