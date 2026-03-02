package DynamicProgramming.L26;

import java.util.Arrays;

public class PrintLCS {
    public static String print(String str1, String str2){
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
        for(int[] oneD:dp){
            System.out.println(Arrays.toString(oneD));
        }
        StringBuilder sb=new StringBuilder();
        int n=str1.length(), m=str2.length();
        while(n>0 && m>0){
            if(str1.charAt(n-1)==str2.charAt(m-1)){
                sb.append(str1.charAt(n-1));
                n--;
                m--;
            }
            else if(dp[n-1][m]>=dp[n][m-1]){
                n--;
            }
            else{
                m--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1="acd";
        String str2="ced";
        System.out.println(print(str1, str2));
    }
}
