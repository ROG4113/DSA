package Leetcode;

public class L1358 {
    public static int numberOfSubstrings(String s) {
        int count=0;
        int[] LastSeen={-1, -1, -1};
        for(int i=0; i<s.length(); i++){
            LastSeen[s.charAt(i)-'a']=i;
            if(LastSeen[0]!=-1 && LastSeen[1]!=-1 && LastSeen[2]!=-1){
                count+=Math.min(Math.min(LastSeen[0], LastSeen[1]), LastSeen[2])+1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String str="bbacba";
        System.out.println(numberOfSubstrings(str));
    }
}
