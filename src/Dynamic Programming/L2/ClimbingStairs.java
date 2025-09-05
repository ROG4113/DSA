package L2;

public class ClimbingStairs {

    // memoization TC-> O(n) SC-> O(n)+O(n)
    public static int climb(int n, int[] dp){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int left=climb(n-1, dp);
        int right=climb(n-2, dp);
        return left+right;
    }

    // tabulation TC-> O(n) SC-> O(n)
    public static int climb1(int n, int[] dp){
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    // tabulation TC-> O(n) SC-> O(1)
    public static int climb2(int n, int[] dp){
        int prev=1;
        int prev2=1;
        for(int i=2; i<=n; i++){
            int curi=prev+prev2;
            prev2=prev;
            prev=curi;
        }
        return prev;
    }

    public static void main(String[] args){
        int n=3;
        int[] dp=new int[n+1];
        for(int i=0; i<dp.length; i++){
            dp[i]=-1;
        }
        // int ans=climb(n, dp);
        // int ans=climb1(n, dp);
        int ans=climb2(n, dp);
        System.out.println(ans);
    }
}
