package DynamicProgramming.L30;

public class MinimumOperations {
// Given two strings word1 and word2,
// return the minimum number of steps required to make word1 and word2 the same.
// In one step, you can delete exactly one character in either string.
// Note: We can get LCS of both to find what can be ignored("ea" here) and subtract it from total length of string.

    public static int operation(String word1, String word2){
        int[] prev=new int[word2.length()+1];
        for(int i=0; i<word2.length(); i++){
            prev[i]=0;
        }
        for(int ind1=1; ind1<=word1.length(); ind1++){
            int[] curr=new int[word2.length()+1];
            for(int ind2=1; ind2<=word2.length(); ind2++){
                if(word1.charAt(ind1-1)==word2.charAt(ind2-1)){
                    curr[ind2]=1+prev[ind2-1];
                }
                else{
                    curr[ind2]=Math.max(curr[ind2-1], prev[ind2]);
                }
            }
            prev=curr;
        }
        return word1.length()-prev[word2.length()]+word2.length()-prev[word2.length()];
    }

    public static void main(String[] args) {
        String word1="eat";
        String word2="sea";
        System.out.println(operation(word1, word2));
    }
}
