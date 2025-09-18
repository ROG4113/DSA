package DynamicProgramming.L13;

import java.util.Arrays;

public class NinjaFriends {
    // recursion TC-> O(3^n*3^n) SC-> O(n)
    public static int ninja(int[][] nums, int row, int aCol, int bCol){
        if(aCol<0 || aCol>=nums[0].length || bCol<0 || bCol>=nums[0].length){
            return (int)-1e8;
        }
        if(row==nums.length-1){
            if(aCol!=bCol){
                return nums[row][aCol]+nums[row][bCol];
            }
            else{
                return nums[row][aCol];
            }
        }
        int maxi=Integer.MIN_VALUE;
        for(int d1=-1; d1<=1; d1++){
            for(int d2=-1; d2<=1; d2++){
                if(aCol==bCol){
                    maxi=Math.max(maxi, nums[row][aCol]+ninja(nums, row+1, aCol+d1, bCol+d2));
                }
                else{
                    maxi=Math.max(maxi, nums[row][aCol] + nums[row][bCol] + ninja(nums, row+1, aCol+d1, bCol+d2));
                }
            }
        }
        return maxi;
    }

    // memoization TC-> O(3^n*3^n) SC-> O(n)
    public static int ninja1(int[][] nums, int[][][] dp, int row, int aCol, int bCol){
        if(aCol<0 || aCol>=nums[0].length || bCol<0 || bCol>=nums[0].length){
            return (int)-1e8;
        }
        if(row==nums.length-1){
            if(aCol!=bCol){
                return nums[row][aCol]+nums[row][bCol];
            }
            else{
                return nums[row][aCol];
            }
        }
        if(dp[row][aCol][bCol]!=-1){
            return dp[row][aCol][bCol]; 
        }
        int maxi=(int)-1e8;
        for(int d1=-1; d1<=1; d1++){
            for(int d2=-1; d2<=1; d2++){
                if(aCol==bCol){
                    maxi=Math.max(maxi, nums[row][aCol]+ninja1(nums, dp, row+1, aCol+d1, bCol+d2));
                }
                else{
                    maxi=Math.max(maxi, nums[row][aCol] + nums[row][bCol] + ninja1(nums, dp, row+1, aCol+d1, bCol+d2));
                }
            }
        }
        return dp[row][aCol][bCol]=maxi;
    }

    // tabulation
    public static int ninja2(int[][] nums){
        int[][][] dp=new int[nums.length][nums[0].length][nums[0].length];
        for(int[][] twoD:dp){
            for(int[] oneD:twoD){
                Arrays.fill(oneD, -1);
            }
        }
        for(int aCol=0; aCol<nums[0].length; aCol++){
            for(int bCol=0; bCol<nums[0].length; bCol++){
                if(aCol==bCol){
                    dp[nums.length-1][aCol][bCol]=nums[nums.length-1][aCol];
                }
                else{
                    dp[nums.length-1][aCol][bCol]=nums[nums.length-1][aCol]+nums[nums.length-1][bCol];
                }
            }
        }
        for(int row=nums.length-2; row>=0; row--){
            for(int aCol=0; aCol<nums[0].length; aCol++){
                for(int bCol=0; bCol<nums[0].length; bCol++){
                    int maxi=(int)-1e8;
                    for(int d1=-1; d1<=1; d1++){
                        for(int d2=-1; d2<=1; d2++){
                            int value=0;
                            if(aCol==bCol){
                                value=nums[row][aCol];
                            }
                            else{
                                value=nums[row][aCol] + nums[row][bCol];
                            }
                            if(aCol+d1<0 || aCol+d1>=nums[0].length || bCol+d2<0 || bCol+d2>=nums[0].length){
                                value=value+(int)-1e8;
                            }
                            else{
                                value+=dp[row+1][aCol+d1][bCol+d2];
                            }
                            maxi=Math.max(maxi, value);
                            dp[row][aCol][bCol]=maxi;
                        }
                    }
                }
            }
        }
        return dp[0][0][nums[0].length-1];
    }

    // tabulation(space optimization)
    public static int ninja3(int[][] nums){
        int[][] front=new int[nums[0].length][nums[0].length];
        for(int[] oneD:front){
            Arrays.fill(oneD, -1);
        }
        for(int aCol=0; aCol<nums[0].length; aCol++){
            for(int bCol=0; bCol<nums[0].length; bCol++){
                if(aCol==bCol){
                    front[aCol][bCol]=nums[nums.length-1][aCol];
                }
                else{
                    front[aCol][bCol]=nums[nums.length-1][aCol]+nums[nums.length-1][bCol];
                }
            }
        }
        for(int row=nums.length-2; row>=0; row--){
            int[][] cur=new int[nums[0].length][nums[0].length];
            for(int aCol=0; aCol<nums[0].length; aCol++){
                for(int bCol=0; bCol<nums[0].length; bCol++){
                    int maxi=(int)-1e8;
                    for(int d1=-1; d1<=1; d1++){
                        for(int d2=-1; d2<=1; d2++){
                            int value=0;
                            if(aCol==bCol){
                                value=nums[row][aCol];
                            }
                            else{
                                value=nums[row][aCol] + nums[row][bCol];
                            }
                            if(aCol+d1<0 || aCol+d1>=nums[0].length || bCol+d2<0 || bCol+d2>=nums[0].length){
                                value=value+(int)-1e8;
                            }
                            else{
                                value+=front[aCol+d1][bCol+d2];
                            }
                            maxi=Math.max(maxi, value);
                        }
                    }
                    cur[aCol][bCol]=maxi;
                }
            }
            front=cur;
        }
        return front[0][nums[0].length-1];
    }

    public static void main(String[] args){
        int[][] nums=new int[][]{{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};

        int ans=ninja(nums, 0, 0, nums[0].length-1);

        int[][][] dp=new int[nums.length][nums[0].length][nums[0].length];
        for(int[][] twoD:dp){
            for(int[] oneD:twoD){
                Arrays.fill(oneD, -1);
            }
        }
        int ans1=ninja1(nums, dp, 0, 0, nums[0].length-1);

        int ans2=ninja2(nums);

        int ans3=ninja3(nums);

        System.out.println(ans + " " + ans1 + " " + ans2 + " " + ans3);
    }
}