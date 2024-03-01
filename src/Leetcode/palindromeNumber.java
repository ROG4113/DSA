package Leetcode;

public class palindromeNumber {
    public static boolean isPalindrome(int x) {
        String str=Integer.toString(x);
        char[] n=str.toCharArray();
        int start=0;
        int end=n.length-1;
        while(start<end){
            if(n[start++]!=n[end--]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }
}
