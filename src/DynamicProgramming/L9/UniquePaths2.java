package DynamicProgramming.L9;

import java.util.Arrays;

public class UniquePaths2 {
    // recursion TC-> O(2^m+n) SC-> O(m+n)
    public static int path(int[][] paths, int row, int col){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }
        if(paths[row][col]==1){
            return 0;
        }
        int left=path(paths, row-1, col);
        int right=path(paths, row, col-1);
        return left+right;
    }

    // memoization TC-> O(m*n) SC-> O(m*n)
    public static int path1(int[][] paths, int[][] dp, int row, int col){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }
        if(paths[row][col]==1){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int left=path1(paths, dp, row-1, col);
        int right=path1(paths, dp, row, col-1);
        return dp[row][col]=left+right;
    }

    // tabulation TC-> O(m*n) SC-> O(m*n)
    public static int path2(int[][] paths, int[][] dp){
        dp[0][0]=1;
        for(int i=0; i<paths.length; i++){
            for(int j=0; j<paths[0].length; j++){
                int up=0, left=0;
                if(i==0 && j==0) dp[0][0]=1;
                else{
                    if(paths[i][j]!=1){
                        if(i>0){
                            up=dp[i-1][j];
                        }
                        if(j>0){
                            left=dp[i][j-1];
                        }
                    }
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[paths.length-1][paths[0].length-1];
    }

    // tabulation(space optimized) TC-> O(m*n) SC-> O(n)
    public static int path3(int[][] paths, int[] prev){
        for(int i=0; i<paths.length; i++){
            int[] cur=new int[paths[0].length];
            for(int j=0; j<paths[0].length; j++){
                int up=0, left=0;
                if(i==0 && j==0) cur[0]=1;
                else{
                    if(paths[i][j]!=1){
                        if(i>0){
                            up=prev[j];
                        }
                        if(j>0){
                            left=cur[j-1];
                        }
                    }
                    cur[j]=up+left;
                }
            }
            prev=cur;
        }
        return prev[paths[0].length-1];
    }

    public static void main(String[] args){
        int[][] paths=new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int ans=path(paths, 2, 2);
        int[][] dp=new int[paths.length][paths[0].length];
        for(int[] arr:dp) Arrays.fill(arr, -1);
        int ans1=path1(paths, dp, 2, 2);
        for(int[] arr:dp) Arrays.fill(arr, -1);
        int ans2=path2(paths, dp);
        int[] prev=new int[paths[0].length];
        int ans3=path3(paths, prev);
        System.out.println(ans + " " + ans1 + " " + ans2 + " " + ans3);
    }
}
