package Leetcode;

public class L125 {
    public static boolean isPalindrome(String s) {
        String str="";
        s=s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            if((int)s.charAt(i)>=97 && (int)s.charAt(i)<=122 || (int)s.charAt(i)>=48 && (int)s.charAt(i)<=57){
                str=str+s.charAt(i);
            }
        }
        str.replace(" ", "");
        StringBuffer sb=new StringBuffer(str);
        if(str.equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String str="0P";
        System.out.println(isPalindrome(str));
        System.out.println((int)'0');
    }
}
