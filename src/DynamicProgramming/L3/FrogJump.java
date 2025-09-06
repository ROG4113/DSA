package DynamicProgramming.L3;

public class FrogJump {
    // recursion TC-> O(n) SC-> O(n)+O(n)
    public static int jump(int n, int[] arr){
        if(n==0){
            return 0;
        }
        int left=jump(n-1, arr) + Math.abs(arr[n]-arr[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1){
            right=jump(n-2, arr) + Math.abs(arr[n]-arr[n-2]);
        }
        return Math.min(left, right);
    }

    // memoization TC-> O(n) SC-> O(n)+O(n)
    public static int jump1(int n, int[] arr, int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int left=jump1(n-1, arr, dp) + Math.abs(arr[n]-arr[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1){
            right=jump(n-2, arr) + Math.abs(arr[n]-arr[n-2]);
        }
        return dp[n]=Math.min(left, right);
    }

    // tabulation TC-> O(n) SC-> O(n)
    public static int jump2(int n, int[] arr, int[] dp){
        dp[0]=0;
        for(int i=1; i<=n; i++){
            int fs=dp[i-1]+Math.abs(arr[i-1]-arr[i]);
            int ss=Integer.MAX_VALUE;
            if(i>1){
                ss=dp[i-2]+Math.abs(arr[i-2]-arr[i]);
            }
            dp[i]=Math.min(fs, ss);
        }
        return dp[n];
    }

    // tabulation(optimized for space complexity) TC-> O(n) SC-> O(1)
    public static int jump3(int n, int[] arr){
        int prev=0;
        int prev2=0;
        for(int i=1; i<=n; i++){
            int fs=prev+Math.abs(arr[i-1]-arr[i]);
            int ss=Integer.MAX_VALUE;
            if(i>1){
                ss=prev2+Math.abs(arr[i-2]-arr[i]);
            }
            prev2=prev;
            prev=Math.min(fs, ss);
        }
        return prev;
    }

    public static void main(String[] args){
        int n=5;
        int[] dp=new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i]=-1;
        }
        int[] arr=new int[]{30, 10, 60, 10, 60, 50};
        // int ans=jump(n, arr);
        // int ans=jump1(n, arr, dp);
        // int ans=jump2(n, arr, dp);
        int ans=jump3(n, arr);
        System.out.println(ans);
    }
}
