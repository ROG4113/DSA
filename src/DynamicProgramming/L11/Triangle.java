package DynamicProgramming.L11;

import java.util.Arrays;

public class Triangle {
    // recursion(wrote all by myself) from m-1 to 0
    public static int triangle(int[][] nums, int row, int col){
        if(row==0 && col==0){
            return nums[row][col];
        }
        int same=Integer.MAX_VALUE, prev=Integer.MAX_VALUE;
        if(row>0 && col<nums[row-1].length) same=nums[row][col]+triangle(nums, row-1, col);
        if(col>0) prev=nums[row][col]+triangle(nums, row-1, col-1);
        return Math.min(same, prev);
    }

    // recursion((0,0) to (m-1, n-1))
    public static int triangle1(int[][] nums, int row, int col){
        if(row==nums.length-1){
            return nums[row][col];
        }
        int down=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
        down=nums[row][col]+triangle1(nums, row+1, col);
        right=nums[row][col]+triangle1(nums, row+1, col+1);
        return Math.min(down, right);
    }

    // memoization
    public static int triangle2(int[][] nums, int[][] dp, int row, int col){
        if(row==nums.length-1){
            return nums[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int down=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
        down=nums[row][col]+triangle2(nums, dp, row+1, col);
        right=nums[row][col]+triangle2(nums, dp, row+1, col+1);
        return dp[row][col]=Math.min(down, right);
    }

    // tabulation
    public static int triangle3(int[][] nums, int[][] dp){
        for(int col=0; col<nums[nums.length-1].length; col++){
            dp[nums.length-1][col]=nums[nums.length-1][col];
        }
        for(int row=nums.length-2; row>=0; row--){
            for(int col=0; col<nums[row].length; col++){
                int down=nums[row][col]+dp[row+1][col];
                int right=nums[row][col]+dp[row+1][col+1];
                dp[row][col]=Math.min(down, right);
            }
        }
        return dp[0][0];
    }

    // tabulation(space optimized)
    public static int triangle4(int[][] nums){
        int[] prev=new int[nums[nums.length-1].length];
        for(int col=0; col<nums[nums.length-1].length; col++){
            prev[col]=nums[nums.length-1][col];
        }
        for(int row=nums.length-2; row>=0; row--){
            int[] cur=new int[nums[row].length];
            for(int col=0; col<nums[row].length; col++){
                int down=nums[row][col]+prev[col];
                int right=nums[row][col]+prev[col+1];
                cur[col]=Math.min(down, right);
            }
            prev=cur;
        }
        return prev[0];
    }

    public static void main(String[] args){
        int[][] nums=new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<nums[nums.length-1].length; i++){
            ans=Math.min(ans,triangle(nums, nums.length-1, i));
        }

        int ans1=triangle1(nums, 0, 0);

        int[][] dp=new int[nums.length][nums[nums.length-1].length];
        for(int[] arr:dp) Arrays.fill(arr, -1);
        int ans2=triangle2(nums, dp, 0, 0);

        for(int[] arr:dp) Arrays.fill(arr, -1);
        int ans3=triangle3(nums, dp);
        
        int ans4=triangle4(nums);

        System.out.println(ans + " " + ans1 + " " + ans2 + " " + ans3 + " " + ans4);
    }
}
