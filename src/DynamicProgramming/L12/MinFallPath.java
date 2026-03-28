package DynamicProgramming.L12;

import java.util.Arrays;

public class MinFallPath {
    // recursion (0, j) to (m-1, j)
    public static int fall(int[][] nums, int row, int col){
        if(row==nums.length-1){
            return nums[row][col];
        }
        int down=Integer.MAX_VALUE, dLeft=Integer.MAX_VALUE, dRight=Integer.MAX_VALUE;
        if(col>0) dLeft=nums[row][col]+fall(nums, row+1, col-1);
        down=nums[row][col]+fall(nums, row+1, col);
        if(col<nums[0].length-1) dRight=nums[row][col]+fall(nums, row+1, col+1);
        return Math.min(down, Math.min(dLeft, dRight));
    }

    // recursion (m-1, j) to (0, j) TC-> O(3^n), SC-> O(n)
    public static int fall1(int[][] nums, int row, int col){
        if(row==0){
            return nums[row][col];
        }
        int up=Integer.MAX_VALUE, uLeft=Integer.MAX_VALUE, uRight=Integer.MAX_VALUE;
        if(col>0) uLeft=nums[row][col]+fall1(nums, row-1, col-1);
        up=nums[row][col]+fall1(nums, row-1, col);
        if(col<nums[0].length-1) uRight=nums[row][col]+fall1(nums, row-1, col+1);
        return Math.min(up, Math.min(uLeft, uRight));
    }

    // memoization (m-1, j) to (0, j) TC-> O(n*m), SC-> O(n*m) + O(n)
    public static int fall2(int[][] nums, int[][] dp, int row, int col){
        if(row==0){
            return nums[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int up=Integer.MAX_VALUE, uLeft=Integer.MAX_VALUE, uRight=Integer.MAX_VALUE;
        if(col>0) uLeft=nums[row][col]+fall2(nums, dp, row-1, col-1);
        up=nums[row][col]+fall2(nums, dp, row-1, col);
        if(col<nums[0].length-1) uRight=nums[row][col]+fall2(nums, dp, row-1, col+1);
        return dp[row][col]=Math.min(up, Math.min(uLeft, uRight));
    }

    // tabulation TC-> O(n*m), SC-> O(n*m) + O(m)
    public static int fall3(int[][] nums){
        int[][] dp=new int[nums.length][nums[0].length];
        for(int j=0; j<nums[0].length; j++){
            dp[0][j]=nums[0][j];
        }
        for(int row=1; row<nums.length; row++){
            for(int col=0; col<nums[0].length; col++){
                int down=Integer.MAX_VALUE, dLeft=Integer.MAX_VALUE, dRight=Integer.MAX_VALUE;
                if(col>0) dLeft=nums[row][col]+dp[row-1][col-1];
                down=nums[row][col]+dp[row-1][col];
                if(col<nums[0].length-1) dRight=nums[row][col]+dp[row-1][col+1];
                dp[row][col]=Math.min(down, Math.min(dLeft, dRight));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0; j<nums[0].length; j++){
            min=Math.min(min, dp[nums.length-1][j]);
        }
        return min;
    }

    // tabulation(space optimization) TC-> O(n*m), SC-> O(m)
    public static int fall4(int[][] nums){
        int[] prev=new int[nums[0].length];
        for(int j=0; j<nums[0].length; j++){
            prev[j]=nums[0][j];
        }
        for(int row=1; row<nums.length; row++){
            int[] cur=new int[nums[0].length];
            for(int col=0; col<nums[0].length; col++){
                int down=Integer.MAX_VALUE, dLeft=Integer.MAX_VALUE, dRight=Integer.MAX_VALUE;
                if(col>0) dLeft=nums[row][col]+prev[col-1];
                down=nums[row][col]+prev[col];
                if(col<nums[0].length-1) dRight=nums[row][col]+prev[col+1];
                cur[col]=Math.min(down, Math.min(dLeft, dRight));
            }
            prev=cur;
        }
        int min=Integer.MAX_VALUE;
        for(int j=0; j<nums.length; j++){
            min=Math.min(min, prev[j]);
        }
        return min;
    }

    public static void main(String[] args){
        int[][] nums=new int[][]{{-19, 57}, {-40, -5}}; // {2, 1, 3}, {6, 5, 4}, {7, 8, 9}, {-19, 57}, {-40, -5}
        int ans=Integer.MAX_VALUE;
        for(int j=0; j<nums[0].length; j++){
            ans=Math.min(ans, fall(nums, 0, j));
        }

        int ans1=Integer.MAX_VALUE;
        for(int j=0; j<nums[0].length; j++){
            ans1=Math.min(ans1, fall1(nums, nums.length-1, j));
        }

        int ans2=Integer.MAX_VALUE;
        int[][] dp=new int[nums.length][nums[0].length];
        for(int[] arr:dp) Arrays.fill(arr, -1);
        for(int j=0; j<nums[0].length; j++){
            ans2=Math.min(ans2, fall2(nums, dp, nums.length-1, j));
        }

        int ans3=fall3(nums);

        int ans4=fall4(nums);

        System.out.println(ans + " " + ans1 + " " + ans2 + " " + ans3 + " " + ans4);
    }
}