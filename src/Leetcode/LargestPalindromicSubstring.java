package Leetcode;

public class LargestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        String maxSub="";
        int maxLen=Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                if(s.substring(i, j).length()>maxLen){
                    if(isPalindrome(s, i, j)){
                        maxSub=s.substring(i, j+1);
                        maxLen=s.substring(i, j).length();
                    }
                }
            }
        }
        return maxSub;
    }
    private static boolean isPalindrome(String s, int i, int j){
        int start=i, end=j;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }
}
