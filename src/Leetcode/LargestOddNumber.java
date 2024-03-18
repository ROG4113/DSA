package Leetcode;

public class LargestOddNumber {
    public static String largestOddNumber(String num) {
        for(int i=num.length()-1; i>=0; i--){
            if(((int)num.charAt(i))-48==0) continue;
            int element=((int)num.charAt(i))-48;
            if(element%2!=0){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
    public static void main(String[] args) {
        String str="9";
        System.out.println(largestOddNumber(str));
    }
}
