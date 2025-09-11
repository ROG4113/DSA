package DynamicProgramming.L7;

import java.util.Arrays;

class NinjaTraining{
    // recursion TC->O(2^n) SC->O(n)
    public static int ninja(int[][] points, int day, int last){
        if(day==0){
            int maxi=0;
            for(int i=0; i<=2; i++){
                if(i!=last){
                    maxi=Math.max(maxi, points[day][i]);
                }
            }
            return maxi;
        }
        int maxi=0;
        for(int i=0; i<=2; i++){
            if(i!=last){
                int point=points[day][i]+ninja(points, day-1, i);
                maxi=Math.max(maxi, point);
            }
        }
        return maxi;
    }

    // memoization TC->O(n) SC->O(n)+O(n)
    public static int ninja1(int[][] points, int[][] dp, int day, int last){
        if(day==0){
            int maxi=0;
            for(int i=0; i<=2; i++){
                if(i!=last){
                    maxi=Math.max(maxi, points[day][i]);
                }
            }
            return maxi;
        }
        if(dp[day][last]!=-1){
            return dp[day][last];
        }
        int maxi=0;
        for(int i=0; i<=2; i++){
            if(i!=last){
                int point=points[day][i]+ninja1(points, dp, day-1, i);
                maxi=Math.max(maxi, point);
            }
        }
        return dp[day][last]=maxi;
    }

    // tabulation TC->O(n*4*3) SC->O(n*4)
    public static int ninja2(int[][] points, int[][] dp){
        dp[0][0]=Math.max(points[0][1], points[0][2]);
        dp[0][1]=Math.max(points[0][0], points[0][2]);
        dp[0][2]=Math.max(points[0][0], points[0][1]);
        dp[0][3]=Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for(int d=1; d<points.length; d++){
            for(int last=0; last<=3; last++){
                dp[d][last]=0;
                for(int task=0; task<=2; task++){
                    if(task!=last){
                        int point=points[d][task]+dp[d-1][task];
                        dp[d][last]=Math.max(dp[d][last], point);
                    }
                }
            }
        }
        return dp[points.length-1][3];
    }

    // tabulation(space optimized) TC->O(n*4*3) SC->O(4)
    public static int ninja3(int[][] points, int[] prev){
        prev[0]=Math.max(points[0][1], points[0][2]);
        prev[1]=Math.max(points[0][0], points[0][2]);
        prev[2]=Math.max(points[0][0], points[0][1]);
        prev[3]=Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for(int d=1; d<points.length; d++){
            int[] temp=new int[prev.length];
            for(int last=0; last<=3; last++){
                for(int task=0; task<=2; task++){
                    if(task!=last){
                        int point=points[d][task]+prev[task];
                        temp[last]=Math.max(temp[last], point);
                    }
                }
            }
            prev=temp;
        }
        return prev[3];
    }

    public static void main(String[] args){
        int day=3, last=3;
        int[][] points=new int[][]{{2, 1, 3}, {3, 4, 6}, {10, 1, 3}, {8, 3, 7}}; // N*3
        int n=points.length;
        int[][] dp=new int[n][4];
        for(int[] i:dp){
            Arrays.fill(i, -1);
        }
        int ans=ninja(points, day, last);
        int ans1=ninja1(points, dp, day, last);
        int ans2=ninja2(points, dp);
        int[] prev=new int[4];
        int ans3=ninja3(points, prev);
        System.out.println(ans + " " + ans1 + " " + ans2 + " " + ans3);
    }
}