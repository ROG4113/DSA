package Leetcode;

public class L1021{
    public static String removeOuterParentheses(String s) {
        String str="";
        int open=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(' && open++>0){
                str+='(';
            }
            if(s.charAt(i)==')' && open-->1){
                str+=')';
            }
        }
        return str;
    }
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s));
    }
}