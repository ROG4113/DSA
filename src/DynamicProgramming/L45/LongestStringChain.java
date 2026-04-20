package DynamicProgramming.L45;

import java.util.Arrays;

// You are given an array of words where each word consists of lowercase English letters.
// wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA
// wthout changing the order of the other characters to make it equal to wordB.
// For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
// A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1,
// where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
// Return the length of the longest possible word chain with words chosen from the given list of words.

public class LongestStringChain {
    public static int chain(String[] words){
        int[] dp=new int[words.length];
        Arrays.sort(words, (a, b)->a.length()-b.length());
        Arrays.fill(dp, 1);
        int max=1;
        for(int ind=0; ind<words.length; ind++){
            for(int previndex=0; previndex<ind; previndex++){
                if(compare(words[previndex], words[ind]) && dp[ind]<dp[previndex]+1){
                    dp[ind]=dp[previndex]+1;
                }
            }
            max=Math.max(max, dp[ind]);
        }
        return max;
    }

    public static boolean compare(String str1, String str2){
        if(str1.length()+1!=str2.length()){
            return false;
        }
        int ind1=0, ind2=0;
        while(ind2<str2.length()){
            if(ind1<str1.length() && str1.charAt(ind1)==str2.charAt(ind2)){
                ind1++;
                ind2++;
            }
            else{
                ind2++;
            }
        }
        return ind1==str1.length() && ind2==str2.length();
    }

    public static void main(String[] args) {
        String[] words=new String[]{"a","b","ba","bca","bda","bdca"}; // "xbc","pcxbcf","xb","cxbc","pcxbc"
        System.out.println(chain(words));
    }
}
