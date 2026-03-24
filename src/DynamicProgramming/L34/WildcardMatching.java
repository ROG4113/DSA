package DynamicProgramming.L34;

import java.util.Arrays;

public class WildcardMatching {
    // recursion
    public static boolean matching(String s, String p, int ind1, int ind2){
        if(ind1<0 || ind2<0){
            if(ind1<0 && ind2<0){
                return true;
            }
            else if(ind1<0){
                for(int i=0; i<=ind2; i++){
                    if(p.charAt(i)!='*'){
                        return false;
                    }
                }
                return true;
            }
            else{
                return false;
            }
        }
        if(s.charAt(ind1)==p.charAt(ind2) || p.charAt(ind2)=='?'){
            return matching(s, p, ind1-1, ind2-1);            
        }
        if(p.charAt(ind2)=='*'){
            return matching(s, p, ind1, ind2-1) || matching(s, p, ind1-1, ind2);
        }
        return false;
    }
    
    // memoization
    public static boolean matching1(int[][] dp, String s, String p, int ind1, int ind2){
        if(ind1<0 || ind2<0){
            if(ind1<0 && ind2<0){
                return true;
            }
            else if(ind1<0){
                for(int i=0; i<=ind2; i++){
                    if(p.charAt(i)!='*'){
                        return false;
                    }
                }
                return true;
            }
            else{
                return false;
            }
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2]==1?true:false;
        }
        if(s.charAt(ind1)==p.charAt(ind2) || p.charAt(ind2)=='?'){
            boolean ans=matching1(dp, s, p, ind1-1, ind2-1);
            if(ans==true){
                dp[ind1][ind2]=1;
            }
            else{
                dp[ind1][ind2]=0;
            }
            return ans;
        }
        if(p.charAt(ind2)=='*'){
            boolean ans=matching1(dp, s, p, ind1, ind2-1) || matching1(dp, s, p, ind1-1, ind2);
            if(ans==true){
                dp[ind1][ind2]=1;
            }
            else{
                dp[ind1][ind2]=0;
            }
            return ans;
        }
        dp[ind1][ind2]=0;
        return false;
    }

    // tabulation
    public static boolean matching2(String s, String p){
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        for(int j=1; j<=p.length(); j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=true;
            }
            else{
                break;
            }
        }
        dp[0][0]=true;
        for(int ind1=1; ind1<=s.length(); ind1++){
            for(int ind2=1; ind2<=p.length(); ind2++){
                if(s.charAt(ind1-1)==p.charAt(ind2-1) || p.charAt(ind2-1)=='?'){
                    dp[ind1][ind2]=dp[ind1-1][ind2-1];
                }
                else if(p.charAt(ind2-1)=='*'){
                    dp[ind1][ind2]=dp[ind1-1][ind2]||dp[ind1][ind2-1];
                }
                else{
                    dp[ind1][ind2]=false;
                }
            }
        }
        return dp[s.length()][p.length()];
    };

    // space optimization
    public static boolean matching3(String s, String p){
        boolean[] prev=new boolean[p.length()+1];
        for(int j=1; j<=p.length(); j++){
            if(p.charAt(j-1)=='*'){
                prev[j]=true;
            }
            else{
                break;
            }
        }
        prev[0]=true;
        for(int ind1=1; ind1<=s.length(); ind1++){
            boolean[] curr=new boolean[p.length()+1];
            for(int ind2=1; ind2<=p.length(); ind2++){
                if(s.charAt(ind1-1)==p.charAt(ind2-1) || p.charAt(ind2-1)=='?'){
                    curr[ind2]=prev[ind2-1];
                }
                else if(p.charAt(ind2-1)=='*'){
                    curr[ind2]=prev[ind2]||curr[ind2-1];
                }
                else{
                    curr[ind2]=false;
                }
            }
            prev=curr;
        }
        return prev[p.length()];
    };

    public static void main(String[] args) {
        String s="aa";
        String p="*";
        System.out.println(matching(s, p, s.length()-1, p.length()-1));
        int[][] dp=new int[s.length()][p.length()];
        for(int[] oneD:dp){
            Arrays.fill(oneD, -1);
        }
        System.out.println(matching1(dp, s, p, s.length()-1, p.length()-1));
        System.out.println(matching2(s, p));
        System.out.println(matching3(s, p));
    }
}
