package DynamicProgramming.L27;

public class LongestCommonSubstring {
    // Tabulation
    public static int substring(String str1, String str2){
        int max=0;
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        for(int i=0; i<=str1.length(); i++){
            dp[i][0]=0;
        }
        for(int j=0; j<=str2.length(); j++){
            dp[0][j]=0;
        }
        for(int ind1=1; ind1<=str1.length(); ind1++){
            for(int ind2=1; ind2<=str2.length(); ind2++){
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                    max=Math.max(max, dp[ind1][ind2]);
                }
                else{
                    dp[ind1][ind2]=0;
                }
            }
        }
        return max;
    }

    // Space Optimization
    public static int substring1(String str1, String str2){
        int max=0;
        int[] prev=new int[str2.length()+1];
        for(int j=0; j<=str2.length(); j++){
            prev[j]=0;
        }
        for(int ind1=1; ind1<=str1.length(); ind1++){
            int[] curr=new int[str2.length()+1];
            for(int ind2=1; ind2<=str2.length(); ind2++){
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){
                    curr[ind2]=1+prev[ind2-1];
                    max=Math.max(max, curr[ind2]);
                }
                else{
                    curr[ind2]=0;
                }
            }
            prev=curr;
        }
        return max;
    }

    public static void main(String[] args) {
        String str1="dcabcdc";
        String str2="jhabcjh";
        System.out.println(substring(str1, str2));
        System.out.println(substring1(str1, str2));
    }
}
