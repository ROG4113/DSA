package DynamicProgramming.L32;

import java.util.Arrays;

// Given two strings s and t, return the number of distinct subsequences of s which equals t.
// The test cases are generated so that the answer fits on a 32-bit signed integer.
public class DistinctSubsequence {
    // Recursion
    public static int distinct(String s, String t, int ind1, int ind2){
        if(ind1<0 || ind2<0){
            if(ind2<0){
                return 1;
            }
            else{
                return 0;
            }
        }
        int take=0;
        if(s.charAt(ind1)==t.charAt(ind2)){
            take=distinct(s, t, ind1-1, ind2-1);
        }
        int notTake=distinct(s, t, ind1-1, ind2);
        return take+notTake;
    }

    // Memoization
    public static int distinct1(int[][] dp, String s, String t, int ind1, int ind2){
        if(ind1<0 || ind2<0){
            if(ind2<0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        int take=0;
        if(s.charAt(ind1)==t.charAt(ind2)){
            take=distinct1(dp, s, t, ind1-1, ind2-1);
        }
        int notTake=distinct1(dp, s, t, ind1-1, ind2);
        return dp[ind1][ind2]=take+notTake;
    
    }
    // Memoization(0th index as -1)
    public static int distinct2(int[][] dp, String s, String t, int ind1, int ind2){
        if(ind1==0 || ind2==0){
            if(ind2==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        int take=0;
        if(s.charAt(ind1-1)==t.charAt(ind2-1)){
            take=distinct1(dp, s, t, ind1-1, ind2-1);
        }
        int notTake=distinct1(dp, s, t, ind1-1, ind2);
        return dp[ind1][ind2]=take+notTake;
    }

    // Tabulation
    public static int distinct3(String s, String t){
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=0; i<=s.length(); i++){
            // if s has something and t is empty
            dp[i][0]=1;
        }
        for(int j=1; j<=t.length(); j++){
            // if s is empty but t has something
            dp[0][j]=0;
        }
        for(int ind1=1; ind1<=s.length(); ind1++){
            for(int ind2=1; ind2<=t.length(); ind2++){
                int take=0;
                if(s.charAt(ind1-1)==t.charAt(ind2-1)){
                    take=dp[ind1-1][ind2-1];
                }
                int notTake=dp[ind1-1][ind2];
                dp[ind1][ind2]=take+notTake;
            }
        }
        return dp[s.length()][t.length()];
    }

    // Space Optimization
    public static int distinct4(String s, String t){
        int[] prev=new int[t.length()+1];
        prev[0]=1;
        for(int ind1=1; ind1<=s.length(); ind1++){
            int[] curr=new int[t.length()+1];
            curr[0]=1;
            for(int ind2=1; ind2<=t.length(); ind2++){
                int take=0;
                if(s.charAt(ind1-1)==t.charAt(ind2-1)){
                    take=prev[ind2-1];
                }
                int notTake=prev[ind2];
                curr[ind2]=take+notTake;
            }
            prev=curr;
        }
        return prev[t.length()];
    }

    // Space Optimization 1D
    public static int distinct5(String s, String t){
        int[] prev=new int[t.length()+1];
        prev[0]=1;
        for(int ind1=1; ind1<=s.length(); ind1++){
            for(int ind2=t.length(); ind2>=1; ind2--){
                int take=0;
                if(s.charAt(ind1-1)==t.charAt(ind2-1)){
                    take=prev[ind2-1];
                }
                int notTake=prev[ind2];
                prev[ind2]=take+notTake;
            }
        }
        return prev[t.length()];
    }

    public static void main(String[] args) {
        String s="babgbag";
        String t="bag";
        System.out.println(distinct(s, t, s.length()-1, t.length()-1));
        int[][] dp=new int[s.length()][t.length()];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(distinct1(dp, s, t, s.length()-1, t.length()-1));
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(distinct2(dp, s, t, s.length()-1, t.length()-1));
        System.out.println(distinct3(s, t));
        System.out.println(distinct4(s, t));
        System.out.println(distinct5(s, t));
    }
}
