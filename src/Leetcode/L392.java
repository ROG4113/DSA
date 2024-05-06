package Leetcode;
public class L392{
    public static boolean isSubsequence(String s, String t) {
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        int i=0, j=0;
        if(arr1.length<1){
            return true;
        }
        while(j<arr2.length){
            if(arr1[i]==arr2[j]){
                i++;
                j++;
            }
            else{
                j++;
            }
            if(i==arr1.length){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str1="abc";
        String str2="ahbgdc";
        System.out.println(isSubsequence(str1, str2));
    }
}