package DynamicProgramming.L8;

public class UniquePaths {
    //recursiion TC-> O(2^n*m), SC-> O(m*n)
    public static int path(int row, int col){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }
        int left=path(row-1, col);
        int right=path(row, col-1);
        return left+right;
    }

    //recursion TC-> O(n*m), SC-> O((m-1)+(n-1))+O(m*n)
    public static int path1(int[][] dp, int row, int col){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }
        if(dp[row][col]!=-1){
            return  dp[row][col];
        }
        int left=path1(dp, row-1, col);
        int right=path1(dp, row, col-1);
        return left+right;
    }

    //tabulation TC-> O(m*n), SC-> O(m*n)
    public static int path2(int[][] dp, int row, int col){
        dp[0][0]=1;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }
                else{
                    int up=0, left=0;
                    if(i>0){
                        up=dp[i-1][j];
                    }
                    if(j>0){
                        left=dp[i][j-1];
                    }
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[row-1][col-1];
    }

    //tabulation(space optimized) TC-> O(m*n), SC-> O(m*n)
    public static int path3(int[] prev, int row, int col){
        prev[0]=1;
        for(int i=0; i<row; i++){
            int[] temp=new int[prev.length];
            for(int j=0; j<col; j++){
                if(i==0 && j==0){
                    temp[j]=1;
                }
                else{
                    int up=0, left=0;
                    if(i>0){
                        up=prev[j];
                    }
                    if(j>0){
                        left=temp[j-1];
                    }
                    temp[j]=up+left;
                }
            }
            prev=temp;
        }
        return prev[col-1];
    }

    public static void main(String[] args){
        int[][] dp=new int[][]{{-1, -1}, {-1, -1}};
        int ans=path(1, 1);
        int ans1=path1(dp, 1, 1);
        int ans2=path2(dp, 2, 2);
        int[] dp1=new int[]{-1, -1};
        int ans3=path3(dp1, 2, 2);
        System.out.println(ans + " " + ans1 + " " + ans2 + " " + ans3);
    }
}
