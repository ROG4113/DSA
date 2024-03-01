package Leetcode;

public class Complement {
    public static int findComplement(int num) {
        // int binary=0;
        // int bits=0;
        // while(num>0){
        //     binary=binary*10+num%2;
        //     num=num/2;
        //     bits++;
        // }
        // int n=0;
        // while(bits>0){
        //     n=n*10+1;
        //     bits--;
        // }
        // return binary^n;
        int bits=Integer.toBinaryString(num).length();
        int maxBound=(int)(Math.pow(2, bits)-1);
        return maxBound^num;
    }
    public static boolean isEven(int n){
        if (n==0) {
            return false;
        }
        return (n&1)==0?true:false;
    }
    public static void main(String[] args) {
        System.out.println(isEven(1765765780));
        System.out.println(findComplement(5));
    }
}
