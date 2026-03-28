package DynamicProgramming.L10;

import java.util.Arrays;

public class MinimumPathSum {
    // recursion
    public static int min(int[][] paths, int row, int col){
        if(row==0 && col==0){
            return paths[row][col];
        }
        int up=Integer.MAX_VALUE, left=Integer.MAX_VALUE;
        if(row>=1) up=paths[row][col]+min(paths, row-1, col);
        if(col>=1) left=paths[row][col]+min(paths, row, col-1);
        return Math.min(up, left);
    }

    // memoization
    public static int min1(int[][] paths, int[][] dp, int row, int col){
        if(row==0 && col==0){
            return paths[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int up=Integer.MAX_VALUE, left=Integer.MAX_VALUE;
        if(row>=1) up=paths[row][col]+min1(paths, dp, row-1, col);
        if(col>=1) left=paths[row][col]+min1(paths, dp, row, col-1);
        return dp[row][col]=Math.min(up, left);
    }

    // tabulation
    public static int min2(int[][] paths, int[][] dp){
        dp[0][0]=paths[0][0];
        for(int i=0; i<paths.length; i++){
            for(int j=0; j<paths[0].length; j++){
                int up=Integer.MAX_VALUE, left=Integer.MAX_VALUE;
                if(i==0 && j==0){
                    dp[0][0]=paths[0][0];
                }
                else{
                    if(i>0) up=paths[i][j]+dp[i-1][j];
                    if(j>0) left=paths[i][j]+dp[i][j-1];
                    dp[i][j]=Math.min(up, left);
                }
            }
        }
        return dp[paths.length-1][paths[0].length-1];
    }

    // tabulation(space optimized)
    public static int min3(int[][] paths, int[] prev){
        // prev[0]=paths[0][0];
        for(int i=0; i<paths.length; i++){
            int[] cur=new int[paths[0].length];
            for(int j=0; j<paths[0].length; j++){
                int up=Integer.MAX_VALUE, left=Integer.MAX_VALUE;
                if(i==0 && j==0){
                    cur[0]=paths[0][0];
                }
                else{
                    if(i>0) up=paths[i][j]+prev[j];
                    if(j>0) left=paths[i][j]+cur[j-1];
                    cur[j]=Math.min(up, left);
                }
            }
            prev=cur;
        }
        return prev[paths[0].length-1];
    }

    public static void main(String[] args){
        int[][] paths=new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int ans=min(paths, paths.length-1, paths[0].length-1);
        int[][] dp=new int[paths.length][paths[0].length];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        int ans1=min1(paths, dp, paths.length-1, paths[0].length-1);
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        int ans2=min2(paths, dp);
        int[] prev=new int[paths[0].length];
        int ans3=min3(paths, prev);
        System.out.println(ans + " " + ans1 + " " + ans2 + " " + ans3);
    }
}
