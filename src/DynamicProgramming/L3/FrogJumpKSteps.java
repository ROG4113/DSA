package DynamicProgramming.L3;

public class FrogJumpKSteps {
    // recursion TC-> O(n) SC-> O(n)+O(n)
    public static int jump(int[] arr, int n, int k){
        if(n==0){
            return 0;
        }
        int minSteps=Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(n-i>=0){
                int steps=jump(arr, n-i, k)+Math.abs(arr[n]-arr[n-i]);
                minSteps=Math.min(minSteps, steps);
            }
        }
        return minSteps;
    }
    
    // memoization TC-> O(n) SC-> O(n)+O(n)
    public static int jump1(int[] arr,  int[] dp, int n, int k){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int minSteps=Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            if(n-i>=0){
                int steps=jump1(arr, dp, n-i, k)+Math.abs(arr[n]-arr[n-i]);
                minSteps=Math.min(minSteps, steps);
            }
        }
        return dp[n]=minSteps;
    }

    // recursion TC-> O(n) SC-> O(n)
    public static int jump2(int[] arr, int[] dp, int n, int k){
        dp[0]=0;
        for(int i=1; i<=n; i++){
            int minSteps=Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i-j>=0){
                    int steps=dp[i-j]+Math.abs(arr[i]-arr[i-j]);
                    minSteps=Math.min(minSteps, steps);
                }
                dp[i]=minSteps;
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        int n=5, k=2;
        int[] dp=new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i]=-1;
        }
        int[] arr=new int[]{30, 10, 60, 10, 60, 50};
        int ans=jump(arr, n, k);
        int ans1=jump1(arr, dp, n, k);
        int ans2=jump1(arr, dp, n, k);
        System.out.println(ans + " " + ans1 + " " + ans2);
    }
}
