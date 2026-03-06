package DynamicProgramming.L28;

public class LPS {
    // Tabulation
    public static int palindrome(String str){
        StringBuilder sb=new StringBuilder(str);
        String str2=sb.reverse().toString();
        int[][] dp=new int[str.length()+1][str2.length()+1];
        for(int i=0; i<str.length(); i++){
            dp[i][0]=0;
        }
        for(int j=0; j<str.length(); j++){
            dp[0][j]=0;
        }
        for(int ind1=1; ind1<=str.length(); ind1++){
            for(int ind2=1; ind2<=str2.length(); ind2++){
                if(str.charAt(ind1-1)==str2.charAt(ind2-1)){
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2]=Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
            }
        }
        return dp[str.length()][str2.length()];
    }

    // Space Optimization
    public static int palindrome1(String str){
        StringBuilder sb=new StringBuilder(str);
        String str2=sb.reverse().toString();
        int[] prev=new int[str2.length()+1];
        for(int i=0; i<str.length(); i++){
            prev[i]=0;
        }
        for(int ind1=1; ind1<=str.length(); ind1++){
            int[] curr=new int[str2.length()+1];
            for(int ind2=1; ind2<=str2.length(); ind2++){
                if(str.charAt(ind1-1)==str2.charAt(ind2-1)){
                    curr[ind2]=1+prev[ind2-1];
                }
                else{
                    curr[ind2]=Math.max(curr[ind2-1], prev[ind2]);
                }
            }
            prev=curr;
        }
        return prev[str2.length()];
    }

    public static void main(String[] args) {
        String str="bbbab";
        System.out.println(palindrome(str));
        System.out.println(palindrome1(str));
    }
}
