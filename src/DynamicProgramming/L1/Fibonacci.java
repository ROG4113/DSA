package DynamicProgramming.L1;

class Fibonacci{
    // memoization TC-> O(n) SC-> O(n) + O(n)
    public static int fibo(int n, int[] dp){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=fibo(n-1, dp)+fibo(n-2, dp);
    }
    
    // tabulation TC-> O(n) SC-> O(n)
    public static int fibo2(int n, int[] dp){
        dp[1]=1;
        dp[0]=0;
        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    // tabulation(optimized for space complexity) TC-> O(n) SC-> O(1)
    public static int fibo3(int n){
        int prev=1;
        int prev2=0;
        for(int i=2; i<=n; i++){
            int curi=prev+prev2;
            prev2=prev;
            prev=curi;
        }
        return prev;
    }
    public static void main(String[] args){
        int n=5;
        int[] dp=new int[n+1];
        for(int i=0; i<dp.length; i++){
            dp[i]=-1;
        }
        // int ans=fibo(n, dp);
        // int ans=fibo2(n, dp);
        int ans=fibo3(n);
        System.out.println(ans);
    }
}