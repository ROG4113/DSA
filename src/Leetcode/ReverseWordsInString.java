package Leetcode;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        String[] arr=s.split(" ");
        String str="";
        str=str+arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i]!=""){
                if(i>=0){
                    str+=" ";
                }
                str=str+arr[i];
            }
        }
        return str;
    }
    public static void main(String[] args) {
        String str="the sky is blue";
        System.out.println(reverseWords(str));
    }
}
