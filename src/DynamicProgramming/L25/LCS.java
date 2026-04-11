package DynamicProgramming.L25;

import java.util.Arrays;

public class LCS {
    // Recursion
    public static int longest(String str1, int ind1, String str2, int ind2){
        if(ind1<0 || ind2<0){
            return 0;
        }
        if(str1.charAt(ind1)==str2.charAt(ind2)){
            return 1+longest(str1, ind1-1, str2, ind2-1);
        }
        else{
            return Math.max(longest(str1, ind1-1, str2, ind2), longest(str1, ind1, str2, ind2-1));
        }
    }

    // Memoization
    public static int longest1(int[][] dp, String str1, int ind1, String str2, int ind2){
        if(ind1<0 || ind2<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(str1.charAt(ind1)==str2.charAt(ind2)){
            return dp[ind1][ind2]=1+longest1(dp, str1, ind1-1, str2, ind2-1);
        }
        else{
            return dp[ind1][ind2]=Math.max(longest1(dp, str1, ind1-1, str2, ind2), longest1(dp, str1, ind1, str2, ind2-1));
        }
    }

    // Memoization(shifting of index to one right)
    public static int longest2(int[][] dp, String str1, int ind1, String str2, int ind2){
        if(ind1==0 || ind2==0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){
            return dp[ind1][ind2]=1+longest2(dp, str1, ind1-1, str2, ind2-1);
        }
        else{
            return dp[ind1][ind2]=Math.max(longest2(dp, str1, ind1-1, str2, ind2), longest2(dp, str1, ind1, str2, ind2-1));
        }
    }

    // Tabulation
    public static int longest3(String str1, String str2){
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        for(int i=0; i<=str1.length(); i++){
            dp[i][0]=0;
        }
        for(int i=0; i<=str2.length(); i++){
            dp[0][i]=0;
        }
        for(int ind1=1; ind1<=str1.length(); ind1++){
            for(int ind2=1; ind2<=str2.length(); ind2++){
                // match
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2]=Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    // Space Oprimization
    public static int longest4(String str1, String str2){
        int[] prev=new int[str2.length()+1];
        for(int i=0; i<=str2.length(); i++){
            prev[i]=0;
        }
        for(int ind1=1; ind1<=str1.length(); ind1++){
            int[] curr=new int[str2.length()+1];
            for(int ind2=1; ind2<=str2.length(); ind2++){
                // match
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){
                    curr[ind2]=1+prev[ind2-1];
                }
                else{
                    curr[ind2]=Math.max(prev[ind2], curr[ind2-1]);
                }
            }
            prev=curr;
        }
        return prev[str2.length()];
    }

    public static void main(String[] args) {
        String str1="acd";
        String str2="ced";
        System.out.println(longest(str1, str1.length()-1, str2, str2.length()-1));

        int[][] dp=new int[str1.length()][str2.length()];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(longest1(dp, str1, str1.length()-1, str2, str2.length()-1));

        int[][] dp1=new int[str1.length()+1][str2.length()+1];
        for(int[] oneD:dp1){
            Arrays.fill(oneD, -1);
        }
        System.out.println(longest2(dp1, str1, str1.length(), str2, str2.length()));

        System.out.println(longest3(str1, str2));
        
        System.out.println(longest4(str1, str2));
    }
}
