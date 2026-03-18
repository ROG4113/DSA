package DynamicProgramming.L33;

import java.util.Arrays;

// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
// You have the following three operations permitted on a word:
//     Insert a character
//     Delete a character
//     Replace a character

public class EditDistance{
    // recursion
    public static int minimum(String word1, String word2, int ind1, int ind2){
        if(ind1<0 || ind2<0){
            if(ind1<0 && ind2<0){
                return 0;
            }
            if(ind2<0){
                return ind1+1;
            }
            else{
                return ind2+1;
            }
        }
        if(word1.charAt(ind1)==word2.charAt(ind2)){
            return 0+minimum(word1, word2, ind1-1, ind2-1);
        }
        return Math.min(Math.min(1+minimum(word1, word2, ind1-1, ind2), 1+minimum(word1, word2, ind1, ind2-1)), 1+minimum(word1, word2, ind1-1, ind2-1));
    }

    // memoization
    public static int minimum1(int[][] dp, String word1, String word2, int ind1, int ind2){
        if(ind1<0 || ind2<0){
            if(ind1<0 && ind2<0){
                return 0;
            }
            if(ind2<0){
                return ind1+1;
            }
            else{
                return ind2+1;
            }
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(word1.charAt(ind1)==word2.charAt(ind2)){
            return dp[ind1][ind2]=0+minimum1(dp, word1, word2, ind1-1, ind2-1);
        }
        return dp[ind1][ind2]=1+Math.min(Math.min(minimum1(dp, word1, word2, ind1-1, ind2), minimum1(dp, word1, word2, ind1, ind2-1)), minimum1(dp, word1, word2, ind1-1, ind2-1));
    }

    
    // tabulation
    public static int minimum2(String word1, String word2){
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<=word1.length(); i++){
            dp[i][0]=i;
        }
        for(int j=0; j<=word2.length(); j++){
            dp[0][j]=j;
        }
        for(int ind1=1; ind1<=word1.length(); ind1++){
            for(int ind2=1; ind2<=word2.length(); ind2++){
                if(word1.charAt(ind1-1)==word2.charAt(ind2-1)){
                    dp[ind1][ind2]=dp[ind1-1][ind2-1];
                }
                else{
                    // deleted  insert  replace
                    dp[ind1][ind2]=1+Math.min(dp[ind1-1][ind2], Math.min(dp[ind1][ind2-1], dp[ind1-1][ind2-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    // space optimization
    public static int minimum3(String word1, String word2){
        int[] prev=new int[word2.length()+1];
        for(int j=0; j<=word2.length(); j++){
            prev[j]=j;
        }
        for(int ind1=1; ind1<=word1.length(); ind1++){
            int[] curr=new int[word2.length()+1];
            curr[0]=ind1;
            for(int ind2=1; ind2<=word2.length(); ind2++){
                if(word1.charAt(ind1-1)==word2.charAt(ind2-1)){
                    curr[ind2]=prev[ind2-1];
                }
                else{
                    // deleted  insert  replace
                    curr[ind2]=1+Math.min(prev[ind2], Math.min(curr[ind2-1], prev[ind2-1]));
                }
            }
            prev=curr;
        }
        return prev[word2.length()];
    }

    public static void main(String[] args) {
        String word1="horse";
        String word2="ros";
        System.out.println(minimum(word1, word2, word1.length()-1, word2.length()-1));
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(minimum1(dp, word1, word2, word1.length()-1, word2.length()-1));
        System.out.println(minimum2(word1, word2));
        System.out.println(minimum3(word1, word2));
        System.out.println(minimum4(word1, word2));
    }
}