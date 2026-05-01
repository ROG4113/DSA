package DynamicProgramming.L49;

public class MCM {
    public static int minOperations(int[] nums){
        int[][] dp=new int[nums.length][nums.length];
        for(int i=nums.length-1; i>=1; i--){
            for(int j=i+1; j<nums.length; j++){
                int min=Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int steps=(nums[i-1]*nums[k]*nums[j])
                        +(dp[i][k]+dp[k+1][j]);
                        
                    min=Math.min(min, steps);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums=new int[]{10, 20, 30, 40, 50};
        System.out.println(minOperations(nums));
    }
}
