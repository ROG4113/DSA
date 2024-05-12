package Leetcode;

public class L1704 {
    public static boolean halvesAreAlike(String s) {
        String str1=s.substring(0, s.length()/2);
        String str2=s.substring(s.length()/2);
        if(countVowels(str1)==countVowels(str2)){
            return true;
        }
        else{
            return false;
        }
    }
    private static int countVowels(String str){
        int count=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='a' || str.charAt(i)=='A' || str.charAt(i)=='e' || str.charAt(i)=='E' || str.charAt(i)=='i' || str.charAt(i)=='I' || str.charAt(i)=='o' || str.charAt(i)=='O' || str.charAt(i)=='u' || str.charAt(i)=='U'){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String str="book";
        System.out.println(halvesAreAlike(str));
    }
}
