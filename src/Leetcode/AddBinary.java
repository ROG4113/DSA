package Leetcode;

public class AddBinary {
    public static String addBinary(String a, String b) {
        int f=Integer.parseInt(a, 2);
        int s=Integer.parseInt(b, 2);
        int sum=f+s;
        String str=Integer.toBinaryString(sum);
        return str;
    }
    public static void main(String[] args) {
        String a="11";
        String b="1";
        System.out.println(addBinary(a, b));
    }
}