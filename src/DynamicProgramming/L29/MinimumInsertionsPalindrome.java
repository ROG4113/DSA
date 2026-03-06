package DynamicProgramming.L29;

public class MinimumInsertionsPalindrome {
    // The trick to find minimum insertions to make a string palindrome,
    // is to find already palindromic common subsequence in the string i.e.
    // LPS(str) or LCS(str, rev(str)) and then subtract it from length of string.
    // This gives us the non-palindromic part that needs to be inserted.

    // Tabulation
    public static int insertions(String str){
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
        return str.length()-dp[str.length()][str2.length()];
    }

    // Space Optimization
    public static int insertions1(String str){
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
        return str.length()-prev[str2.length()];
    }

    public static void main(String[] args) {
        String str="mbadm";
        System.out.println(insertions(str));
        System.out.println(insertions1(str));
    }
}
