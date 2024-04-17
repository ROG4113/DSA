package Leetcode;
public class L1614{
    public static int maxDepth(String s) {
        int count=0, max=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                count++;
            }
            if(s.charAt(i)==')'){
                count--;
            }
            max=Math.max(max, count);
        }
        return max;
    }
    public static void main(String[] args) {
        String str="(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(str));
    }
}