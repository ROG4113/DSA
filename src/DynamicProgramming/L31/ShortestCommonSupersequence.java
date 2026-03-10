package DynamicProgramming.L31;

public class ShortestCommonSupersequence {
    public static String scs(String word1, String word2){
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<=word1.length(); i++){
            dp[i][0]=0;
        }
        for(int j=0; j<=word2.length(); j++){
            dp[0][j]=0;
        }
        for(int ind1=1; ind1<=word1.length(); ind1++){
            for(int ind2=1; ind2<=word2.length(); ind2++){
                if(word1.charAt(ind1-1)==word2.charAt(ind2-1)){
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2]=Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
            }
        }
        int length=(word1.length()+word2.length())-dp[word1.length()][word2.length()];
        int n=word1.length(), m=word2.length();
        StringBuilder sb=new StringBuilder();
        while(n>0 && m>0){
            if(word1.charAt(n-1)==word2.charAt(m-1)){
                sb.append(word1.charAt(n-1));
                n--;
                m--;
            }
            else if(dp[n-1][m]>dp[n][m-1]){
                sb.append(word1.charAt(n-1));
                n--;
            }
            else{
                sb.append(word2.charAt(m-1));
                m--;
            }
        }
        while(n>0){
            sb.append(word1.charAt(n-1));
            n--;
        }
        while(m>0){
            sb.append(word2.charAt(m-1));
            m--;
        }
        System.out.println("length:" + length);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String word1="brute";
        String word2="groot";
        System.out.println(scs(word1, word2));
    }
}
